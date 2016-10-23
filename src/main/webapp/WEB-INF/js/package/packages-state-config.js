angular.module('bms-packages-state-config', [])
    .config([ '$stateProvider', function ($stateProvider) {
        $stateProvider
            .state("packages",{
                url:"/packages",
                views:{
                      '':{
                          templateUrl: "ftl/packages.ftl",
                          controller:"bmsPackages"
                      },
/*                      "datalist":{  // 显示到index.jsp中<div ui-view="datalist">
                          templateUrl:"ftl/packages.datalist.ftl",
                          controller:"bmsPackagesStateController"
                      },*/
                      "data-list@packages":{  // 显示到state为packages的<div ui-view="data-list">
                        templateUrl:"ftl/packages.datalist.ftl",
                        controller:"bmsPackagesStateController"
                    }
                }
            })
            .state("packages.detail",{
                url:"/{packageId}",
                views:{
                    "data-detail@packages":{
                        templateUrl:"ftl/packages.datalist.detail.ftl",
                        resolve:{
                            packageDetail:['$stateParams','bmsPackagesService',
                                function($stateParams,bmsPackagesService){
                                    console.log("$stateParams.packageId:"+$stateParams.packageId);
                                    var test = bmsPackagesService.Packages.getPackageDetail(
                                        {packageId : $stateParams.packageId},
                                        function(){
                                            console.log(test);
                                        }
                                    );
                                    return test;
                                }
                            ]
                        },
                        controller:"bmsPackagesStateDetailController"
                    }
                }
            });
    }]);