angular.module('bms-questions-state-add-controller',[ 'ui.bootstrap'])
    .controller('bmsQuestionsStateAddController',function($scope,$state,$uibModalInstance,bmsQuestionsService,questionDetail){

        $scope.questionDetail = questionDetail;

       $scope.addiDynamicParamList = [{optSeq:"",optContent:""}];


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