//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-questions-service',['ngResource'])
    .provider("bmsQuestionsService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/api/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                QuestionsList:$resource(baseUrl + "login/question/",
                    {
                        questionId:"@questionId"
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "login/question",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                Questions: $resource(baseUrl + "login/question/", {},
                    {
                        query: {
                            url: baseUrl + "login/question",
                            method: 'GET',
                            isArray: true
                        },
                        createQuestion: {
                            method: 'POST'
                        },
                        getQuestionDetail:{
                            url:baseUrl + "login/question/:questionId",
                            method: 'GET'
                        },
                        deleteQuestion:{
                            url:baseUrl + "login/question/:questionId",
                            method:'DELETE'
                        },
                        updateQuestion:{
                            url:baseUrl + "login/question/:questionId",
                            method:'PUT'
                        }
                    })
            };
        }];

    });