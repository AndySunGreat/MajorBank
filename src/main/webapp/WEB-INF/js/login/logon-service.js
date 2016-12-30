//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-logon-service',['ngResource'])
    .provider("bmsLogonService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                UserInfo: $resource(baseUrl + "index/", {},
                    {
                        logon: {
                            url: baseUrl + "index/",
                            method: 'GET'
                        }
                    })
            };
        }];

    });