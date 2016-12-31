var bmsLogon = angular.module('bms-logon',
    ['ui.router','ngResource','bms-logon-service','bms-logon-states']);

bmsLogon.constant('AUTH_EVENTS', {  // 用户登录状态
        loginSuccess: 'auth-login-success',
        loginFailed: 'auth-login-failed',
        logoutSuccess: 'auth-logout-success',
        sessionTimeout: 'auth-session-timeout',
        notAuthenticated: 'auth-not-authenticated',
        notAuthorized: 'auth-not-authorized'
    }).constant('USER_ROLES', {   // 用户权限
        all: '*',
        admin: 'admin',
        editor: 'editor',
        guest: 'guest'
    });


bmsLogon.service('Session', function () {
    this.create = function (sessionId, userName, bankRole) {
        this.id = sessionId;
        this.userName = userName;
        this.bankRole = bankRole;
    };
    this.destroy = function () {
        this.id = null;
        this.userName = null;
        this.bankRole = null;
    };
});


bmsLogon.controller('bmsLogon',function($scope,$http,$q,$state,bmsLogonService,Session,$rootScope,AUTH_EVENTS){
        $scope.credentials = {
            username: '',
            password: '',
            bankrole: ''
        };

        var emptyFilterForm = {
            /*
            bankId: null,
            bankName:null
            */
        };


        $scope.logonForm = function (credentials) {
            var entry = bmsLogonService.UserInfo.logon().$promise.then(
                function(data){
                    console.log(data);
                    // sessionId, userId, userRole
                    Session.create(data[0].id,data[0].userName,data[0].bankRole);
                    $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
                    console.log('logon successfully');
                    $state.go("home",{test:"123"});
                },
                function(error){
                    $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
                    console.log('logon failure');
                    console.log(error);
                    // 重新执行load函数
                    $state.reload();
                });
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go("logon");
        };
    });