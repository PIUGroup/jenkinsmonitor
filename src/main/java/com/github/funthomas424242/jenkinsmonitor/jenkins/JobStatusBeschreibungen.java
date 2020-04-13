package com.github.funthomas424242.jenkinsmonitor.jenkins;

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

import java.util.HashMap;
import java.util.Map;


public class JobStatusBeschreibungen extends AbstractJobBeschreibungen<JobStatusBeschreibung> {

//    protected int displayCharLength = 0;

    public JobStatusBeschreibungen() {
        super(new HashMap<>());
    }

    public JobStatusBeschreibungen(final Map<String, JobStatusBeschreibung> jobStatusBeschreibungen) {
        super(jobStatusBeschreibungen);
    }

//    public void computeDisplayCharLength() {
//
//        final Comparator<Integer> maxComparator = new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer n1, Integer n2) {
//                return n1.compareTo(n2);
//            }
//        };
//
//        final Optional<Integer> maxLen = AbstractJobBeschreibung.sortedStreamOf(this)
//            .map(jobStatusBeschreibung -> jobStatusBeschreibung.getJobName().length())
//            .max(maxComparator);
//        if (maxLen.isPresent()) {
//            this.displayCharLength = maxLen.get();
//        }
//    }
//
//    public int getDisplayCharLength() {
//        return this.displayCharLength;
//    }
}