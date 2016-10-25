/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-packages',['bms-packages-service','bms-packages-states'])
    .controller('bmsPackages',function($scope,$http,$q,$state,bmsPackagesService){
        var emptyFilterForm = {
            packageId: null,
            packageName:null,
            jobId:null,
            bankIdsJson:null
        };

        $scope.queryForm = function(searchFilter){
            if(searchFilter!=undefined){
                $state.go("packages.list",{searchParams:searchFilter},{reload:true});
            }else{
                $state.go("packages.list",{searchParams:null});
            }
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go('packages');
        };
    });