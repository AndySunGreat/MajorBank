angular.module('bms-questions-state-config', [])
    .config([ '$stateProvider', function ($stateProvider) {
        $stateProvider
            .state("home.questions",{
                url:"/questions",
                views:{
                      'home-condition@home':{
                          templateUrl: "ftl/questions/questions.ftl",
                          controller:"bmsQuestions",
                          resolve: {
                              industryTypeOptions: ['bmsBanksService',
                                  function (bmsPackagesService) {
                                      var test = bmsPackagesService.OptionsList.queryByParentValue().$promise;
                                      console.log(test);
                                      return test;
                                  }
                              ]
                          }
                      }
/*                     , "datalist":{  // 显示到index.jsp中<div ui-view="datalist">
                          templateUrl:"ftl/questions.datalist.ftl",
                          controller:"bmsQuestionsStateController"
                      },*/

                }
            })
            .state("home.questions.list",{
                url:"/list",
                params:{searchParams:null},
                views:{
                    "data-list@home.questions":{  // 显示到state为questions的<div ui-view="data-list">
                        templateUrl:"ftl/questions/questions.list.ftl",
                        controller:"bmsQuestionsStateController"
                    }
                }
            })
            .state("home.questions.list.detail",{
                url:"/{questionId}",
                views:{
                    "detail@home.questions.list":{
                        templateUrl:"ftl/questions/questions.list.detail.ftl",
                        resolve:{
                            questionDetail:['$stateParams','bmsQuestionsService',
                                function($stateParams,bmsQuestionsService){
                                    console.log("$stateParams.questionId:"+$stateParams.questionId);
                                    return  bmsQuestionsService.Questions.getQuestionDetail(
                                        {    questionId : $stateParams.questionId}
                                    ).$promise;
                                }
                            ]
                        },
                        controller:"bmsQuestionsStateDetailController"
                    }
                }
            });
    }]);