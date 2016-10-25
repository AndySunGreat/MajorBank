angular.module('bms-questions-state-detail-controller',[])
    .controller('bmsQuestionsStateDetailController',function($scope,$state,questionDetail){
        console.log(questionDetail);
        $scope.questionDetail = questionDetail;
        console.log($scope.questionDetail);

    });