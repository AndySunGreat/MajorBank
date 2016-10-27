angular.module('bms-banks-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsBanksStateUpdateController',function($scope,$state,$uibModalInstance,bmsBanksService,bankDetail){

        //$scope.addiDynamicParamList = [{optSeq:"",optContent:""}];
        $scope.addiDynamicParamList = angular.fromJson(bankDetail.questOptionsJson);
        $scope.addAdditionalParams = function(){
            var obj={optSeq:"",optContent:""};
            $scope.addiDynamicParamList.push(obj);
        };
        $scope.delAdditionalParams=function(idx){
            $scope.addiDynamicParamList.splice(idx,1);
        };

        $scope.bankDetail = bankDetail;
        console.log($scope.bankDetail);
        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.bankDetail);
            var bankId = $scope.bankDetail.bankId;
            $scope.bankDetail.questOptionsJson = angular.toJson($scope.addiDynamicParamList);
            bmsBanksService.Banks.updateBank({bankId:bankId},$scope.bankDetail).$promise.then(
                function(data){
                    console.log('update bank successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('delete bank failure');
                    console.log(error);
                });
            $uibModalInstance.close();
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });