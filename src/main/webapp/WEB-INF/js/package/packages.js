/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-packages',['bms-packages-controller'])
    .controller('bmsPackages',function($scope,$http,$q,$state){
        var deferred = $q.defer();
        $scope.load = function(){

            $http.get('http://localhost:8081/MajorBank/api/login/package/').then(function(response){
                    $scope.packages = response.data;
                    console.log($scope.packages);
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
    });