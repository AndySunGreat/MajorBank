//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-packages-service',['ngResource'])
    .provider("bmsPackagesService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/api/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                OptionsList:$resource(baseUrl + "options/industryOptions",{},
                    {
                        queryByParentValue:{
                            url: baseUrl + "options/industryOptions",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                BanksList:$resource(baseUrl + "banks/",
                    {
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "banks/",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                PackagesList:$resource(baseUrl + "login/package/",
                    {
                        packageId:"@packageId"
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "login/package",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                Packages: $resource(baseUrl + "login/package/", {},
                    {
                        query: {
                            url: baseUrl + "login/package",
                            method: 'GET',
                            isArray: true
                        },
                        createPackage: {
                            method: 'POST'
                        },
                        getBanksDetail:{
                            url: baseUrl + "login/package/banksDetail/:packageId",
                            method: 'GET',
                            isArray: true
                        },
                        getPackageDetail:{
                            url:baseUrl + "login/package/:packageId",
                            method: 'GET'
                        },
                        deletePackage:{
                            url:baseUrl + "login/package/:packageId",
                            method:'DELETE'
                        },
                        updatePackage:{
                            url:baseUrl + "login/package/:packageId",
                            method:'PUT'
                        }
                    })
            };
        }];

    });