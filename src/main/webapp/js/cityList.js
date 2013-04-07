var cityList = [{"code":"AYN","en":"ANYANG","id":"10151","name":"安阳","pyjsm":"AY"},{"code":"LYA","en":"LUOYANG","id":"10158","name":"洛阳","pyjsm":"LY"},{"code":"HRB","en":"HAERBIN","id":"10168","name":"哈尔滨","pyjsm":"HEB"},{"code":"HEK","en":"HEIHE","id":"10169","name":"黑河","pyjsm":"HH"},{"code":"JMU","en":"JIAMUSI","id":"10171","name":"佳木斯","pyjsm":"JMS"},{"code":"ENH","en":"ENSHI","id":"10176","name":"恩施","pyjsm":"ES"},{"code":"SWA","en":"SHANTOU","id":"10105","name":"汕头","pyjsm":"ST"},{"code":"DOY","en":"DONGYING","id":"10110","name":"东营","pyjsm":"DY"},{"code":"TNA","en":"JINAN","id":"10113","name":"济南","pyjsm":"JN"},{"code":"JNG","en":"JINING","id":"10114","name":"济宁","pyjsm":"JN"},{"code":"LYI","en":"LINYI","id":"10118","name":"临沂","pyjsm":"LY"},{"code":"PEK","en":"BEIJING","id":"10119","name":"北京","pyjsm":"BJ"},{"code":"CHW","en":"JIUQUAN","id":"10120","name":"酒泉","pyjsm":"JQ"},{"code":"JGN","en":"JIAYUGUAN","id":"10121","name":"嘉峪关","pyjsm":"JYG"},{"code":"WUZ","en":"WUZHOU","id":"10122","name":"梧州","pyjsm":"WZ"},{"code":"ANS","en":"ANSHUN","id":"10124","name":"安顺","pyjsm":"AS"},{"code":"KWE","en":"GUIYANG","id":"10126","name":"贵阳","pyjsm":"GY"},{"code":"TOR","en":"TONGREN","id":"10128","name":"铜仁","pyjsm":"TR"},{"code":"ZYI","en":"ZUNYI","id":"10129","name":"遵义","pyjsm":"ZY"},{"code":"HAK","en":"HAIKOU","id":"10131","name":"海口","pyjsm":"HK"},{"code":"HDN","en":"HANDAN","id":"10141","name":"邯郸","pyjsm":"HD"},{"code":"HYE","en":"HUANGHUA","id":"10142","name":"黄骅","pyjsm":"HH"},{"code":"SHP","en":"QINHUANGDAO","id":"10145","name":"秦皇岛","pyjsm":"QHD"},{"code":"SJW","en":"SHIJIAZHUANG","id":"10146","name":"石家庄","pyjsm":"SJZ"},{"code":"TAS","en":"TANGSHAN","id":"10147","name":"唐山","pyjsm":"TS"},{"code":"CGO","en":"ZHENGZHOU","id":"10285","name":"郑州","pyjsm":"ZZ"},{"code":"GZH","en":"GANZHOU","id":"10288","name":"赣州","pyjsm":"GZ"},{"code":"WUS","en":"WUYISHAN","id":"10290","name":"武夷山","pyjsm":"WYS"},{"code":"DNH","en":"DUNHUANG","id":"10292","name":"敦煌","pyjsm":"DH"},{"code":"KNS","en":"KENASI","id":"10180","name":"喀纳斯","pyjsm":"KNS"},{"code":"ERD","en":"EERDUOSI","id":"10181","name":"鄂尔多斯","pyjsm":"EEDS"},{"code":"YOZ","en":"YONGZHOU","id":"10182","name":"永州","pyjsm":"YZ"},{"code":"AQG","en":"ANQING","id":"10183","name":"安庆","pyjsm":"AQ"},{"code":"YIH","en":"YICHANG","id":"10189","name":"宜昌","pyjsm":"YC"},{"code":"CSX","en":"CHANGSHA","id":"10190","name":"长沙","pyjsm":"CS"},{"code":"TUL","en":"TULUFAN","id":"10196","name":"吐鲁番","pyjsm":"TLF"},{"code":"URC","en":"WURUMQI ","id":"10197","name":"乌鲁木齐","pyjsm":"WLMQ"},{"code":"YIN","en":"YINING","id":"10198","name":"伊宁","pyjsm":"YN"},{"code":"BSD","en":"BAOSHAN","id":"10199","name":"保山","pyjsm":"BS"},{"code":"DLU","en":"DALI","id":"10201","name":"大理","pyjsm":"DL"},{"code":"KMG","en":"KUNMING","id":"10202","name":"昆明","pyjsm":"KM"},{"code":"LCH","en":"LINCANG","id":"10203","name":"临沧","pyjsm":"LC"},{"code":"LJG","en":"LIJIANG","id":"10204","name":"丽江","pyjsm":"LJ"},{"code":"JHG","en":"XISHUANGBANNA","id":"10207","name":"西双版纳","pyjsm":"XSBN"},{"code":"ZAT","en":"ZHAOTONG","id":"10209","name":"昭通","pyjsm":"ZT"},{"code":"HGH","en":"HANGZHOU","id":"10216","name":"杭州","pyjsm":"HZ"},{"code":"WNZ","en":"WENZHOU","id":"10230","name":"温州","pyjsm":"WZ"},{"code":"YIW","en":"YIWU","id":"10232","name":"义乌","pyjsm":"YW"},{"code":"987","en":"JI'AN","id":"10293","name":"吉安","pyjsm":"JA"},{"code":"CKG","en":"CHONGQING","id":"10233","name":"重庆","pyjsm":"CQ"},{"code":"BAV","en":"BAOTOU","id":"10237","name":"包头","pyjsm":"BT"},{"code":"CIF","en":"CHIFENG","id":"10238","name":"赤峰","pyjsm":"CF"},{"code":"TGO","en":"TONGLIAO","id":"10239","name":"通辽","pyjsm":"TL"},{"code":"WHA","en":"WUHAI","id":"10240","name":"乌海","pyjsm":"WH"},{"code":"XIL","en":"XILINHOT","id":"10241","name":"锡林浩特","pyjsm":"XLHT"},{"code":"LXA","en":"LASA","id":"10242","name":"拉萨","pyjsm":"LS"},{"code":"HNY","en":"HENGYANG","id":"10243","name":"衡阳","pyjsm":"HY"},{"code":"HZG","en":"HANZHONG","id":"10244","name":"汉中","pyjsm":"HZ"},{"code":"JGS","en":"JINGGANGSHAN","id":"10245","name":"井冈山","pyjsm":"JGS"},{"code":"JDZ","en":"JINGDEZHEN","id":"10246","name":"景德镇","pyjsm":"JDZ"},{"code":"KHN","en":"NANCHANG","id":"10248","name":"南昌","pyjsm":"NC"},{"code":"DDG","en":"DANDONG","id":"10252","name":"丹东","pyjsm":"DD"},{"code":"DLC","en":"DALIAN","id":"10253","name":"大连","pyjsm":"DL"},{"code":"JNZ","en":"JINZHOU","id":"10256","name":"锦州","pyjsm":"JZ"},{"code":"","en":"XIANGFAN","id":"10257","name":"襄樊","pyjsm":"XF"},{"code":"","en":"MOHE","id":"10258","name":"漠河","pyjsm":"MH"},{"code":"ZUH","en":"ZHUHAI","id":"10261","name":"珠海","pyjsm":"ZH"},{"code":"BHY","en":"BEIHAI","id":"10263","name":"北海","pyjsm":"BH"},{"code":"BSI","en":"BOSE","id":"10264","name":"百色","pyjsm":"BS"},{"code":"LZH","en":"LIUZHOU","id":"10268","name":"柳州","pyjsm":"LZ"},{"code":"NNG","en":"NANNING","id":"10269","name":"南宁","pyjsm":"NN"},{"code":"INC","en":"YINCHUAN","id":"10270","name":"银川","pyjsm":"YC"},{"code":"GOQ","en":"GOLMUD","id":"10271","name":"格尔木","pyjsm":"GEM"},{"code":"XNN","en":"XINING","id":"10272","name":"西宁","pyjsm":"XN"},{"code":"AKU","en":"AKSU","id":"10274","name":"阿克苏","pyjsm":"AKS"},{"code":"AAT","en":"ALTAY","id":"10275","name":"阿勒泰","pyjsm":"ALT"},{"code":"ENY","en":"YANAN","id":"10352","name":"延安","pyjsm":"YA"},{"code":"UYN","en":"YULIN","id":"10353","name":"榆林","pyjsm":"YL"},{"code":"CTU","en":"CHENGDOU","id":"10355","name":"成都","pyjsm":"CD"},{"code":"GUY","en":"GUANGYUAN","id":"10360","name":"广元","pyjsm":"GY"},{"code":"JZH","en":"JIUZHAIGOU","id":"10361","name":"九寨沟","pyjsm":"JZG"},{"code":"LZO","en":"LUZHOU","id":"10362","name":"泸州","pyjsm":"ZZ"},{"code":"NAO","en":"NANCHONG","id":"10364","name":"南充","pyjsm":"NC"},{"code":"PZI","en":"PANZHIHUA","id":"10366","name":"攀枝花","pyjsm":"PZH"},{"code":"YBP","en":"YIBIN","id":"10369","name":"宜宾","pyjsm":"YB"},{"code":"TSN","en":"TIANJIN","id":"10371","name":"天津","pyjsm":"TJ"},{"code":"TXN","en":"HUANGSHAN","id":"10374","name":"黄山","pyjsm":"HS"},{"code":"WHU","en":"WUHU","id":"10378","name":"芜湖","pyjsm":"WH"},{"code":"FUO","en":"FOSHAN","id":"10381","name":"佛山","pyjsm":"FS"},{"code":"HUZ","en":"HUIZHOU","id":"10384","name":"惠州","pyjsm":"HZ"},{"code":"BOL","en":"BOLE","id":"10386","name":"博乐","pyjsm":"BL"},{"code":"HMI","en":"HAMI","id":"10388","name":"哈密","pyjsm":"HM"},{"code":"HTN","en":"HOTAN","id":"10389","name":"和田","pyjsm":"HT"},{"code":"KRL","en":"KORLA","id":"10390","name":"库尔勒","pyjsm":"KEL"},{"code":"PEL","en":"PENGLAI","id":"10326","name":"蓬莱","pyjsm":"PL"},{"code":"WEH","en":"WEIHAI","id":"10331","name":"威海","pyjsm":"WH"},{"code":"WEF","en":"WEIFANG","id":"10332","name":"潍坊","pyjsm":"WF"},{"code":"YNT","en":"YANTAI","id":"10333","name":"烟台","pyjsm":"YT"},{"code":"","en":"WENSHAN","id":"10450","name":"文山","pyjsm":"WS"},{"code":"CGQ","en":"CHANGCHUN","id":"10294","name":"长春","pyjsm":"CC"},{"code":"CZX","en":"CHANGZHOU","id":"10298","name":"常州","pyjsm":"CZ"},{"code":"HUA","en":"HUAIAN","id":"10301","name":"淮安","pyjsm":"HA"},{"code":"LYG","en":"LIANGYUNGANG","id":"10305","name":"连云港","pyjsm":"LYG"},{"code":"NKG","en":"NANJING","id":"10306","name":"南京","pyjsm":"NJ"},{"code":"SZV","en":"SUZHOU","id":"10308","name":"苏州","pyjsm":"SZ"},{"code":"WUX","en":"WUXI","id":"10310","name":"无锡","pyjsm":"WX"},{"code":"YNZ","en":"YANCHENG","id":"10312","name":"盐城","pyjsm":"YC"},{"code":"LHW","en":"LANZHOU","id":"10317","name":"兰州","pyjsm":"LZ"},{"code":"QIY","en":"QINGYANG","id":"10319","name":"庆阳","pyjsm":"QY"},{"code":"TIS","en":"TIANSHUI","id":"10320","name":"天水","pyjsm":"TS"},{"code":"ZHY","en":"ZHANGYE","id":"10322","name":"张掖","pyjsm":"ZY"},{"code":"CIH","en":"CHANGZHI","id":"10337","name":"长治","pyjsm":"CZ"},{"code":"DAT","en":"DATONG","id":"10338","name":"大同","pyjsm":"DT"},{"code":"TYN","en":"TAIYUAN","id":"10344","name":"太原","pyjsm":"TY"},{"code":"WTS","en":"WUTAISHAN","id":"10345","name":"五台山","pyjsm":"WTS"},{"code":"AKA","en":"ANKANG","id":"10348","name":"安康","pyjsm":"AK"},{"code":"MIG","en":"MIANYANG","id":"10497","name":"绵阳","pyjsm":"MY"},{"code":"CDU","en":"CHANGDU","id":"10500","name":"昌都","pyjsm":"CD"},{"code":"SYX","en":"SANYA","id":"10501","name":"三亚","pyjsm":"SY"},{"code":"HFE","en":"HEFEI","id":"10503","name":"合肥","pyjsm":"HF"},{"code":"CAN","en":"GUANGZHOU","id":"10507","name":"广州","pyjsm":"GZ"},{"code":"KLY","en":"KALAMAYI","id":"10391","name":"克拉玛依","pyjsm":"KLMY"},{"code":"KHG","en":"KASHI","id":"10392","name":"喀什","pyjsm":"KS"},{"code":"KWL","en":"GUILIN","id":"10403","name":"桂林","pyjsm":"GL"},{"code":"JIL","en":"JILIN","id":"10406","name":"吉林","pyjsm":"JL"},{"code":"YNJ","en":"YANJI","id":"10409","name":"延吉","pyjsm":"YJ"},{"code":"NTG","en":"NANTONG","id":"10414","name":"南通","pyjsm":"NT"},{"code":"XUZ","en":"XUZHOU","id":"10418","name":"徐州","pyjsm":"XZ"},{"code":"JIU","en":"JIUJIANG","id":"10421","name":"九江","pyjsm":"JJ"},{"code":"AOG","en":"ANSHAN","id":"10424","name":"鞍山","pyjsm":"AS"},{"code":"CHG","en":"CHAOYANG","id":"10425","name":"朝阳","pyjsm":"CY"},{"code":"SHE","en":"SHENYANG","id":"10428","name":"沈阳","pyjsm":"SY"},{"code":"JCH","en":"JINCHANG","id":"10434","name":"金昌","pyjsm":"JC"},{"code":"TAO","en":"QINGDAO","id":"10435","name":"青岛","pyjsm":"QD"},{"code":"ZHK","en":"ZHOUKOU","id":"10442","name":"周口","pyjsm":"ZK"},{"code":"MDG","en":"MUDANJIANG","id":"10444","name":"牡丹江","pyjsm":"MDJ"},{"code":"YCH","en":"YICHUN","id":"10446","name":"伊春","pyjsm":"YC"},{"code":"JXI","en":"JIXI","id":"10447","name":"鸡西","pyjsm":"JX"},{"code":"JZG","en":"JINGZHOU","id":"10455","name":"荆州","pyjsm":"JZ"},{"code":"WUH","en":"WUHAN","id":"10458","name":"武汉","pyjsm":"WH"},{"code":"CGD","en":"CHANGDE","id":"10460","name":"常德","pyjsm":"CD"},{"code":"HUH","en":"HUAIHUA","id":"10461","name":"怀化","pyjsm":"HH"},{"code":"LZI","en":"LINZHI","id":"10465","name":"林芝","pyjsm":"LZ"},{"code":"RIK","en":"RIKAZE","id":"10466","name":"日喀则","pyjsm":"RKZ"},{"code":"NGB","en":"NINGBO","id":"10468","name":"宁波","pyjsm":"NB"},{"code":"JUZ","en":"QUZHOU","id":"10469","name":"衢州","pyjsm":"ZZ"},{"code":"FOC","en":"FUZHOU","id":"10475","name":"福州","pyjsm":"FZ"},{"code":"XMN","en":"XIAMEN","id":"10478","name":"厦门","pyjsm":"XM"},{"code":"MAZ","en":"MANZHOULI","id":"10479","name":"满洲里","pyjsm":"MZL"},{"code":"HLH","en":"WULANHOT","id":"10480","name":"乌兰浩特","pyjsm":"WLHT"},{"code":"HSN","en":"ZHOUSHAN","id":"10481","name":"舟山","pyjsm":"ZS"},{"code":"DYG","en":"ZHANGJIAJIE","id":"10482","name":"张家界","pyjsm":"ZJJ"},{"code":"HET","en":"HOHEHAOTE","id":"10483","name":"呼和浩特","pyjsm":"HHHT"},{"code":"DGM","en":"DONGGUAN","id":"10484","name":"东莞","pyjsm":"DG"},{"code":"TCH","en":"TENGCHONG","id":"10485","name":"腾冲","pyjsm":"TC"},{"code":"ZWS","en":"ZHONGWEI","id":"10486","name":"中卫","pyjsm":"ZW"},{"code":"NNY","en":"NANYANG","id":"10487","name":"南阳","pyjsm":"NY"},{"code":"","en":"YUSHU","id":"10488","name":"玉树","pyjsm":"YS"},{"code":"DAQ","en":"DAQING","id":"10489","name":"大庆","pyjsm":"DQ"},{"code":"YUC","en":"YUNCHENG","id":"10490","name":"运城","pyjsm":"YC"},{"code":"SHA","en":"SHANGHAI","id":"10621","name":"上海","pyjsm":"SH"},{"code":"XIY","en":"XIAN","id":"10558","name":"西安","pyjsm":"XA"},{"code":"SZX","en":"SHENZHEN","id":"10511","name":"深圳","pyjsm":"SZ"},{"code":"ZHA","en":"ZHANJIANG","id":"10512","name":"湛江","pyjsm":"ZJ"},{"code":"SYM","en":"PUER","id":"10523","name":"普洱","pyjsm":"PE"},{"code":"XIY","en":"XIANYANG","id":"10524","name":"咸阳","pyjsm":"XY"},{"code":"","en":"GUYUAN","id":"10566","name":"固原","pyjsm":"GY"},{"code":"BYZ","en":"BAYANNAOER","id":"10656","name":"巴彦淖尔","pyjsm":"BYNE"},{"code":"","en":"AERSHAN","id":"10662","name":"阿尔山","pyjsm":"AES"},{"code":"HLD","en":"HULUDAO","id":"10672","name":"葫芦岛","pyjsm":"HLD"},{"code":"","en":"CHANGBAISHAN","id":"10686","name":"长白山","pyjsm":"CBS"},{"code":"NDG","en":"QIQIHAER","id":"10692","name":"齐齐哈尔","pyjsm":"QQHE"},{"code":"TAZ","en":"TAIZHOU","id":"10731","name":"台州","pyjsm":"TZ"},{"code":"HZH","en":"HEZHOU","id":"10879","name":"贺州","pyjsm":"HZ"},{"code":"JJN","en":"JINJIANG","id":"10780","name":"晋江","pyjsm":"JJ"},{"code":"MSH","en":"MANGSHI","id":"12420","name":"芒市","pyjsm":"MS"},{"code":"XIC","en":"XICHANG","id":"11887","name":"西昌","pyjsm":"XC"},{"code":"XYN","en":"XINGYI","id":"11900","name":"兴义","pyjsm":"XY"},{"code":"JIH","en":"JINGHONG","id":"11950","name":"景洪","pyjsm":"JH"},{"code":"TCG","en":"TACHENG","id":"12150","name":"塔城","pyjsm":"TC"},{"code":"ERL","en":"ERLIANHAOTE","id":"12452","name":"二连浩特","pyjsm":"ELHT"},{"code":"FUG","en":"FUYANG","id":"12468","name":"阜阳","pyjsm":"FY"},{"code":"GHN","en":"GUANGHAN","id":"12477","name":"广汉","pyjsm":"GH"},{"code":"DAX","en":"DAXINGANLING","id":"12591","name":"大兴安岭","pyjsm":"DXAL"},{"code":"DIG","en":"DIQING","id":"12600","name":"迪庆","pyjsm":"DQ"}]