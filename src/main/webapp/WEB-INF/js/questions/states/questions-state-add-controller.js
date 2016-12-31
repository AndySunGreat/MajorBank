angular.module('bms-questions-state-add-controller',[ 'ui.bootstrap'])
    .controller('bmsQuestionsStateAddController',
        function($scope,$state,$uibModalInstance,bmsQuestionsService,questionDetail,industryTypeOptions){

        $scope.questionDetail = questionDetail;
        $scope.industryTypeOptions = industryTypeOptions;
        $scope.addiDynamicParamList = [{optSeq:"",optContent:""}];
        $scope.bankOptions = [{bankId:"",bankName:"",qbType:""}];

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
                            qbType:$scope.banks.qbType};
                        $scope.bankOptions.push(obj);
                    }
                }
            });

        console.log($scope.addiDynamicParamList);
        $scope.addAdditionalParams = function(){
            var obj={optSeq:"",optContent:""};
            $scope.addiDynamicParamList.push(obj);
        };
        $scope.delAdditionalParams=function(idx){
            $scope.addiDynamicParamList.splice(idx,1);
        };


        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.questionDetail);
            $scope.concatListCE = $scope.addiDynamicParamList;
            console.log($scope.concatListCE);
            console.log("angular.toJson:" + angular.toJson($scope.concatListCE));
/*            var tmpCE = {};
            var convertTmpCE = new Object();
            for(var i in $scope.concatListCE){
                tmpCE = $scope.concatListCE[i];
                console.log(tmpCE["optSeq"]);
                convertTmpCE[tmpCE["key"]] = tmpCE["value"];
            }
            console.log(convertTmpCE);*/
            $scope.questionDetail.questOptionsJson = angular.toJson($scope.concatListCE);
            var questionId = $scope.questionDetail.questionId;
            bmsQuestionsService.Questions.createQuestion($scope.questionDetail).$promise.then(
                function(data){
                    console.log('create question successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('create question failure');
                    console.log(error);
                });
            $uibModalInstance.close();
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });