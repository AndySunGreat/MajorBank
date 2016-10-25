angular.module('bms-packages-state-config', [])
    .config([ '$stateProvider', function ($stateProvider) {
        $stateProvider
            .state("packages",{
                url:"/packages",
                views:{
                      '':{
                          templateUrl: "ftl/packages.ftl",
                          controller:"bmsPackages"
                      }
/*                     , "datalist":{  // 显示到index.jsp中<div ui-view="datalist">
                          templateUrl:"ftl/packages.datalist.ftl",
                          controller:"bmsPackagesStateController"
                      },*/

                }
            })
            .state("packages.list",{
                url:"/list",
                params:{searchParams:null},
                views:{
                    "data-list@packages":{  // 显示到state为packages的<div ui-view="data-list">
                        templateUrl:"ftl/packages.list.ftl",
                        controller:"bmsPackagesStateController"
                    }
                }
            })
            .state("packages.list.detail",{
                url:"/{packageId}",
                views:{
                    "detail@packages.list":{
                        templateUrl:"ftl/packages.list.detail.ftl",
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