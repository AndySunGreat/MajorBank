/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-banks-state-controller',['ui.bootstrap'])
    .controller('bmsBanksStateController',
        function($scope,$uibModal,$q,$state,bmsBanksService,$log,$stateParams){
        console.log("state-controller");

            var emptyFilterForm = {
                bankId: null,
                bankName:null,
                qbCategory:null,
                industryType:null,
                qbType:null,
                qbVersion:null
            };
        //var deferred = $q.defer();
        $scope.load = function(){
            console.log($stateParams.searchParams);
            $scope.searchParams = $stateParams.searchParams;
            console.log(angular.toJson($scope.searchParams));
            var entry  = bmsBanksService.BanksList.searchFilter($scope.searchParams,function(){
                console.log(entry);
                $scope.banks = entry;
            });
        };

        $scope.createBank = function(){
            var modalInstance;
            modalInstance = $uibModal.open({
                size:'lg',
                backdrop : false,
                templateUrl: 'ftl/banks/banks.modal.ftl',
                resolve: {
                    bankDetail: angular.copy(emptyFilterForm)
                },
                controller: 'bmsBanksStateAddController'
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

        $scope.editBank = function(bankId){
            console.log("bankId:"+bankId);
            var modalInstance;
            modalInstance = $uibModal.open({
                size:'lg',
                backdrop : false,
                templateUrl: 'ftl/banks/banks.modal.ftl',
                resolve: {
                    bankDetail: ['bmsBanksService',
                        function (bmsBanksService) {
                            return bmsBanksService.Banks.getBankDetail(
                                {   bankId: bankId}
                            ).$promise;
                        }
                    ]
                },
                controller: 'bmsBanksStateUpdateController'

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

        $scope.deleteBank = function(bankId){
            console.log("bankId:"+bankId);
            bmsBanksService.Banks.deleteBank({bankId:bankId}).$promise.then(
                function(data){
                    console.log('delete bank successfully');
                    console.log(data);
                    // 重新执行load函数
                    $state.reload();
                },
                function(error){
                    console.log('delete bank failure');
                    console.log(error);
                });
        }

        $scope.retrieveDetail = function(bankId) {
                $state.go('banks.list.detail', {
                     bankId : bankId });

        }
    });