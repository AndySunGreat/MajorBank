angular.module('bms-packages-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsPackagesStateUpdateController',function($scope,$state,$uibModalInstance,bmsPackagesService,packageDetail){
       console.log("bmsPackagesStateUpdateController");
        console.log($uibModalInstance);
        console.log(packageDetail);
        $scope.packageDetail = packageDetail;
        console.log($scope.packageDetail);
        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.packageDetail);
            var packageId = $scope.packageDetail.packageId;
            bmsPackagesService.Packages.updatePackage({packageId:packageId},$scope.packageDetail).$promise.then(
                function(data){
                    console.log('update package successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('delete package failure');
                    console.log(error);
                });
            $uibModalInstance.close();
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });