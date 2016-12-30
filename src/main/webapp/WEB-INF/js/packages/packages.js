/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-packages',['bms-packages-service','bms-packages-states'])
    .controller('bmsPackages',function($scope,$http,$q,$state,bmsPackagesService,industryTypeOptions){
        var emptyFilterForm = {
            packageId: null,
            packageName:null,
            jobId:null,
            bankIdsJson:null
        };
        $scope.industryTypeOptions = industryTypeOptions;
        $scope.queryForm = function(searchFilter){
            if(searchFilter!=undefined){
                $state.go("home.packages.list",{searchParams:searchFilter},{reload:true});
            }else{
                $state.go("home.packages.list",{searchParams:null},{reload:true});
            }
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go('home.packages');
        };
    });