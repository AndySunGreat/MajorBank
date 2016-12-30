/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-questions-state-controller',['ui.bootstrap'])
    .controller('bmsQuestionsStateController',
        function($scope,$uibModal,$q,$state,bmsQuestionsService,$log,$stateParams){
        console.log("state-controller");

        var emptyFilterForm = {
            questionId: null,
            bankId:null,
            questContent:null,
            questType:null
        };
        //var deferred = $q.defer();
        $scope.load = function(){
            console.log($stateParams.searchParams);
            $scope.searchParams = $stateParams.searchParams;
            console.log(angular.toJson($scope.searchParams));
            var entry  = bmsQuestionsService.QuestionsList.searchFilter($scope.searchParams,function(){
                console.log(entry);
                $scope.questions = entry;
            });
        };

        $scope.createQuestion = function(){
            var modalInstance;
            modalInstance = $uibModal.open({
                size:'lg',
                backdrop : false,
                templateUrl: 'ftl/questions/questions.modal.ftl',
                resolve: {
                    questionDetail: angular.copy(emptyFilterForm)
                },
                controller: 'bmsQuestionsStateAddController'
            });
            modalInstance.opened.then(function() {// 模态窗口打开之后执行的函数
                console.log('modal is opened');
            });
            modalInstance.result.then(function (result) {
                $state.reload();
            },function(){
                console.log("modal failure!");
                $log.info('Modal dismissed at: ' + new Date());
            });
        };

        $scope.editQuestion = function(questionId){
            console.log("questionId:"+questionId);
            var modalInstance;
            modalInstance = $uibModal.open({
                size:'lg',
                backdrop : false,
                templateUrl: 'ftl/questions/questions.modal.ftl',
                resolve: {
                    questionDetail: ['bmsQuestionsService',
                        function (bmsQuestionsService) {
                            return bmsQuestionsService.Questions.getQuestionDetail(
                                {   questionId: questionId}
                            ).$promise;
                        }
                    ]
                },
                controller: 'bmsQuestionsStateUpdateController'

            });
            modalInstance.opened.then(function() {// 模态窗口打开之后执行的函数
                console.log('modal is opened');
            });
            modalInstance.result.then(function (result) {
                $state.reload();
            },function(){
                console.log("modal failure!");
                $log.info('Modal dismissed at: ' + new Date());
            });

        }

        $scope.deleteQuestion = function(questionId){
            console.log("questionId:"+questionId);
            bmsQuestionsService.Questions.deleteQuestion({questionId:questionId}).$promise.then(
                function(data){
                    console.log('delete question successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('delete question failure');
                    console.log(error);
                });
        }

        $scope.retrieveDetail = function(questionId) {
                $state.go('home.questions.list.detail', {
                     questionId : questionId });

        }
    });