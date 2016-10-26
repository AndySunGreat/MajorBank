/**
 * Created by AndySun on 2016/10/21.
 */
var myApp = angular.module("myApp", ["ui.router",'ngResource',
    'bms-home-controller','bms-packages','bms-questions']);

myApp.config(function ($stateProvider, $urlRouterProvider) {

    //$urlRouterProvider.when("", "/PageTab");

    $stateProvider
        .state("Home",{
            url:"/",
            templateUrl:"jsp/index.jsp",
            controller:"bmsMainPageController"
        })
        .state("BanksMgt",{
            url:"/BanksMgt",
            templateUrl: "ftl/BanksMgt.ftl",
            resolve:{

            }
        });
});