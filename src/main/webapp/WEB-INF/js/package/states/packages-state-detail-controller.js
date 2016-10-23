angular.module('bms-packages-state-detail-controller',[])
    .controller('bmsPackagesStateDetailController',function($scope,$state,packageDetail){
        console.log(packageDetail);
        $scope.packageDetail = packageDetail;
        console.log($scope.packageDetail);

    });