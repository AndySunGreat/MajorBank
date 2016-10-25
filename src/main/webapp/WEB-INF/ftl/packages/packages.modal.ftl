<!-- Modal content,千万不要外部嵌套modal-dialog之类，因为框架已经封装-->
<div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"  ng-click="$dismiss()">&times;</button>
                    <h4 class="modal-title">套餐管理 模态框</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form>
                            <div class="form-group" ng-show="packageDetail.packageId">
                                    <label class="col-form-label" for="packageId">套餐编号:</label>
                                    <input type="text" class="form-control" style="width:200px;" id="packageId" ng-model="packageDetail.packageId" />
                              </div>
                            <div class="form-group">
                                <label class="col-form-label" for="packageName">套餐名称:</label>
                                <input type="text" class="form-control"  style="width:200px;" id="packageName" ng-model="packageDetail.packageName" />
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="jobId">职业编号:</label>
                                <input type="text" class="form-control " style="width:200px;"  id="jobId" ng-model="packageDetail.jobId" />
                                <!--
                                TODO: Should be a dropdown list
                                -->
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="bankIdsJson">题库编号串:</label>
                                <input type="text" class="form-control" style="width:200px;"  id="bankIdsJson" ng-model="packageDetail.bankIdsJson" />
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" ng-click="submitModal()">提交</button>
                    <button type="button" class="btn btn-default" ng-click="$dismiss()">关闭</button>
                </div>
 </div>

