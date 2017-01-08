<button id="createBtn" class="btn btn-small btn-success"
        data-target="#myModal" ng-click="createBank()">新建题库</button>
<div class="row" ng-init="load()">
    <div class="span7">
           <table class="table table-striped table-condensed">
               <thead>
                   <tr>
                        <th style="width:150px;padding:5px;">题库编号</th>
                        <th style="width:150px;padding:5px;">题库名称</th>
                        <th style="width:150px;padding:5px;">行业类型</th>
                        <th style="width:150px;padding:5px;">题库范畴</th>
                        <th style="width:150px;padding:5px;">题库类型</th>
                        <th style="width:150px;padding:5px;">题库版本</th>
                        <th style="width:150px;padding:5px;">修改日期</th>
                        <th style="width:150px;padding:5px;">操作区域</th>
                   </tr>
               </thead>
               <tbody>
                    <tr ng-repeat="bank in banks">
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.bankId}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.bankName}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.industryType}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.qbCategory}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.qbType}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.changeDate}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail(bank.bankId)">{{bank.qbVersion}}</td>
                        <td style="width:150px;padding:5px;">
                            <button id="editBtn" class="btn btn-small btn-primary" data-target="#myModal" ng-click="editBank(bank.bankId)">编辑</button>
                            <button id="deleteBtn" class="btn btn-small btn-danger" ng-click="deleteBank(bank.bankId)">删除</button>
                        </td>
                   </tr>
               </tbody>
           </table>
    </div>

</div>
<div ui-view="detail"></div>