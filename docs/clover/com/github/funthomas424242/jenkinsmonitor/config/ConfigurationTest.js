var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":192,"id":795,"methods":[{"el":66,"sc":5,"sl":55},{"el":73,"sc":5,"sl":68},{"el":82,"sc":5,"sl":75},{"el":91,"sc":5,"sl":84},{"el":107,"sc":5,"sl":94},{"el":119,"sc":5,"sl":110},{"el":130,"sc":5,"sl":121},{"el":141,"sc":5,"sl":132},{"el":153,"sc":5,"sl":143},{"el":172,"sc":5,"sl":155},{"el":189,"sc":5,"sl":174}],"name":"ConfigurationTest","sl":43}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_15":{"methods":[{"sl":121}],"name":"validDefaultsWithEmptyConfigfile","pass":true,"statements":[{"sl":124},{"sl":125},{"sl":127},{"sl":128},{"sl":129}]},"test_19":{"methods":[{"sl":110}],"name":"validDefaultsWhenNotExistingConfigfile","pass":true,"statements":[{"sl":113},{"sl":114},{"sl":116},{"sl":117},{"sl":118}]},"test_2":{"methods":[{"sl":155}],"name":"reloadCurrentConfiguration","pass":true,"statements":[{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163},{"sl":164},{"sl":165},{"sl":166},{"sl":167},{"sl":168},{"sl":170},{"sl":171}]},"test_20":{"methods":[{"sl":132}],"name":"useDefaultPollPeriod","pass":true,"statements":[{"sl":135},{"sl":136},{"sl":138},{"sl":139},{"sl":140}]},"test_31":{"methods":[{"sl":174}],"name":"reloadOtherConfiguration","pass":true,"statements":[{"sl":177},{"sl":178},{"sl":179},{"sl":180},{"sl":181},{"sl":182},{"sl":184},{"sl":185},{"sl":186},{"sl":187},{"sl":188}]},"test_44":{"methods":[{"sl":84}],"name":"initAfterGetJobBeschreibungenOK","pass":true,"statements":[{"sl":87},{"sl":88},{"sl":89},{"sl":90}]},"test_5":{"methods":[{"sl":94}],"name":"useDefaultConfigfile","pass":true,"statements":[{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":103},{"sl":104},{"sl":105}]},"test_56":{"methods":[{"sl":75}],"name":"initAfterGetPollOK","pass":true,"statements":[{"sl":78},{"sl":79},{"sl":80},{"sl":81}]},"test_8":{"methods":[{"sl":143}],"name":"useUserNameFromConfigfile","pass":true,"statements":[{"sl":146},{"sl":147},{"sl":148},{"sl":149},{"sl":150}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [56], [], [], [56], [56], [56], [56], [], [], [44], [], [], [44], [44], [44], [44], [], [], [], [5], [], [], [5], [5], [5], [5], [5], [], [5], [5], [5], [], [], [], [], [19], [], [], [19], [19], [], [19], [19], [19], [], [], [15], [], [], [15], [15], [], [15], [15], [15], [], [], [20], [], [], [20], [20], [], [20], [20], [20], [], [], [8], [], [], [8], [8], [8], [8], [8], [], [], [], [], [2], [], [], [2], [2], [2], [2], [2], [2], [2], [2], [2], [2], [2], [], [2], [2], [], [], [31], [], [], [31], [31], [31], [31], [31], [31], [], [31], [31], [31], [31], [31], [], [], [], []]
