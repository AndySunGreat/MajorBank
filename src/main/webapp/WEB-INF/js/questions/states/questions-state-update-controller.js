angular.module('bms-questions-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsQuestionsStateUpdateController',function($scope,$state,$uibModalInstance,bmsQuestionsService,questionDetail){

        //$scope.addiDynamicParamList = [{optSeq:"",optContent:""}];
        $scope.addiDynamicParamList = angular.fromJson(questionDetail.questOptionsJson);
        $scope.addAdditionalParams = function(){
            var obj={optSeq:"",optContent:""};
            $scope.addiDynamicParamList.push(obj);
        };
        $scope.delAdditionalParams=function(idx){
            $scope.addiDynamicParamList.splice(idx,1);
        };

        $scope.questionDetail = questionDetail;
        console.log($scope.questionDetail);
        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.questionDetail);
            var questionId = $scope.questionDetail.questionId;
            $scope.questionDetail.questOptionsJson = angular.toJson($scope.addiDynamicParamList);
            bmsQuestionsService.Questions.updateQuestion({questionId:questionId},$scope.questionDetail).$promise.then(
                function(data){
                    console.log('update question successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('delete question failure');
                    console.log(error);
                });
            $uibModalInstance.close();
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });