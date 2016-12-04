//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-questions-service',['ngResource'])
    .provider("bmsQuestionsService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/api/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                BanksList:$resource(baseUrl + "banks/",
                    {
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "banks/",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                QuestionsList:$resource(baseUrl + "questions/",
                    {
                         questionId:"@questionId"
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "questions/",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                Questions: $resource(baseUrl + "questions/", {},
                    {
                        query: {
                            url: baseUrl + "questions/",
                            method: 'GET',
                            isArray: true
                        },
                        createQuestion: {
                            method: 'POST'
                        },
                        getQuestionDetail:{
                            url:baseUrl + "questions/:questionId",
                            method: 'GET'
                        },
                        deleteQuestion:{
                            url:baseUrl + "questions/:questionId",
                            method:'DELETE'
                        },
                        updateQuestion:{
                            url:baseUrl + "questions/:questionId",
                            method:'PUT'
                        }
                    })
            };
        }];

    });