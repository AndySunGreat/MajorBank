<div class="row" ng-init="load()">
    <div class="span7">
           <table class="table table-striped table-condensed">
               <thead>
                   <tr>
                        <th style="width:150px;padding:5px;">问题编号</th>
                        <th style="width:150px;padding:5px;">题库编号</th>
                        <th style="width:150px;padding:5px;">问题内容</th>
                        <th style="width:150px;padding:5px;">问题类型</th>
                        <th style="width:150px;padding:5px;">正确答案</th>
                        <th style="width:150px;padding:5px;">修改日期</th>
                   </tr>
               </thead>
               <tbody>
                    <tr ng-repeat="question in questions">
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(question.questionId)">{{question.questionId}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(question.questionId)">{{question.bankId}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(question.questionId)">{{question.questContent}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(question.questionId)">{{question.questType}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(question.questionId)">{{question.correctAnswer}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(question.questionId)">{{question.changeDate}}</td>
                        <td style="width:150px;padding:5px;">
                            <button id="editBtn" class="btn btn-small btn-primary" data-target="#myModal" ng-click="editQuestion(question.questionId)">Edit</button>
                            <button id="deleteBtn" class="btn btn-small btn-danger" ng-click="deleteQuestion(question.questionId)">Delete</button>
                        </td>

                   </tr>
               </tbody>
           </table>
    </div>
    <button id="createBtn" class="btn btn-small btn-success"
            data-target="#myModal" ng-click="createQuestion()">Create Question</button>
</div>
<div ui-view="detail"></div>