angular.module('bms-packages-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsPackagesStateUpdateController',function($scope,$state,packageDetail){
       console.log(packageDetail);
        $scope.packageDetail = packageDetail;
        console.log($scope.packageDetail);
/*        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.item);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };*/
    });