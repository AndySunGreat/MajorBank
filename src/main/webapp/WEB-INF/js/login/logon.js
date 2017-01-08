var bmsLogon = angular.module('bms-logon',
    ['ui.router','ngResource','ngCookies','bms-logon-service','bms-logon-states']);

bmsLogon.factory('AuthenticationService',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout','bmsLogonService',
        function (Base64, $http, $cookieStore,$rootScope, $timeout,bmsLogonService) {
            var service = {};

            service.Login = function (username, password, callback) {

                /* Dummy authentication for testing, uses $timeout to simulate api call
                 ----------------------------------------------*/
                /*  $timeout(function(){
                 var response = { success: username === 'test' && password === 'test' };
                 if(!response.success) {
                 response.message = 'Username or password is incorrect';
                 }
                 callback(response);
                 }, 1000);
                 */
                var loginUserInfo = [];
                loginUserInfo.username = username;
                loginUserInfo.password = password;

                bmsLogonService.UserInfo.login(loginUserInfo).$promise.then(
                    function(data){
                        console.log('login in successfully');
                        console.log(data);
                        callback(data);
                        // 重新执行load函数
                        //$state.reload();
                    },
                    function(error){
                        console.log('login in failure');
                        console.log(error);
                        callback(error);
                    });
                /* Use this for real authentication
                 ----------------------------------------------*/
                /*$http.post('/api/authenticate', { username: username, password: password })
                 .success(function (response) {
                 callback(response);
                 });*/
            };

            service.SetCredentials = function (username, password,industryTypeRole,
                                               qbCategoryRole,qbTypeRole,bankRole) {
                var authdata = Base64.encode(username + ':' + password);

                $rootScope.globals = {
                    currentUser: {
                        username: username,
                        industryTypeRole:industryTypeRole,
                        qbCategoryRole:qbCategoryRole,
                        qbTypeRole:qbTypeRole,
                        bankRole:bankRole,
                        authdata: authdata
                    }
                };

                $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
                $cookieStore.put('globals', $rootScope.globals);
            };

            service.ClearCredentials = function () {
                $rootScope.globals = {};
                $cookieStore.remove('globals');
                $http.defaults.headers.common.Authorization = 'Basic ';
            };

            return service;
        }]);

bmsLogon.factory('Base64', function () {
        /* jshint ignore:start */

        var keyStr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';

        return {
            encode: function (input) {
                var output = "";
                var chr1, chr2, chr3 = "";
                var enc1, enc2, enc3, enc4 = "";
                var i = 0;

                do {
                    chr1 = input.charCodeAt(i++);
                    chr2 = input.charCodeAt(i++);
                    chr3 = input.charCodeAt(i++);

                    enc1 = chr1 >> 2;
                    enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                    enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                    enc4 = chr3 & 63;

                    if (isNaN(chr2)) {
                        enc3 = enc4 = 64;
                    } else if (isNaN(chr3)) {
                        enc4 = 64;
                    }

                    output = output +
                        keyStr.charAt(enc1) +
                        keyStr.charAt(enc2) +
                        keyStr.charAt(enc3) +
                        keyStr.charAt(enc4);
                    chr1 = chr2 = chr3 = "";
                    enc1 = enc2 = enc3 = enc4 = "";
                } while (i < input.length);

                return output;
            },

            decode: function (input) {
                var output = "";
                var chr1, chr2, chr3 = "";
                var enc1, enc2, enc3, enc4 = "";
                var i = 0;

                // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
                var base64test = /[^A-Za-z0-9\+\/\=]/g;
                if (base64test.exec(input)) {
                    window.alert("There were invalid base64 characters in the input text.\n" +
                        "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                        "Expect errors in decoding.");
                }
                input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

                do {
                    enc1 = keyStr.indexOf(input.charAt(i++));
                    enc2 = keyStr.indexOf(input.charAt(i++));
                    enc3 = keyStr.indexOf(input.charAt(i++));
                    enc4 = keyStr.indexOf(input.charAt(i++));

                    chr1 = (enc1 << 2) | (enc2 >> 4);
                    chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                    chr3 = ((enc3 & 3) << 6) | enc4;

                    output = output + String.fromCharCode(chr1);

                    if (enc3 != 64) {
                        output = output + String.fromCharCode(chr2);
                    }
                    if (enc4 != 64) {
                        output = output + String.fromCharCode(chr3);
                    }

                    chr1 = chr2 = chr3 = "";
                    enc1 = enc2 = enc3 = enc4 = "";

                } while (i < input.length);

                return output;
            }
        };

        /* jshint ignore:end */
    });

bmsLogon.controller('bmsLogon',
    function($scope,$http,$q,$state,AuthenticationService,
             bmsLogonService,$rootScope){
        $scope.credentials = {
            username: '',
            password: '',
            bankrole: ''
        };
        // reset login status
        AuthenticationService.ClearCredentials();


        $scope.logonForm = function (credentials) {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, function(response) {
                if(response.length==1) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password,
                        response[0].industryTypeRole,
                        response[0].qbCategoryRole,
                        response[0].qbTypeRole,
                        response[0].bankrole);
                    //$location.path('/');
                    $state.go("home",{test:"123"});
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };

        $scope.resetForm = function(){
            $scope.searchFilter = angular.copy(emptyFilterForm);
            $state.go("logon");
        };
    });