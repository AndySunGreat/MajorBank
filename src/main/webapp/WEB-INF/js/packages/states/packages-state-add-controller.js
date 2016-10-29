angular.module('bms-packages-state-add-controller',[ 'ui.bootstrap'])
    .controller('bmsPackagesStateAddController',
        function($scope,$state,$uibModalInstance,bmsPackagesService,packageDetail,industryTypeOptions){
            //console.log("bmsPackagesStateAddController");
            //console.log($uibModalInstance);
            //console.log(packageDetail);
            $scope.packageDetail = packageDetail;
            $scope.industryTypeOptions = industryTypeOptions;
            $scope.searchBanksParams = new Object();
            $scope.bankOptions = [{bankId:"",bankName:""}];
            //$scope.bankOptions=[];
            $scope.modelBID = {};
            $scope.modelBName = {};
            $scope.$watch('banks',function(newVal,oldVal){
                if($scope.banks){
                    if($scope.bankOptions.length==1
                        && $scope.bankOptions[0].bankId==""){
                        $scope.bankOptions[0].bankId = $scope.banks.bankId;
                        $scope.bankOptions[0].bankName = $scope.banks.bankName;
                    }else{
                        var obj = {bankId:$scope.banks.bankId,bankName:$scope.banks.bankName};
                        $scope.bankOptions.push(obj);
                    }
                }
            });
            $scope.delBankOptions=function(idx){
                $scope.bankOptions.splice(idx,1);
            };
            $scope.addBank = function(){
                var obj = {bankId:$scope.banks.bankId,bankName:$scope.banks.bankName};
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