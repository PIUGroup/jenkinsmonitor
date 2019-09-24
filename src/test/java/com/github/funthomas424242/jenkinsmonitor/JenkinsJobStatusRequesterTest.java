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

import com.github.tomakehurst.wiremock.WireMockServer;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class JenkinsJobStatusRequesterTest {

    protected static URL JOB_URL_MULTIBRANCH_JOB1_RED;
    protected static URL JOB_URL_MULTIBRANCH_JOB1_GREEN;
    protected static URL JOB_URL_MULTIBRANCH_JOB1_YELLOW;
    protected static URL JOB_URL_MULTIBRANCH_JOB1_GRAY;

    protected static URL STATUS_URL_MULTIBRANCH_JOB1_RED;
    protected static URL STATUS_URL_MULTIBRANCH_JOB1_GREEN;
    protected static URL STATUS_URL_MULTIBRANCH_JOB1_YELLOW;
    protected static URL STATUS_URL_MULTIBRANCH_JOB1_GRAY;

    WireMockServer wireMockServer;

    @BeforeAll
    static void setUpAll() throws MalformedURLException, URISyntaxException {
        JOB_URL_MULTIBRANCH_JOB1_RED = new URL(JenkinsAPIMock.JOB_URL_MULTIBRANCH_JOB1_RED);
        JOB_URL_MULTIBRANCH_JOB1_GREEN = new URL(JenkinsAPIMock.JOB_URL_MULTIBRANCH_JOB1_GREEN);
        JOB_URL_MULTIBRANCH_JOB1_YELLOW = new URL(JenkinsAPIMock.JOB_URL_MULTIBRANCH_JOB1_YELLOW);
        JOB_URL_MULTIBRANCH_JOB1_GRAY = new URL(JenkinsAPIMock.JOB_URL_MULTIBRANCH_JOB1_GRAY);

        STATUS_URL_MULTIBRANCH_JOB1_RED = new URL(JenkinsAPIMock.STATUS_URL_MULTIBRANCH_JOB1_RED);
        STATUS_URL_MULTIBRANCH_JOB1_GREEN = new URL(JenkinsAPIMock.STATUS_URL_MULTIBRANCH_JOB1_GREEN);
        STATUS_URL_MULTIBRANCH_JOB1_YELLOW = new URL(JenkinsAPIMock.STATUS_URL_MULTIBRANCH_JOB1_YELLOW);
        STATUS_URL_MULTIBRANCH_JOB1_GRAY = new URL(JenkinsAPIMock.STATUS_URL_MULTIBRANCH_JOB1_GRAY);
    }

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
    @DisplayName("Fehlgeschlagener Multibranch Job erzeugt roten Status")
    protected void getStatusRed() {

        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        assumeTrue(requester != null);
        final JobBeschreibung jobBeschreibung = assertDoesNotThrow(() -> {
            return requester.getJobStatus(JOB_URL_MULTIBRANCH_JOB1_RED);
        });
        assertNotNull(jobBeschreibung);
        assertNotNull(jobBeschreibung.getJobStatus());
        assertNotNull(jobBeschreibung.getJobName());
        assertEquals(JobStatus.FAILURE.getColor(), jobBeschreibung.getJobStatus().getColor());
    }


    @Test
    @DisplayName("Erfolgreicher Multibranch Job erzeugt grünen Status")
    protected void getStatusGreen() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        assumeTrue(requester != null);
        final JobBeschreibung jobBeschreibung = assertDoesNotThrow(() -> {
            return requester.getJobStatus(JOB_URL_MULTIBRANCH_JOB1_GREEN);
        });
        assertNotNull(jobBeschreibung);
        assertNotNull(jobBeschreibung.getJobStatus());
        assertNotNull(jobBeschreibung.getJobName());
        assertEquals(JobStatus.SUCCESS.getColor(), jobBeschreibung.getJobStatus().getColor());
    }

    @Test
    @DisplayName("Instabiler Multibranch Job erzeugt gelben Status")
    protected void getStatusYellow() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        assumeTrue(requester != null);
        final JobBeschreibung jobBeschreibung = assertDoesNotThrow(() -> {
            return requester.getJobStatus(JOB_URL_MULTIBRANCH_JOB1_YELLOW);
        });
        assertNotNull(jobBeschreibung);
        assertNotNull(jobBeschreibung.getJobStatus());
        assertNotNull(jobBeschreibung.getJobName());
        assertEquals(JobStatus.UNSTABLE.getColor(), jobBeschreibung.getJobStatus().getColor());
    }

    @Test
    @DisplayName("Unbekanter  Multibranch Job Status erzeugt grauen Status")
    protected void getStatusGray() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        assumeTrue(requester != null);
        final JobBeschreibung jobBeschreibung = assertDoesNotThrow(() -> {
            return requester.getJobStatus(JOB_URL_MULTIBRANCH_JOB1_GRAY);
        });
        assertNotNull(jobBeschreibung);
        assertNotNull(jobBeschreibung.getJobStatus());
        assertNotNull(jobBeschreibung.getJobName());
        assertEquals(JobStatus.OTHER.getColor(), jobBeschreibung.getJobStatus().getColor());
    }


    @Test
    @DisplayName("Die Statusabfrage eines roten Build Jobs gibt ein valides JSON zurück")
    protected void getValidJsonRed() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        final JSONObject json = assertDoesNotThrow(() -> {
            return requester.sendGetRequest(STATUS_URL_MULTIBRANCH_JOB1_RED);
        });
        assertNotNull(json);
        assertEquals("mypocketmod » master #2", json.get("fullDisplayName"));
        assertEquals("FAILURE", json.get("result"));
    }

    @Test
    @DisplayName("Die Statusabfrage eines grünen Build Jobs gibt ein valides JSON zurück")
    protected void getValidJsonGreen() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        final JSONObject json = assertDoesNotThrow(() -> {
            return requester.sendGetRequest(STATUS_URL_MULTIBRANCH_JOB1_GREEN);
        });
        assertNotNull(json);
        assertEquals("mypocketmod » master #2", json.get("fullDisplayName"));
        assertEquals("SUCCESS", json.get("result"));
    }

    @Test
    @DisplayName("Die Statusabfrage eines gelben Build Jobs gibt ein valides JSON zurück")
    protected void getValidJsonYellow() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        final JSONObject json = assertDoesNotThrow(() -> {
            return requester.sendGetRequest(STATUS_URL_MULTIBRANCH_JOB1_YELLOW);
        });
        assertNotNull(json);
        assertEquals("mypocketmod » master #2", json.get("fullDisplayName"));
        assertEquals("UNSTABLE", json.get("result"));
    }

    @Test
    @DisplayName("Die Statusabfrage eines grauen Build Jobs gibt KEIN valides JSON zurück")
    protected void getValidJsonGray() {
        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester();
        final JSONObject json = assertDoesNotThrow(() -> {
            return requester.sendGetRequest(STATUS_URL_MULTIBRANCH_JOB1_GRAY);
        });
        assertNotNull(json);
        assertTrue(json.isEmpty());
    }

    @Test
    @DisplayName("prüfe ladeJobStatutus für einen Job mit rotem Build")
    void checkLadeJobStatusFailure(){

        final JenkinsJobStatusRequester requester = new JenkinsJobStatusRequester(){
            @Override
            protected  JobBeschreibung getJobStatus(URL url){
                return new JobBeschreibung("hallo",JobStatus.FAILURE,url);
            }
        };
        final JobBeschreibung[] jobBeschreibungen = new JobBeschreibung[1];
        jobBeschreibungen[0] = new JobBeschreibung(null, null, NetworkHelper.urlOf("http://test.org"));

        final JobBeschreibung[] jobStatusBeschreibungen = requester.ladeJobsStatus(jobBeschreibungen);
        assumeTrue(jobBeschreibungen!=null);
        assertEquals("hallo",jobStatusBeschreibungen[0].getJobName());
        assertEquals(JobStatus.FAILURE,jobStatusBeschreibungen[0].getJobStatus());
        assertEquals("http://test.org",jobStatusBeschreibungen[0].getJobUrl().toExternalForm());


    }



}
