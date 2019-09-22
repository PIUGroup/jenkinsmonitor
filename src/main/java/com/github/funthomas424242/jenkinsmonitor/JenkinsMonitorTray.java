package com.github.funthomas424242.jenkinsmonitor;

/*-
 * #%L
 * Jenkins Monitor
 * %%
 * Copyright (C) 2019 PIUG
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

import java.awt.*;

public class JenkinsMonitorTray {

    protected final Configuration configuration;
    protected SystemTrayWrapper tray;

    protected JobBeschreibung[] jobBeschreibungen;

    protected JenkinsMonitorTray() {
        this(new SystemTrayWrapper(), new Configuration());
    }

    protected JenkinsMonitorTray(final Configuration configuration) {
        this(new SystemTrayWrapper(), configuration);
    }

    protected JenkinsMonitorTray(SystemTrayWrapper systemTray, Configuration configuration) {
        this.configuration = configuration;
        //Obtain only one instance of the SystemTray object
        this.tray = systemTray;
    }


    protected TrayIcon getTrayIcon() {
        return this.tray.getTrayIcon();
    }

    protected void erzeugeDarstellung() {
        try {

            final ImageGenerator imageGenerator = new ImageGenerator(this.jobBeschreibungen);
            Image grayImage = imageGenerator.getImage(100, 100);

            TrayIcon trayIcon = new TrayIcon(grayImage, "No jobs watching");
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            //Set tooltip text for the tray icon
            trayIcon.setToolTip("No jobs watching");
            tray.add(trayIcon);

            // Display info notification:
            trayIcon.displayMessage("Hello, World", "Java Notification Demo", TrayIcon.MessageType.INFO);
            // Error:
            // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.ERROR);
            // Warning:
            // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.WARNING);
        } catch (Exception ex) {
            System.err.print(ex);
        }
    }

    protected void updateJobStatus(JobBeschreibung[] jobBeschreibungen) {
        this.jobBeschreibungen = jobBeschreibungen;
        updateDarstellung();
    }

    protected void updateDarstellung() {
        tray.remove(getTrayIcon());
        erzeugeDarstellung();
    }

}
