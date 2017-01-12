angular.module('bms-packages-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsPackagesStateUpdateController',
        function($scope,$state,$uibModalInstance,bmsPackagesService,packageDetail,banksDetailForPkgId, industryTypeOptions,jobsOptions){
            console.log("bmsPackagesStateUpdateController");
            console.log($uibModalInstance);
            console.log(packageDetail);
            $scope.packageDetail = packageDetail;

            $scope.banksDetailForPkgId = banksDetailForPkgId;

            $scope.industryTypeOptions = industryTypeOptions;

            $scope.jobsOptions = jobsOptions;

            $scope.bankOptions = [];
            //var obj = {bankId:"",bankName:""};

            for(var i=0;i<$scope.banksDetailForPkgId.length;i++){
                var obj = {bankId:$scope.banksDetailForPkgId[i].bankId,
                    bankName:$scope.banksDetailForPkgId[i].bankName,
                    qbType:$scope.banksDetailForPkgId[i].qbType};
                $scope.bankOptions.push(obj);
            }

            $scope.$watch('banks',function(newVal,oldVal){
                if($scope.banks){
                    if($scope.bankOptions.length==1
                        && $scope.bankOptions[0].bankId==""){
                        $scope.bankOptions[0].bankId = $scope.banks.bankId;
                        $scope.bankOptions[0].bankName = $scope.banks.bankName;
                        $scope.bankOptions[0].qbType = $scope.banks.qbType;
                    }else{
                        var obj = {bankId:$scope.banks.bankId,
                            bankName:$scope.banks.bankName,
                            qbType:$scope.banks.qbType
                        };
                        $scope.bankOptions.push(obj);
                    }
                }
            });

            $scope.delBankOptions=function(idx){
                $scope.bankOptions.splice(idx,1);
            };
            $scope.addBank = function(){
                var obj = {bankId:$scope.banks.bankId,
                    bankName:$scope.banks.bankName,
                    qbType:$scope.banks.qbType};
                $scope.bankOptions.push(obj);

            }
            $scope.submitModal = function() {
                console.log("submit前数据提交：");
                console.log($scope.packageDetail);
                var strBankIdsJson = "";
                for(var i=0;i<$scope.bankOptions.length;i++){
                    strBankIdsJson = strBankIdsJson + $scope.bankOptions[i].bankId;
                    if(i<$scope.bankOptions.length-1){
                        strBankIdsJson = strBankIdsJson + ",";
                    }
                }
                var packageId = $scope.packageDetail.packageId;
                $scope.packageDetail.bankIdsJson = strBankIdsJson;
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