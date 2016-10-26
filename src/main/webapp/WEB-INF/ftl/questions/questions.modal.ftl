<!-- Modal content,千万不要外部嵌套modal-dialog之类，因为框架已经封装-->
<div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"  ng-click="$dismiss()">&times;</button>
                    <h4 class="modal-title">问题管理 模态框</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form>
                            <div class="form-group" ng-show="questionDetail.questionId">
                                    <label class="col-form-label" for="questionId">问题编号:</label>
                                    <input type="text" class="form-control" style="width:200px;" id="packageId" ng-model="questionDetail.questionId" />
                              </div>
                            <div class="form-group">
                                <label class="col-form-label" for="bankId">题库编号:</label>
                                <input type="text" class="form-control"  style="width:200px;" id="bankId" ng-model="questionDetail.bankId" />
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="questContent">问题内容:</label>
                                <input type="text" class="form-control " style="width:200px;"
                                       id="questContent" ng-model="questionDetail.questContent" />

                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="questType">问题类型:</label>
                                <select id="questType" class="form-control"
                                        ng-model="questionDetail.questType" style="width:200px;">
                                    <option value ="单选题">单选题</option>
                                    <option value ="多选题">多选题</option>
                                    <option value="判断题">判断题</option>
                                    <option value="实践题">实践题</option>
                                </select>
                                <!--
                                  TODO: Should be a dropdown list
                                -->
                            </div>
                          <!--  <div class="form-group">
                                <label class="col-form-label" for="questOptionsJson">问题选项:</label>
                                <button ng-click="addAdditionalParams()">Add</button>
                                <div ng-repeat="parameters in addiDynamicParamList">
                                    <input type="input" id="keyDynamicParams" ng-model="parameters.key" />
                                    <input type="input" id="valueDynamicParams" ng-model="parameters.value" />
                                    <button ng-show="$index!=-1" style="color:red;" ng-click="delAdditionalParams($index)">Del</button>
                                </div>
                            </div>-->
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" ng-click="submitModal()">提交</button>
                    <button type="button" class="btn btn-default" ng-click="$dismiss()">关闭</button>
                </div>
 </div>

