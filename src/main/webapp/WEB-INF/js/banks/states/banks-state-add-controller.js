angular.module('bms-banks-state-add-controller',[ 'ui.bootstrap','ngCookies'])
    .controller('bmsBanksStateAddController',function($scope,$state,$uibModalInstance,
                                                      bmsBanksService,bankDetail,industryTypeOptions,$cookieStore){

        $scope.bankDetail = bankDetail;
        $scope.industryTypeOptions = industryTypeOptions;
        var globals = $cookieStore.get("globals");
        //console.log("cookies:" + globals.currentUser.bankrole);
        $scope.option = globals.currentUser.industryTypeRole;
        $scope.option.label = "IT";
        console.log("$scope.option.value:"+$scope.option);
        $scope.categories = globals.currentUser.qbCategoryRole;

        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.option);
            console.log($scope.categories);
            console.log($scope.types);
            $scope.bankDetail.industryType = $scope.option.value;
            $scope.bankDetail.qbCategory = $scope.categories.value;
            $scope.bankDetail.qbType = $scope.types.value;
            bmsBanksService.Banks.createBank($scope.bankDetail).$promise.then(
                function(data){
                    console.log('create bank successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('create bank failure');
                    console.log(error);
                });
            $uibModalInstance.close();
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });