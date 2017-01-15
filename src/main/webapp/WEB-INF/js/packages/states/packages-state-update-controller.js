angular.module('bms-packages-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsPackagesStateUpdateController',
        function($scope,$state,$uibModalInstance,bmsPackagesService,packageDetail,
                 banksDetailForPkgId, industryTypeOptions,jobsOptions,jobsDropdownData){
            console.log("bmsPackagesStateUpdateController");
            console.log($uibModalInstance);
            console.log(packageDetail);
            $scope.packageDetail = packageDetail;

            $scope.banksDetailForPkgId = banksDetailForPkgId;

            $scope.industryTypeOptions = industryTypeOptions;

            $scope.jobsOptions = jobsOptions;
            $scope.jobsDropdownData = jobsDropdownData;
            console.log("jobsDropdownData");
            console.log(jobsDropdownData);

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

            //console.log($scope.jobOption.industryType);
            //$scope.jobDropdownOptions = [{industryType:"",jobGroup:"",jobId:"",jobName:""}];
            $scope.jobDropdownOptions = [];
            for(var i=0;i<$scope.jobsDropdownData.length;i++){
                var obj = {industryType:$scope.jobsDropdownData[i].industryType,
                    jobGroup:$scope.jobsDropdownData[i].jobGroup,
                    jobId:$scope.jobsDropdownData[i].jobId,
                    jobName:$scope.jobsDropdownData[i].jobName};
                $scope.jobDropdownOptions.push(obj);
            }

            // $scope.bankOptions=[];
            // $scope.modelBID = {};
            // $scope.modelBName = {};
            $scope.$watch('jobsList',function(newVal,oldVal){
                console.log("watch start...");
                console.log( $scope.jobsOptions);
                console.log( $scope.jobsList);
                if($scope.jobsList){
                    if($scope.jobDropdownOptions.length==1
                        && $scope.jobDropdownOptions[0].industryType==""){
                        $scope.jobDropdownOptions[0].industryType = $scope.jobsOptions[0].industryTypeValue;
                        $scope.jobDropdownOptions[0].jobGroup = $scope.jobGroupOptionsList.jobGroup;
                        $scope.jobDropdownOptions[0].jobId = $scope.jobsList.jobId;
                        $scope.jobDropdownOptions[0].jobName = $scope.jobsList.jobName;
                    }else{
                        var obj = {industryType:$scope.jobsOptions[0].industryTypeValue,
                            jobGroup:$scope.jobGroupOptionsList.jobGroup,
                            jobId:$scope.jobsList.jobId,
                            jobName:$scope.jobsList.jobName};
                        $scope.jobDropdownOptions.push(obj);
                    }
                }
            });
            $scope.delJobOptions=function(idx){
                $scope.jobDropdownOptions.splice(idx,1);
            };
            $scope.addJobOptions = function(){
                var obj = {industryType:$scope.jobsOptions[0].industryTypeValue,
                    jobGroup:$scope.jobGroupOptionsList.jobGroup,
                    jobId:$scope.jobsList.jobId,
                    jobName:$scope.jobsList.jobName};
                $scope.jobDropdownOptions.push(obj);
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

                //  获得Job IDS
                var strJobIds = "";
                console.log("start getting job IDS...");
                console.log($scope.jobDropdownOptions);
                for(var i=0;i<$scope.jobDropdownOptions.length;i++){
                    strJobIds = strJobIds + $scope.jobDropdownOptions[i].jobId;
                    if(i<$scope.jobDropdownOptions.length-1){
                        strJobIds = strJobIds + ",";
                    }
                }
                $scope.packageDetail.jobIds = strJobIds;

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