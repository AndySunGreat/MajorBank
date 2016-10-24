angular.module('bms-packages-state-add-controller',[ 'ui.bootstrap'])
    .controller('bmsPackagesStateAddController',function($scope,$state,$uibModalInstance,bmsPackagesService,packageDetail){
       console.log("bmsPackagesStateAddController");
        console.log($uibModalInstance);
        console.log(packageDetail);
        $scope.packageDetail = packageDetail;
        console.log($scope.packageDetail);
        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.packageDetail);
            var packageId = $scope.packageDetail.packageId;
            bmsPackagesService.Packages.createPackage($scope.packageDetail).$promise.then(
                function(data){
                    console.log('create package successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('create package failure');
                    console.log(error);
                });
            $uibModalInstance.close();
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });