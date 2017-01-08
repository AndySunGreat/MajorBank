/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-banks',['bms-banks-service','bms-banks-states','ngCookies'])
    .controller('bmsBanks',function($scope,$http,$q,$state,bmsBanksService,industryTypeOptions,$cookieStore){
        var emptyFilterForm = {
            bankId: null,
            bankName:null,
            qbCategory:null,
            industryType:null,
            qbType:null,
            qbVersion:null
        };
        var globals = $cookieStore.get("globals");
        console.log("cookies:" + globals.currentUser.bankrole);
        $scope.industryTypeOptions = industryTypeOptions;


        $scope.queryForm = function(searchFilter){
            //console.log($scope.searchFilter);
            //console.log($scope.option);
           // console.log($scope.categories);
            if(searchFilter==undefined && $scope.option==undefined
                && $scope.categories == undefined
                && $scope.types == undefined)
            {
                $state.go("home.banks.list",{searchParams:null},{reload:true});
            }else{
                if(searchFilter==undefined){
                    $scope.searchFilter = new Object();
                }
                if($scope.option!=undefined){
                    $scope.searchFilter.industryType = $scope.option.value;
                }
                if($scope.categories!=undefined) {
                    $scope.searchFilter.qbCategory = $scope.categories.value;
                }
                if($scope.types!=undefined) {
                    $scope.searchFilter.qbType = $scope.types.value;
                }
                console.log("bankjs searchFilter:"+$scope.searchFilter);
                $state.go("home.banks.list",{searchParams:$scope.searchFilter},{reload:true});
            }
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go('home.banks');
        };
    });