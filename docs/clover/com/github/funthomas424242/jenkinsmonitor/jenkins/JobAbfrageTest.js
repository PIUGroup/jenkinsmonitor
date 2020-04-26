var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":192,"id":1178,"methods":[{"el":67,"sc":5,"sl":55},{"el":77,"sc":5,"sl":70},{"el":82,"sc":5,"sl":79},{"el":97,"sc":5,"sl":84},{"el":111,"sc":5,"sl":99},{"el":125,"sc":5,"sl":113},{"el":139,"sc":5,"sl":127},{"el":153,"sc":5,"sl":142},{"el":164,"sc":5,"sl":155},{"el":177,"sc":5,"sl":166},{"el":189,"sc":5,"sl":179}],"name":"JobAbfrageTest","sl":43}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_28":{"methods":[{"sl":127}],"name":"getStatusGray","pass":true,"statements":[{"sl":130},{"sl":131},{"sl":132},{"sl":133},{"sl":135},{"sl":136},{"sl":137},{"sl":138}]},"test_32":{"methods":[{"sl":166}],"name":"getValidJsonYellow","pass":true,"statements":[{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":174},{"sl":175},{"sl":176}]},"test_40":{"methods":[{"sl":155}],"name":"getValidJsonGreen","pass":true,"statements":[{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":163}]},"test_46":{"methods":[{"sl":99}],"name":"getStatusGreen","pass":true,"statements":[{"sl":102},{"sl":103},{"sl":104},{"sl":105},{"sl":107},{"sl":108},{"sl":109},{"sl":110}]},"test_50":{"methods":[{"sl":113}],"name":"getStatusYellow","pass":true,"statements":[{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":121},{"sl":122},{"sl":123},{"sl":124}]},"test_52":{"methods":[{"sl":84}],"name":"getStatusRed","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":93},{"sl":94},{"sl":95},{"sl":96}]},"test_58":{"methods":[{"sl":179}],"name":"getValidJsonGray","pass":true,"statements":[{"sl":182},{"sl":183},{"sl":184},{"sl":185},{"sl":188}]},"test_7":{"methods":[{"sl":142}],"name":"getValidJsonRed","pass":true,"statements":[{"sl":145},{"sl":146},{"sl":147},{"sl":148},{"sl":150},{"sl":151},{"sl":152}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [52], [], [], [], [52], [52], [52], [52], [], [52], [52], [52], [52], [], [], [46], [], [], [46], [46], [46], [46], [], [46], [46], [46], [46], [], [], [50], [], [], [50], [50], [50], [50], [], [50], [50], [50], [50], [], [], [28], [], [], [28], [28], [28], [28], [], [28], [28], [28], [28], [], [], [], [7], [], [], [7], [7], [7], [7], [], [7], [7], [7], [], [], [40], [], [], [40], [40], [40], [40], [40], [40], [], [], [32], [], [], [32], [32], [32], [32], [], [32], [32], [32], [], [], [58], [], [], [58], [58], [58], [58], [], [], [58], [], [], [], []]
