<!-- Modal content,千万不要外部嵌套modal-dialog之类，因为框架已经封装-->
<div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"  ng-click="$dismiss()">&times;</button>
                    <h4 class="modal-title">套餐管理 模态框</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form  class="form-horizontal" role="form">
                            <div class="form-group" ng-show="packageDetail.packageId">
                                <label class="control-label col-sm-2" for="packageId">套餐编号:</label>
                                <div class="col-sm-3" >
                                        <input type="text" class="form-control"  id="packageId" ng-model="packageDetail.packageId" />
                                  </div>
                             </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="packageName">套餐名称:</label>
                                <div class="col-sm-3" >
                                    <input type="text" class="form-control" id="packageName" ng-model="packageDetail.packageName" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="packageDesc">套餐描述</label>
                                <div class="col-sm-3">
                                     <textarea  id="packageDesc" class="form-control"
                                                ng-model="packageDetail.packageDesc" rows="3" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputIndustryType">行业类型</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputIndustryType" class="form-control"
                                            ng-model="option"
                                            ng-options="option.value for option in industryTypeOptions">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputQbCategory">题库范畴</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputQbCategory" class="form-control"
                                            ng-model="categories"
                                            ng-options="categories.value for categories in option.categories">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputQbType">题库类型</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputQbType" class="form-control"
                                            ng-model="types"
                                            ng-change="changeBankTypeList()"
                                            ng-options="types.value for types in categories.types">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputBank">题库选择</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputBank" class="form-control"
                                            ng-model="banks"
                                            ng-options="banks.bankName for banks in types.banks track by banks.bankId">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                                <div class="col-xs-1">
                                    <button ng-click="addBank()"
                                            class="btn btn-default btn-success">Add</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputQbType">(已选列表)</label>
                                <div class="col-sm-5">
                                <table class="table table-hover" ng-show="bankOptions">
                                    <thead>
                                    <tr>
                                        <th width="30%">题库编号</th>
                                        <th>题库名称</th>
                                        <th>类型</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr ng-repeat="bankOption in bankOptions">
                                            <td>{{bankOption.bankId}}</td>
                                            <td>{{bankOption.bankName}}</td>
                                            <td>{{bankOption.qbType}}</td>
                                            <td> <button ng-show="$index!=-1" class="btn btn-default btn-primary"
                                                         ng-click="delBankOptions($index)">Del</button></td>
                                        </tr>
                                    </tbody>
                                </table>
                                    </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgJobsIndustryType">职业所属行业</label>
                                <div class="col-sm-3">
                                    <select id="pkgJobsIndustryType" class="form-control"
                                            ng-model="jobOption"
                                            ng-options="jobOption.industryTypeValue for jobOption in jobsOptions">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputJobGroup">职业所属组</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputJobGroup" class="form-control"
                                            ng-model="jobGroupOptionsList"
                                            ng-options="jobGroupOptionsList.jobGroup for jobGroupOptionsList in jobOption.jobGroupOptionsList">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputJob">职业关联</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputJob" class="form-control"
                                            ng-model="jobsList"
                                            ng-options="jobsList.jobName for jobsList in jobGroupOptionsList.jobsList">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                                <div class="col-xs-1">
                                    <button ng-click="addJobOptions()"
                                            class="btn btn-default btn-success">Add</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputJobOptions">(已选列表)</label>
                                <div class="col-sm-5">
                                    <table class="table table-hover" ng-show="jobDropdownOptions">
                                        <thead>
                                        <tr>
                                            <th>所属行业</th>
                                            <th>所属组</th>
                                            <th>职业名称</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr ng-repeat="jobArrOption in jobDropdownOptions">
                                            <td>{{jobArrOption.industryType}}</td>
                                            <td>{{jobArrOption.jobGroup}}</td>
                                            <td>{{jobArrOption.jobName}}</td>
                                            <td> <button ng-show="$index!=-1" class="btn btn-default btn-primary"
                                                         ng-click="delJobOptions($index)">Del</button></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" ng-click="submitModal()">提交</button>
                    <button type="button" class="btn btn-default" ng-click="$dismiss()">关闭</button>
                </div>
 </div>

