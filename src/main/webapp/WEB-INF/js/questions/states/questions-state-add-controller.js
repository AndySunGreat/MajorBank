angular.module('bms-questions-state-add-controller',[ 'ui.bootstrap'])
    .controller('bmsQuestionsStateAddController',function($scope,$state,$uibModalInstance,bmsQuestionsService,questionDetail){

        $scope.questionDetail = questionDetail;
        $scope.submitModal = function() {
            console.log("submit前数据提交：");
            console.log($scope.questionDetail);
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