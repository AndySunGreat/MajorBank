/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-banks',['bms-banks-service','bms-banks-states'])
    .controller('bmsBanks',function($scope,$http,$q,$state,bmsBanksService,industryTypeOptions){
        var emptyFilterForm = {
            bankId: null,
            bankName:null,
            qbCategory:null,
            industryType:null,
            qbType:null,
            qbVersion:null
        };

        $scope.industryTypeOptions = industryTypeOptions;


        $scope.changeForIndustryOption = function(industryType){
            console.log(industryType);
            $scope.qbCategoryOptions = bmsBanksService.OptionsList.queryByParentValue(
                {    itemParentValue: industryType.itemValue}).$promise;
        }

        $scope.changeForQBCategoryOption = function(qbCategory){
            console.log(qbCategory);
        }


        $scope.queryForm = function(searchFilter){
            if(searchFilter!=undefined){
                $state.go("banks.list",{searchParams:searchFilter},{reload:true});
            }else{
                $state.go("banks.list",{searchParams:null},{reload:true});
            }
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go('banks');
        };
    });