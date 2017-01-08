/**
 * Created by AndySun on 2016/10/21.
 */

'use strict'
var myApp = angular.module("majorApp", ['ngCookies','ui.router','ngResource',
    'bms-logon', 'bms-home-controller','bms-packages','bms-questions','bms-banks']);

myApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when("", "/");

    $stateProvider
        .state("logon",{
            url:"/",
            templateUrl:"ftl/login/login.ftl",
            controller:"bmsLogon"
        })
        .state("home",{
            url:"/home",
            templateUrl: "ftl/home/home.ftl",
            controller:"bmsHome"
        });
});