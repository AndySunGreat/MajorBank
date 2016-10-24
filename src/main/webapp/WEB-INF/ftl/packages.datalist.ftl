<div class="row" ng-init="load()">
    <div class="span7">
           <table class="table table-striped table-condensed">
               <thead>
                   <tr>
                        <th style="width:150px;padding:5px;">套餐ID</th>
                        <th style="width:150px;padding:5px;">套餐名称</th>
                        <th style="width:150px;padding:5px;">职业ID</th>
                        <th style="width:150px;padding:5px;">题库ID串</th>
                        <th style="width:150px;padding:5px;">创建日期</th>
                        <th style="width:150px;padding:5px;">修改日期</th>
                        <th style="width:150px;padding:5px;">操作区域</th>
                   </tr>
               </thead>
               <tbody>
                    <tr ng-repeat="package in packages"   >
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.packageId}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.packageName}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.jobId}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.bankIdsJson}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.createDate}}</td>
                        <td style="width:150px;padding:5px;" ng-click="retrieveDetail($event,package.packageId)">{{package.changeDate}}</td>
                        <td style="width:150px;padding:5px;">
                            <button id="editBtn" class="btn btn-small btn-primary" data-target="#myModal" ng-click="editPackage(package.packageId)">Edit</button>
                            <button id="deleteBtn" class="btn btn-small btn-danger" ng-click="deletePackage(package.packageId)">Delete</button>
                        </td>

                   </tr>
               </tbody>
           </table>
    </div>
    <button id="createBtn" class="btn btn-small btn-success"
            data-target="#myModal" ng-click="createPackage()">Create Package</button>
</div>
<div ui-view="detail"></div>