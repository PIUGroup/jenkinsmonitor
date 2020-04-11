package com.github.funthomas424242.jenkinsmonitor.gui;

/*-
 * #%L
 * Jenkins Monitor
 * %%
 * Copyright (C) 2019 - 2020 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */


import com.github.funthomas424242.jenkinsmonitor.etc.Counter;
import com.github.funthomas424242.jenkinsmonitor.jenkins.AbstractJobBeschreibung;
import com.github.funthomas424242.jenkinsmonitor.jenkins.JobStatus;
import com.github.funthomas424242.jenkinsmonitor.jenkins.JobStatusBeschreibung;
import com.github.funthomas424242.jenkinsmonitor.jenkins.JobStatusBeschreibungen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Statusfenster extends JWindow {
    public static final Logger LOGGER = LoggerFactory.getLogger(Statusfenster.class);

    public Statusfenster() {
    }

    public Statusfenster(final JobStatusBeschreibungen jobStatusBeschreibungen) {
        aktualisiereContentPane(jobStatusBeschreibungen);
    }


    private StatusItem createStatusItem(final int counter, JobStatusBeschreibung jobStatus) {
        final String colorValueHEX = jobStatus.getJobStatus().getColorValueHEX() != null ? jobStatus.getJobStatus().getColorValueHEX() : JobStatus.OTHER.getColorValueHEX();
        final String orderId = jobStatus.getJobOrderId() != null ? jobStatus.getJobOrderId() : "###";
        final String jobName = jobStatus.getJobName() != null ? jobStatus.getJobName() : "unbenannt";
        final String counterValue = counter + "";
        final String status = jobStatus.getJobStatus().toString() != null ? jobStatus.getJobStatus().toString() : "unbekannt";
        final String url = jobStatus.getJobUrl() != null ? jobStatus.getJobUrl().toString() : "<no url>";


        final String htmlTemplate = "<html><body style=\"display:inline-block;background-color:" + colorValueHEX + ";\"><h1>[" + orderId + "] " + jobName + "</h1>"
            + "<p>(" + counterValue + ") Status: " + status
            + " <a href=\"" + url + "\">" + url + "</a></p></body></html>";
        return new StatusItem(htmlTemplate, jobStatus.getJobUrl());
    }


    private Container createContentTmp(final JobStatusBeschreibungen jobsStatusBeschreibungen) {
        final JList<StatusItem> list = new JList();

        // Model füllen
        final List<StatusItem> statusItems = new ArrayList<>();
        final Counter counter = new Counter();
        AbstractJobBeschreibung.sortedStreamOf(jobsStatusBeschreibungen)
//            .keySet().stream().sorted().map(jobsStatusBeschreibungen::get)
            .forEach((jobStatus) -> {
                statusItems.add(createStatusItem(counter.value + 1, jobStatus));
                counter.value++;
            });

        // Layoutvorgaben
        final GridBagLayout layout = new GridBagLayout();
        list.setLayout(layout);
        final GridBagConstraints layoutVorgaben = new GridBagConstraints();
        layoutVorgaben.weightx = 1;
        layoutVorgaben.fill = GridBagConstraints.HORIZONTAL;
        layoutVorgaben.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(list, layoutVorgaben);

        // Daten setzen
        final DefaultListModel<StatusItem> listModel = new DefaultListModel<>();
        listModel.addAll(statusItems);
        list.setModel(listModel);

        // Selektion Modus
        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        final ListSelectionModel listSelectionModel = list.getSelectionModel();
        listSelectionModel.addListSelectionListener(
            new SharedListSelectionHandler(statusItems, this));

        // Scrollpane erzeugen
        final JScrollPane pane = new JScrollPane(list);
        final GoldsteinPanel panel = new GoldsteinPanel();
        final JPanel splitPane = new JPanel();
        splitPane.setLayout(new GridLayout(2, 1));
        splitPane.setOpaque(true);
        splitPane.add(pane);
        splitPane.add(panel);
        return splitPane;
    }

    public void aktualisiereContentPane(final JobStatusBeschreibungen jobsStatusBeschreibungen) {
        if (jobsStatusBeschreibungen != null && jobsStatusBeschreibungen.size() > 0) {
            setContentPane(createContentTmp(jobsStatusBeschreibungen));
            pack();
            repaint();
        }
    }

    public static void main(String args[]) {
        final JobStatusBeschreibungen jobstatusBeschreibungen = new JobStatusBeschreibungen();
        try {
            JobStatusBeschreibung jobstatusBeschreibungen0 = new JobStatusBeschreibung("job0", JobStatus.FAILURE, new URL("http://localhost/job0"), "0");
            jobstatusBeschreibungen.put(jobstatusBeschreibungen0.getPrimaryKey(), jobstatusBeschreibungen0);
            JobStatusBeschreibung jobstatusBeschreibungen1 = new JobStatusBeschreibung("job1", JobStatus.SUCCESS, new URL("http://localhost/sdfdfdfdfdffdfdff/hdjdjddjdjddhddhdhd/job1"), "1");
            jobstatusBeschreibungen.put(jobstatusBeschreibungen1.getPrimaryKey(), jobstatusBeschreibungen1);
            JobStatusBeschreibung jobstatusBeschreibungen2 = new JobStatusBeschreibung("job2", JobStatus.UNSTABLE, new URL("http://localhost/job2"), "2");
            jobstatusBeschreibungen.put(jobstatusBeschreibungen2.getPrimaryKey(), jobstatusBeschreibungen2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Statusfenster window = new Statusfenster();
        window.setAlwaysOnTop(true);
        window.setLocationByPlatform(false);
        window.aktualisiereContentPane(jobstatusBeschreibungen);
        window.setVisible(true);

        try {
            Thread.sleep(4000);
            JobStatusBeschreibung jobstatusBeschreibungen2a = new JobStatusBeschreibung("job2", JobStatus.OTHER, new URL("http://localhost/job2"), "2");
            jobstatusBeschreibungen.put(jobstatusBeschreibungen2a.getPrimaryKey(), jobstatusBeschreibungen2a);
        } catch (MalformedURLException | InterruptedException e) {
            e.printStackTrace();
        }
        window.aktualisiereContentPane(jobstatusBeschreibungen);

    }
}


class SharedListSelectionHandler implements ListSelectionListener {
    public static final Logger LOGGER = LoggerFactory.getLogger(SharedListSelectionHandler.class);

    protected final Statusfenster statusArea;
    protected final List<StatusItem> statusItems;

    public SharedListSelectionHandler(List<StatusItem> statusItems, final Statusfenster statusArea) {
        this.statusItems = statusItems;
        this.statusArea = statusArea;
    }

    public void valueChanged(ListSelectionEvent event) {
        final ListSelectionModel selectionModel = (ListSelectionModel) event.getSource();
        int firstIndex = event.getFirstIndex();
        int lastIndex = event.getLastIndex();
        boolean isAdjusting = event.getValueIsAdjusting();

        if (!selectionModel.isSelectionEmpty() && !isAdjusting) {
            // Find out which indexes are selected.
            int minIndex = selectionModel.getMinSelectionIndex();
            int maxIndex = selectionModel.getMaxSelectionIndex();

            final URI navigationURI;
            try {
                navigationURI = this.statusItems.get(minIndex).getNavigationURL().toURI();
                Desktop.getDesktop().browse(navigationURI);
                statusArea.setVisible(false);
            } catch (URISyntaxException | IOException e) {
                LOGGER.error(e.toString());
            }


        }
    }
}
