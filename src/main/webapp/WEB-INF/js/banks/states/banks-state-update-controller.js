angular.module('bms-banks-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsBanksStateUpdateController',function($scope,$state,$uibModalInstance,bmsBanksService,bankDetail,industryTypeOptions){

        $scope.industryTypeOptions = industryTypeOptions;
        $scope.bankDetail = bankDetail;

        for(var i=0;i<industryTypeOptions.length;i++){
            if(bankDetail.industryType ==industryTypeOptions[i].value ){
                $scope.option = $scope.industryTypeOptions[i];
                for(var j=0;j<$scope.industryTypeOptions[i].categories.length;j++){
                    if(bankDetail.qbCategory ==$scope.industryTypeOptions[i].categories[j].value){
                        $scope.categories = $scope.industryTypeOptions[i].categories[j];
                        for(var m=0;m<$scope.industryTypeOptions[i].categories[j].types.length;m++){
                            if(bankDetail.qbType == $scope.industryTypeOptions[i].categories[j].types[m].value){
                                $scope.types = $scope.industryTypeOptions[i].categories[j].types[m];
                                /*for(var n=0;n<$scope.industryTypeOptions[i].categories[j].types[m].banks.length;n++){
                                    var bankIdTmp = $scope.industryTypeOptions[i].categories[j].types[m].banks[n].bankId;
                                    var bankNameTmp = $scope.industryTypeOptions[i].categories[j].types[m].banks[n].bankName;
                                    if(bankDetail.bankIdsJson.indexOf(bankIdTmp)!=-1){
                                        var obj = {bankId:bankIdTmp,bankName:bankNameTmp};
                                        $scope.bankOptions.push(obj);
                                    }
                                }*/
                                break;
                            }
                        }
                        break;
                    }
                    break;
                }
            }
        }

        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.bankDetail);
            var bankId = $scope.bankDetail.bankId;
            $scope.bankDetail.industryType = $scope.option.value;
            $scope.bankDetail.qbCategory = $scope.categories.value;
            $scope.bankDetail.qbType = $scope.types.value;
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