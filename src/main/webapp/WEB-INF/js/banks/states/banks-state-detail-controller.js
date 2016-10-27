angular.module('bms-banks-state-detail-controller',[])
    .controller('bmsBanksStateDetailController',function($scope,$state,bankDetail){
        console.log(bankDetail);
        $scope.bankDetail = bankDetail;
        console.log($scope.bankDetail);

    });