<div>
    <form  class="form-horizontal" role="form">
        <div class="form-group">
            <label class="control-label col-sm-2" for="pkgInputBankId">题库名称</label>
            <div class="col-sm-3">
                <input type="text" class="form-control"
                       id="pkgInputBankId"
                       placeholder="请输入题库名称"
                       ng-model="searchFilter.bankId"
                       ng-required="true"
                >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pkgInputQuestionId">问题编号</label>
            <div class="col-sm-3">
                <input type="text" class="form-control"
                       id="pkgInputQuestionId"
                       placeholder="请输入问题编号"
                       ng-model="searchFilter.questionId"
                >
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="pkgInputQuestContent">问题内容</label>
            <div class="col-sm-3">
                <input type="text" class="form-control"
                       id="pkgInputQuestContent"
                       placeholder="请输入问题内容"
                       ng-model="searchFilter.questContent"
                >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pkgInputQuesType">问题类型</label>
            <div class="col-sm-3">
                <select id="pkgInputQuesType" class="form-control"
                        ng-model="searchFilter.questType">
                    <option value="">-- 请选择 --</option>
                    <option value ="单选题">单选题</option>
                    <option value ="多选题">多选题</option>
                    <option value="判断题">判断题</option>
                    <option value="实践题">实践题</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" ></label>
            <div class="col-sm-1">
                <button type="button" class="btn btn-small btn-success" ng-click="queryForm(searchFilter)" >查询</button>
            </div>
            <div class="col-sm-1">
                <button type="button" class="btn btn-small btn-primary" ng-click="resetForm()">重置</button>
            </div>
        </div>
    </form>
</div>
<div ui-view="data-list"></div>
<div ui-view="data-detail"></div>