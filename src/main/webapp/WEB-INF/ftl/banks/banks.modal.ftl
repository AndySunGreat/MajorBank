<!-- Modal content,千万不要外部嵌套modal-dialog之类，因为框架已经封装-->
<div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"  ng-click="$dismiss()">&times;</button>
                    <h4 class="modal-title">题库管理 模态框</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form class="form-horizontal" role="form">
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
                                            ng-options="types.value for types in categories.types">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="bankName">题库名称:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="bankName"
                                           ng-model="bankDetail.bankName" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="qbVersion">题库版本:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="qbVersion"
                                           ng-model="bankDetail.qbVersion" />
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

