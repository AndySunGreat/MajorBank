<!-- Modal content,千万不要外部嵌套modal-dialog之类，因为框架已经封装-->
<div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">套餐管理 模态框</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">套餐编号:</label>
                                <label class="col-sm-2 col-form-label">{{packageDetail.packageId}} </label>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">套餐名称:</label>
                                <label class="col-sm-2 col-form-label">{{packageDetail.packageName}} </label>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">职业编号:</label>
                                <label class="col-sm-2 col-form-label">{{packageDetail.jobId}} </label>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">题库编号串:</label>
                                <label class="col-sm-2 col-form-label">{{packageDetail.bankIdsJson}} </label>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">创建日期:</label>
                                <label class="col-sm-2 col-form-label">{{packageDetail.createDate}} </label>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">修改日期:</label>
                                <label class="col-sm-2 col-form-label">{{packageDetail.changeDate}} </label>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">提交</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
 </div>

