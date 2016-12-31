<!-- Modal content,千万不要外部嵌套modal-dialog之类，因为框架已经封装-->
<div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"  ng-click="$dismiss()">&times;</button>
                    <h4 class="modal-title">问题管理 模态框</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputIndustryType">行业类型:</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputIndustryType" class="form-control"
                                            ng-model="option"
                                            ng-options="option.value for option in industryTypeOptions">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputQbCategory">题库范畴:</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputQbCategory" class="form-control"
                                            ng-model="categories"
                                            ng-options="categories.value for categories in option.categories">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pkgInputQbType">题库类型:</label>
                                <div class="col-sm-3">
                                    <select id="pkgInputQbType" class="form-control"
                                            ng-model="types"
                                            ng-options="types.value for types in categories.types">
                                        <option value="">-- 请选择 --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group" ng-show="questionDetail.questionId">
                                    <label class="control-label col-sm-2" for="questionId">问题编号:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control"  id="packageId"
                                               ng-model="questionDetail.questionId" />
                                    </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="bankId">题库编号:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="bankId"
                                           ng-model="questionDetail.bankId" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="questContent">问题内容:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control"
                                       id="questContent" ng-model="questionDetail.questContent" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="questType">问题类型:</label>
                                <div class="col-sm-3">
                                    <select id="questType" class="form-control"
                                            ng-model="questionDetail.questType">
                                        <option value ="单选题">单选题</option>
                                        <option value ="多选题">多选题</option>
                                        <option value="判断题">判断题</option>
                                        <option value="实践题">实践题</option>
                                    </select>
                                </div>
                                <!--
                                  TODO: Should be a dropdown list
                                -->
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="questOptionsJson">问题选项:</label>
                                <div class="col-sm-3">
                                    <button ng-click="addAdditionalParams()"
                                            class="btn btn-default btn-success">Add</button>
                                </div>
                            </div>
                             <div ng-repeat="parameters in addiDynamicParamList">
                                 <div class="form-group">
                                     <label class="control-label col-sm-2" for="keyDynamicParams">(选项:{{parameters.optSeq}})</label>
                                     <div class="col-xs-1">
                                            <input type="input" id="keyDynamicParams" class="form-control"
                                                   ng-model="parameters.optSeq"/>
                                      </div>
                                     <div class="col-sm-5">
                                            <textarea  id="valueDynamicParams" class="form-control"
                                                       ng-model="parameters.optContent" rows="3" />
                                     </div>
                                            <button ng-show="$index!=-1" class="btn btn-default btn-primary"
                                                    ng-click="delAdditionalParams($index)">Del</button>
                                    </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="correctAnswer">正确答案:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control "
                                           id="correctAnswer" ng-model="questionDetail.correctAnswer" />
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

