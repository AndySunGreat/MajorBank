angular.module('bms-questions-state-update-controller',[ 'ui.bootstrap'])
    .controller('bmsQuestionsStateUpdateController',function($scope,$state,$uibModalInstance,bmsQuestionsService,questionDetail){

        $scope.questionDetail = questionDetail;
        console.log($scope.questionDetail);
        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.questionDetail);
            var questionId = $scope.questionDetail.questionId;
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