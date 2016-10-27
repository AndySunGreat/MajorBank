//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-banks-service',['ngResource'])
    .provider("bmsBanksService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/api/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                OptionsList:$resource(baseUrl + "options/:itemParentValue",{},
                    {
                    queryByParentValue:{
                        url: baseUrl + "options/:itemParentValue",
                        method: 'GET',
                        isArray: true
                    }
                })
                ,
                BanksList:$resource(baseUrl + "banks/",
                    {
                        bankId:"@bankId"
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "banks/",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                Banks: $resource(baseUrl + "banks/", {},
                    {
                        query: {
                            url: baseUrl + "banks/",
                            method: 'GET',
                            isArray: true
                        },
                        createBank: {
                            method: 'POST'
                        },
                        getBankDetail:{
                            url:baseUrl + "banks/:bankId",
                            method: 'GET'
                        },
                        deleteBank:{
                            url:baseUrl + "banks/:bankId",
                            method:'DELETE'
                        },
                        updateBank:{
                            url:baseUrl + "banks/:bankId",
                            method:'PUT'
                        }
                    })
            };
        }];

    });