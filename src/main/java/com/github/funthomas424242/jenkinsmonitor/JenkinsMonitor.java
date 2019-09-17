package com.github.funthomas424242.jenkinsmonitor;

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

import java.io.File;

public class JenkinsMonitor {


    public static final String JENKINSMONITOR_PROPERTIES = "jenkinsmonitor.properties";

    private File propertyFile;

    public JenkinsMonitor() {
        this(System.getProperty("user.home") + File.separator + JENKINSMONITOR_PROPERTIES);
    }

    protected JenkinsMonitor(String propertyFilePath) {
        this.propertyFile = new File(propertyFilePath);
    }

    public File getConfigurationfile() {
        return this.propertyFile;
    }
}
