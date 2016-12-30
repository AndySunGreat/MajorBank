angular.module('bms-banks-state-config', [])
    .config([ '$stateProvider', function ($stateProvider) {
        $stateProvider
            .state("home.banks",{
                url:"/banks",
                views:{
                      'home-condition@home':{
                          templateUrl: "ftl/banks/banks.ftl",
                          resolve:{
                              industryTypeOptions:['bmsBanksService',
                                  function(bmsBanksService){
                                      var test =   bmsBanksService.OptionsList.queryByParentValue().$promise;
                                      console.log(test);
                                      return test;
                                  }
                              ]
                          },
                          controller:"bmsBanks"
                      }
/*                     , "datalist":{  // 显示到index.jsp中<div ui-view="datalist">
                          templateUrl:"ftl/banks.datalist.ftl",
                          controller:"bmsBanksStateController"
                      },*/

                }
            })
            .state("home.banks.list",{
                url:"/list",
                params:{searchParams:null},
                views:{
                    "data-list@home.banks":{  // 显示到state为banks的<div ui-view="data-list">
                        templateUrl:"ftl/banks/banks.list.ftl",
                        controller:"bmsBanksStateController"
                    }
                }
            })
            .state("home.banks.list.detail",{
                url:"/{bankId}",
                views:{
                    "detail@home.banks.list":{
                        templateUrl:"ftl/banks/banks.list.detail.ftl",
                        resolve:{
                            bankDetail:['$stateParams','bmsBanksService',
                                function($stateParams,bmsBanksService){
                                    console.log("$stateParams.bankId:"+$stateParams.bankId);
                                    return  bmsBanksService.Banks.getBankDetail(
                                        {    bankId : $stateParams.bankId}
                                    ).$promise;
                                }
                            ]
                        },
                        controller:"bmsBanksStateDetailController"
                    }
                }
            });
    }]);