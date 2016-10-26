/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-questions',['bms-questions-service','bms-questions-states'])
    .controller('bmsQuestions',function($scope,$http,$q,$state,bmsQuestionsService){
        var emptyFilterForm = {
            questionId: null,
            bankId:null,
            questContent:null,
            questType:null
        };

        $scope.queryForm = function(searchFilter){
            if(searchFilter!=undefined){
                $state.go("questions.list",{searchParams:searchFilter},{reload:true});
            }else{
                $state.go("questions.list",{searchParams:null},{reload:true});
            }
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go('questions');
        };
    });