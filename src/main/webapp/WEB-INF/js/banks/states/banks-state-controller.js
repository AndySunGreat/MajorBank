/**
 * Created by AndySun on 2016/10/20.
 */
angular.module('bms-banks-state-controller',['ui.bootstrap','ngCookies'])
    .controller('bmsBanksStateController',
        function($scope,$uibModal,$q,$state,bmsBanksService,$log,$stateParams,$cookieStore){
        console.log("state-controller");
            console.log($stateParams.searchParams);
            console.log($cookieStore);
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
            console.log("state-controller-load():"+ $stateParams.searchParams);
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
                    bankDetail: angular.copy(emptyFilterForm),
                    industryTypeOptions:['bmsBanksService',
                        function(bmsBanksService){
                            var test =   bmsBanksService.OptionsList.queryByParentValue().$promise;
                            console.log(test);
                            return test;
                        }
                    ]
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
                    ],
                    industryTypeOptions:['bmsBanksService',
                        function(bmsBanksService){
                            var test =   bmsBanksService.OptionsList.queryByParentValue().$promise;
                            console.log(test);
                            return test;
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
                $state.go('home.banks.list.detail', {
                     bankId : bankId });

        }
    });