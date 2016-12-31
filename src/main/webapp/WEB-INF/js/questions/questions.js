/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-questions',['bms-questions-service','bms-questions-states'])
    .controller('bmsQuestions',function($scope,$http,$q,$state,bmsQuestionsService,industryTypeOptions){
        var emptyFilterForm = {
            questionId: null,
            bankId:null,
            questContent:null,
            questType:null
        };
        $scope.industryTypeOptions = industryTypeOptions;
        var entry  = bmsQuestionsService.BanksList.searchFilter($scope.searchParams,function(){
            console.log(entry);
            $scope.tags = entry;
        });
        $scope.tags = [];

        $scope.loadTags = function(query) {
            return tags.query().$promise;
        };
        $scope.queryForm = function(searchFilter){
            if(searchFilter!=undefined){
                $state.go("home.questions.list",{searchParams:searchFilter},{reload:true});
            }else{
                $state.go("home.questions.list",{searchParams:null},{reload:true});
            }
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go('home.questions');
        };
    });