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



    });