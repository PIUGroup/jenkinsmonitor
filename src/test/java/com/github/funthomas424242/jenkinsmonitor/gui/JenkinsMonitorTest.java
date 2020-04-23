package com.github.funthomas424242.jenkinsmonitor.gui;

/*-
 * #%L
 * jenkinsmonitor Example
 * %%
 * Copyright (C) 2018 - 2019 PIUG
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

import com.github.funthomas424242.jenkinsmonitor.JenkinsMonitor;
import com.github.funthomas424242.jenkinsmonitor.config.*;
import com.github.funthomas424242.jenkinsmonitor.jenkins.JenkinsAPIMock;
import com.github.funthomas424242.jenkinsmonitor.jenkins.JobStatus;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.github.funthomas424242.jenkinsmonitor.gui.TrayImageTestHelper.isImageOfColor;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("headfull")
public class JenkinsMonitorTest {

    protected WireMockServer wireMockServer;

    @BeforeEach
    public void setUp() {
        wireMockServer = new WireMockServer(8099);
        wireMockServer.start();
        JenkinsAPIMock.definiereAnnahmen(wireMockServer);
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }


    @Test
    @DisplayName("JenkinsMonitor ist Hauptklasse und enthält eine main Methode.")
    protected void checkMainMethod() {
        final String[] dummyArgs = {"Hallo", "Du da"};
        assertDoesNotThrow(() -> {
            JenkinsMonitor.main(dummyArgs);
        });

    }

    @Test
    @DisplayName("JenkinsMonitor ist Hauptklasse und enthält eine main Methode die auch ohne Argumente aufgerufen werden kann.")
    protected void checkMainEmptyParaMethod() {
        assertDoesNotThrow(() -> {
            JenkinsMonitor.main(null);
        });

    }


    @Test
    @DisplayName("JenkinsMonitor besitzt eine Tray Instanz nach seiner Erzeugung")
    protected void checkTrayInstanz() {

        final JenkinsMonitor monitor = new JenkinsMonitor(new ConfigurationMockNoExisting());
        assumeTrue(monitor != null);
        assertNotNull(monitor.getMonitorTray());
    }

    @Test
    @DisplayName("Initiale Konfiguration enthält keine JobBeschribungen")
    protected void initialConfigWithEmptyJobs() {
        final JenkinsMonitor jenkinsMonitor = new JenkinsMonitor(new ConfigurationMockNoExisting());
        assumeTrue(jenkinsMonitor.getMonitorTray() != null);
        assumeTrue(jenkinsMonitor.getMonitorTray().configuration != null);
        assertEquals(0, jenkinsMonitor.getMonitorTray().configuration.getJobBeschreibungen().size());
    }

    @Test
    @DisplayName("Tray Konfiguration ist identisch zur der dem JenkinsMonitor übergebenen")
    protected void equalsConfigWithTrayAndMonitor() {
        final Configuration config = new ConfigurationMockValidTwoJobs();
        final JenkinsMonitor jenkinsMonitor = new JenkinsMonitor(config);
        assertSame(config, jenkinsMonitor.getMonitorTray().configuration);
    }

    @Test
    @DisplayName("Nach Erzeugung besitzt der JenkinsMonitor ein Tray Icon")
    protected void afterInitTrayIconExists() {
        final Configuration config = new ConfigurationMockValidTwoJobs();
        final JenkinsMonitor jenkinsMonitor = new JenkinsMonitor(config);
        assertNotNull(jenkinsMonitor.getMonitorTray().jobStatusDarstellungen.trayWrapper.getTrayIcon());
    }

    @Test
    @DisplayName("Eine leere Konfiguration erzeugt ein graues TrayIcon")
    protected void trayIconHasGrayImage() {
        final Configuration config = new ConfigurationMockEmpty();
        final JenkinsMonitor jenkinsMonitor = new JenkinsMonitor(config);
        final TrayIcon icon = jenkinsMonitor.getMonitorTray().jobStatusDarstellungen.trayWrapper.getTrayIcon();
        final BufferedImage image = (BufferedImage) icon.getImage();
        assertNotNull(icon);
        isImageOfColor(image, JobStatus.OTHER.getColor());
    }

    @Test
    @DisplayName("Eine Konfiguration mit einem erfolgreichen Job erzeugt ein grünes TrayIcon")
    protected void trayIconHasGreenImage() {
        final Configuration config = new ConfigurationMockOneJobSuccess();
        final JenkinsMonitor jenkinsMonitor = new JenkinsMonitor(config);
        final TrayIcon icon = jenkinsMonitor.getMonitorTray().jobStatusDarstellungen.trayWrapper.getTrayIcon();
        assertNotNull(icon);
        final BufferedImage image = (BufferedImage) icon.getImage();
        assertNotNull(image);
        assertTrue(isImageOfColor(image, JobStatus.SUCCESS.getColor()));
    }

    @Test
    @DisplayName("Eine Konfiguration mit einem erfolgreichen Job erzeugt ein rotes TrayIcon")
    protected void trayIconHasRedImage() {
        final Configuration config = new ConfigurationMockOneJobFailed();
        final JenkinsMonitor jenkinsMonitor = new JenkinsMonitor(config);
        final TrayIcon icon = jenkinsMonitor.getMonitorTray().jobStatusDarstellungen.trayWrapper.getTrayIcon();
        assertNotNull(icon);
        final BufferedImage image = (BufferedImage) icon.getImage();
        assertNotNull(image);
        assertTrue(isImageOfColor(image, JobStatus.FAILURE.getColor()));
    }
}