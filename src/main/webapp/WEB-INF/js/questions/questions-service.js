//$provide服务负责告诉Angular如何创造一个新的可注入的东西：即服务(service)。
angular.module('bms-questions-service',['ngResource'])
    .provider("bmsQuestionsService",function(){
        var baseUrl = "http://localhost:8081/MajorBank/api/";
        // $get来返回provider实例
        this.$get =["$resource",function($resource){
            return {
                QuestionsList:$resource(baseUrl + "banks/:bankId/questions/",
                    {
                        bankId:"@bankId",
                        questionId:"@questionId"
                    },
                    {
                        searchFilter:{
                            url: baseUrl + "banks/:bankId/questions/",
                            method: 'GET',
                            isArray: true
                        }
                    })
                ,
                Questions: $resource(baseUrl + "banks/:bankId/questions/", {},
                    {
                        query: {
                            url: baseUrl + "banks/:bankId/questions/",
                            method: 'GET',
                            isArray: true
                        },
                        createQuestion: {
                            method: 'POST'
                        },
                        getQuestionDetail:{
                            url:baseUrl + "banks/:bankId/questions/:questionId",
                            method: 'GET'
                        },
                        deleteQuestion:{
                            url:baseUrl + "banks/:bankId/questions/:questionId",
                            method:'DELETE'
                        },
                        updateQuestion:{
                            url:baseUrl + "banks/:bankId/questions/:questionId",
                            method:'PUT'
                        }
                    })
            };
        }];

    });