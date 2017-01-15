<div class="row" ng-init="load(packages)">
    <div class="span7">
           <table class="table table-striped table-condensed" style="word-break:break-all; word-wrap:break-all;">
               <thead>
                   <tr>
                        <th style="width:100px;padding:5px;">套餐编号</th>
                        <th style="width:150px;padding:5px;">套餐名称</th>
                        <th style="width:150px;padding:5px;">关联职业</th>
                        <th style="width:200px;padding:5px;">关联题库</th>
                        <th style="width:150px;padding:5px;">创建日期</th>
                        <th style="width:150px;padding:5px;">修改日期</th>
                        <th style="width:150px;padding:5px;">操作区域</th>
                   </tr>
               </thead>
               <tbody>
                    <tr ng-repeat="package in packages">
                        <td style="width:100px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.packageId}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.packageName}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.jobNames}}</td>
                        <td style="width:200px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.bankNames}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.createDate}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.changeDate}}</td>
                        <td style="width:150px;padding:5px;">
                            <button id="editBtn" class="btn btn-small btn-primary" data-target="#myModal" ng-click="editPackage(package)">编辑</button>
                            <button id="deleteBtn" class="btn btn-small btn-danger" ng-click="deletePackage(package.packageId)">删除</button>
                        </td>

                   </tr>
               </tbody>
           </table>
    </div>
    <button id="createBtn" class="btn btn-small btn-success"
            data-target="#myModal" ng-click="createPackage()">新建套餐</button>
</div>
<div ui-view="detail"></div>