//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-packages-service',['ngResource'])
    .provider("bmsPackagesService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/api/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                Packages: $resource(baseUrl + "login/package/", {},
                    {
                        query: {
                            method: 'GET',
                            isArray: true
                        },
                        create: {
                            method: 'POST'
                        },
                        getPackageDetail:{
                            url:baseUrl + "login/package/:packageId",
                            method: 'GET'
                        }
                    })
            };
        }];

    });