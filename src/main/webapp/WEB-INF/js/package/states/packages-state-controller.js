/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-packages-state-controller',[])
    .controller('bmsPackagesStateController',function($scope,$http,$q,$state,bmsPackagesService){
        console.log("bmsPackagesStateController");
        console.log($scope.packagedetail);
        var deferred = $q.defer();
        $scope.load = function(){
            var entry  = bmsPackagesService.Packages.query(function(){
                console.log(entry);
                $scope.packages = entry;
            });

        }
        $scope.editPackage = function(packageId){
            console.log("packageId:"+packageId);
        }

        $scope.deletePackage = function(packageId){
            console.log("packageId:"+packageId);
            $http.delete('http://localhost:8081/MajorBank/api/login/package/'+packageId)
                .then(function(result){
                    console.log(result);
                    // 重新执行load函数
                    $state.reload();
                },function(error){
                    console.log(error);
                });
        }

        $scope.retrieveDetail = function(packageId) {
                $state.go('packages.detail', {
                    packageId : packageId });

        }
    });