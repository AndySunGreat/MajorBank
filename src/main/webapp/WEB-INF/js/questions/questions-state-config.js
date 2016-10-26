angular.module('bms-questions-state-config', [])
    .config([ '$stateProvider', function ($stateProvider) {
        $stateProvider
            .state("questions",{
                url:"/questions",
                views:{
                      '':{
                          templateUrl: "ftl/questions/questions.ftl",
                          controller:"bmsQuestions"
                      }
/*                     , "datalist":{  // 显示到index.jsp中<div ui-view="datalist">
                          templateUrl:"ftl/questions.datalist.ftl",
                          controller:"bmsQuestionsStateController"
                      },*/

                }
            })
            .state("questions.list",{
                url:"/list",
                params:{searchParams:null},
                views:{
                    "data-list@questions":{  // 显示到state为questions的<div ui-view="data-list">
                        templateUrl:"ftl/questions/questions.list.ftl",
                        controller:"bmsQuestionsStateController"
                    }
                }
            })
            .state("questions.list.detail",{
                url:"/{bankId}/{questionId}",
                views:{
                    "detail@questions.list":{
                        templateUrl:"ftl/questions/questions.list.detail.ftl",
                        resolve:{
                            questionDetail:['$stateParams','bmsQuestionsService',
                                function($stateParams,bmsQuestionsService){
                                    console.log("$stateParams.questionId:"+$stateParams.questionId);
                                    console.log("$stateParams.bankId:"+$stateParams.bankId);
                                    return  bmsQuestionsService.Questions.getQuestionDetail(
                                        {   bankId:$stateParams.bankId,
                                            questionId : $stateParams.questionId}
                                    ).$promise;
                                }
                            ]
                        },
                        controller:"bmsQuestionsStateDetailController"
                    }
                }
            });
    }]);