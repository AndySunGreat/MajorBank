angular.module('bms-packages-state-config', [])
    .config([ '$stateProvider', function ($stateProvider) {
        $stateProvider
            .state("home.packages",{
                url:"/packages",
                views:{
                      'home-condition@home':{
                          templateUrl: "ftl/packages/packages.ftl",
                          resolve:{
                              industryTypeOptions:['bmsBanksService',
                                  function(bmsPackagesService){
                                      var test =   bmsPackagesService.OptionsList.queryByParentValue().$promise;
                                      console.log(test);
                                      return test;
                                  }
                              ]
                          },
                          controller:"bmsPackages"
                      }
/*                     , "datalist":{  // 显示到index.jsp中<div ui-view="datalist">
                          templateUrl:"ftl/packages.datalist.ftl",
                          controller:"bmsPackagesStateController"
                      },*/

                }
            })
            .state("home.packages.list",{
                url:"/list",
                params:{searchParams:null},
                views:{
                    "data-list@home.packages":{  // 显示到state为packages的<div ui-view="data-list">
                        templateUrl:"ftl/packages/packages.list.ftl",
                        controller:"bmsPackagesStateController"
                    }
                }
            })
            .state("home.packages.list.detail",{
                url:"/{packageId}",
                views:{
                    "detail@home.packages.list":{
                        templateUrl:"ftl/packages/packages.list.detail.ftl",
                        resolve:{
                            packageDetail:['$stateParams','bmsPackagesService',
                                function($stateParams,bmsPackagesService){
                                    console.log("$stateParams.packageId:"+$stateParams.packageId);
                                    return  bmsPackagesService.Packages.getPackageDetail(
                                        {packageId : $stateParams.packageId}
                                    ).$promise;
                                }
                            ]
                        },
                        controller:"bmsPackagesStateDetailController"
                    }
                }
            });
    }]);