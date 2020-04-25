var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":80,"id":495,"methods":[{"el":36,"sc":5,"sl":34},{"el":40,"sc":5,"sl":38},{"el":44,"sc":5,"sl":42},{"el":48,"sc":5,"sl":46},{"el":52,"sc":5,"sl":50},{"el":56,"sc":5,"sl":54},{"el":60,"sc":5,"sl":58},{"el":66,"sc":5,"sl":62},{"el":74,"sc":5,"sl":68},{"el":79,"sc":5,"sl":76}],"name":"AbstractJobBeschreibungen","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"shouldShowOneFailedJobWatching","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_1":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"trayIconHasRedImage","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_11":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"initTwoJobsOneGreenOneRedIcon50x100","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_13":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"statusMultibranchJobGelb","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_14":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"trayIconHasGreenImage","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_15":{"methods":[{"sl":38},{"sl":42}],"name":"validDefaultsWithEmptyConfigfile","pass":true,"statements":[{"sl":39},{"sl":43}]},"test_16":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"shouldShowOneSuccessJobWatching","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_19":{"methods":[{"sl":38},{"sl":42}],"name":"validDefaultsWhenNotExistingConfigfile","pass":true,"statements":[{"sl":39},{"sl":43}]},"test_2":{"methods":[{"sl":38},{"sl":42},{"sl":68}],"name":"reloadCurrentConfiguration","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":70},{"sl":71},{"sl":72},{"sl":73}]},"test_20":{"methods":[{"sl":38},{"sl":42}],"name":"useDefaultPollPeriod","pass":true,"statements":[{"sl":39},{"sl":43}]},"test_23":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58}],"name":"checkLadeTwoJobStatusSUCCESSandUNSTABLE","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59}]},"test_24":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"shouldShowNoJobsWatching","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_25":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"statusMultibranchJobRot","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_26":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"statusMultibranchJobGrauUnbekannt","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_27":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58}],"name":"checkLadeStatusWithException","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59}]},"test_28":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58}],"name":"checkLadeOneJobStatusFailure","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59}]},"test_29":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"aktualisiereContentPane","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_30":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"shouldShowOneInstabilJobWatching","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_31":{"methods":[{"sl":38},{"sl":42}],"name":"reloadOtherConfiguration","pass":true,"statements":[{"sl":39},{"sl":43}]},"test_32":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"initOneJobRedIcon100x100","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_33":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"trayIconHasGrayImage","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_34":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"afterInitTrayIconExists","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_38":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"showBuildStatusAreaOneSuccessJob","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_4":{"methods":[{"sl":34},{"sl":38},{"sl":42},{"sl":46},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"updateJobsAfterTimePeriod","pass":true,"statements":[{"sl":35},{"sl":39},{"sl":43},{"sl":47},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_41":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"checkTrayInstanz","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_42":{"methods":[{"sl":38},{"sl":42},{"sl":46},{"sl":50},{"sl":58},{"sl":62}],"name":"checkEqualsAndHashCode","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":47},{"sl":51},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_44":{"methods":[{"sl":38}],"name":"initAfterGetJobBeschreibungenOK","pass":true,"statements":[{"sl":39}]},"test_45":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"initialConfigWithEmptyJobs","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_46":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"initOneJobGreenIcon100x100","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_47":{"methods":[{"sl":38},{"sl":42}],"name":"initEmptyCreateGrayIcon100x100","pass":true,"statements":[{"sl":39},{"sl":43}]},"test_48":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"initOneJobYellowIcon100x100","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_49":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"checkMainEmptyParaMethod","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_51":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"showStatusAsToolstippsIfJobsPresent","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_54":{"methods":[{"sl":38},{"sl":42},{"sl":58}],"name":"checkMainMethod","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":59}]},"test_59":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"equalsConfigWithTrayAndMonitor","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_7":{"methods":[{"sl":38},{"sl":42},{"sl":50},{"sl":54},{"sl":58},{"sl":62}],"name":"showStatusAsToolstippsIfJobPresent","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51},{"sl":55},{"sl":59},{"sl":63},{"sl":64},{"sl":65}]},"test_8":{"methods":[{"sl":38},{"sl":42},{"sl":50}],"name":"useUserNameFromConfigfile","pass":true,"statements":[{"sl":39},{"sl":43},{"sl":51}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [4], [4], [], [], [4, 33, 26, 46, 49, 11, 8, 7, 47, 14, 29, 32, 34, 38, 25, 0, 54, 42, 23, 28, 44, 13, 31, 20, 15, 45, 2, 24, 48, 1, 51, 16, 59, 27, 30, 19, 41], [4, 33, 26, 46, 49, 11, 8, 7, 47, 14, 29, 32, 34, 38, 25, 0, 54, 42, 23, 28, 44, 13, 31, 20, 15, 45, 2, 24, 48, 1, 51, 16, 59, 27, 30, 19, 41], [], [], [4, 33, 26, 46, 49, 11, 8, 7, 47, 14, 29, 32, 34, 38, 25, 0, 54, 42, 23, 28, 13, 31, 20, 15, 45, 2, 24, 48, 1, 51, 16, 59, 27, 30, 19, 41], [4, 33, 26, 46, 49, 11, 8, 7, 47, 14, 29, 32, 34, 38, 25, 0, 54, 42, 23, 28, 13, 31, 20, 15, 45, 2, 24, 48, 1, 51, 16, 59, 27, 30, 19, 41], [], [], [4, 42], [4, 42], [], [], [4, 46, 11, 8, 7, 14, 29, 32, 34, 38, 0, 42, 23, 28, 48, 1, 51, 16, 59, 27, 30], [4, 46, 11, 8, 7, 14, 29, 32, 34, 38, 0, 42, 23, 28, 48, 1, 51, 16, 59, 27, 30], [], [], [4, 46, 11, 7, 14, 29, 32, 34, 38, 0, 23, 28, 48, 1, 51, 16, 59, 27, 30], [4, 46, 11, 7, 14, 29, 32, 34, 38, 0, 23, 28, 48, 1, 51, 16, 59, 27, 30], [], [], [4, 33, 26, 46, 49, 11, 7, 14, 29, 32, 34, 38, 25, 0, 54, 42, 23, 28, 13, 45, 24, 48, 1, 51, 16, 59, 27, 30, 41], [4, 33, 26, 46, 49, 11, 7, 14, 29, 32, 34, 38, 25, 0, 54, 42, 23, 28, 13, 45, 24, 48, 1, 51, 16, 59, 27, 30, 41], [], [], [4, 46, 11, 7, 14, 29, 32, 34, 38, 0, 42, 48, 1, 51, 16, 59, 30], [4, 46, 11, 7, 14, 29, 32, 34, 38, 0, 42, 48, 1, 51, 16, 59, 30], [4, 46, 11, 7, 14, 29, 32, 34, 38, 0, 42, 48, 1, 51, 16, 59, 30], [4, 46, 11, 7, 14, 29, 32, 34, 38, 0, 42, 48, 1, 51, 16, 59, 30], [], [], [2], [], [2], [2], [2], [2], [], [], [], [], [], [], []]
