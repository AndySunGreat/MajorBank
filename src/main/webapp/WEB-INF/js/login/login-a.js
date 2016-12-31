var bmsLogin = angular.module('bms-login',['ngResource']);

bmsLogin.constant('AUTH_EVENTS', {  // 用户登录状态
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

bmsLogin.service('Session', function () {
    this.create = function (sessionId, userId, userRole) {
        this.id = sessionId;
        this.userId = userId;
        this.userRole = userRole;
    };
    this.destroy = function () {
        this.id = null;
        this.userId = null;
        this.userRole = null;
    };
});

bmsLogin.factory('AuthService', function ($http, Session) {
    var authService = {};

    authService.login = function (credentials) {

    /*        //本地提供的服务，可用loopback快速搭建
        var api = $resource('http://localhost:3000/api/user_tests');

        //因为没有写服务端验证用户密码，使用save是为了方便；
        //这里，如果服务端已存在该credentials，返回的response会包含错误信息，可用来替代401、403等；
        return api.save(credentials)
            .$promise
            .then(function(res) {
                Session.create(res.id, res.id,
                    res.Role);
                return res;
            });*/
    };

    authService.isAuthenticated = function () {
        return !!Session.userId;
    };

    authService.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
            authorizedRoles = [authorizedRoles];
        }
        return (authService.isAuthenticated() &&
        authorizedRoles.indexOf(Session.userRole) !== -1);
    };

    return authService;
});

bmsLogin.controller('LoginController', function ($scope, $rootScope, AUTH_EVENTS, AuthService) {
    $scope.credentials = {
        username: '',
        password: ''
    };
    $scope.login = function (credentials) {
        AuthService.login(credentials).then(function (user) {
            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
            $scope.setCurrentUser(user);
        }, function () {
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
        });
    };
})