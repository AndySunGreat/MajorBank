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
                    <tr ng-repeat="package in packages">
                        <td style="width:150px;padding:5px;">{{package.packageId}}</td>
                        <td style="width:150px;padding:5px;">{{package.packageName}}</td>
                        <td style="width:150px;padding:5px;">{{package.jobId}}</td>
                        <td style="width:150px;padding:5px;">{{package.bankIdsJson}}</td>
                        <td style="width:150px;padding:5px;">{{package.createDate}}</td>
                        <td style="width:150px;padding:5px;">{{package.changeDate}}</td>
                        <td style="width:150px;padding:5px;">
                            <button id="editBtn" class="btn btn-small btn-primary" ng-click="editPackage(package.packageId)">Edit</button>
                            <button id="deleteBtn" class="btn btn-small btn-danger" ng-click="deletePackage(package.packageId)">Delete</button>
                        </td>

                   </tr>
               </tbody>
           </table>
    </div>
</div>