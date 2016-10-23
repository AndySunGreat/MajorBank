/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-packages-state-controller',['ui.bootstrap'])
    .controller('bmsPackagesStateController',
        function($scope,$uibModal,$q,$state,bmsPackagesService,$log){
            $scope.items = ['item1', 'item2', 'item3'];

       console.log($uibModal);
        console.log("bmsPackagesStateController");
        console.log($scope.packagedetail);
        var deferred = $q.defer();
        $scope.load = function(){
            var entry  = bmsPackagesService.Packages.query(function(){
                console.log(entry);
                $scope.packages = entry;
            });

        }
        $scope.editPackage = function(packageId){
            console.log("packageId:"+packageId);
            var modalInstance;
            modalInstance = $uibModal.open({
                size:'lg',
                backdrop : false,
                templateUrl: 'ftl/packages.modal.ftl',
                resolve: {
                    packageDetail: ['bmsPackagesService',
                        function (bmsPackagesService) {
                            return bmsPackagesService.Packages.getPackageDetail(
                                {packageId: packageId}
                            ).$promise;
                        }
                    ]
                },
                controller: 'bmsPackagesStateUpdateController'
            });
            modalInstance.opened.then(function() {// 模态窗口打开之后执行的函数
                console.log('modal is opened');
            });
            modalInstance.result.then(function(selectedItem){
                console.log("modal success!");
                console.log(selectedItem);
                $scope.selected = selectedItem;
            },function(){
                console.log("modal failure!");
                $log.info('Modal dismissed at: ' + new Date());
            });

        }

        $scope.deletePackage = function(packageId){
            console.log("packageId:"+packageId);
            bmsPackagesService.Packages.
                deletePackage({packageId:packageId}).$promise.then(
                function(data){
                    console.log('delete package successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('delete package failure');
                    console.log(error);
                });
        }

        $scope.retrieveDetail = function(event,packageId) {
            console.log(event.currentTarget);
                $state.go('packages.detail', {
                    packageId : packageId });

        }
    });