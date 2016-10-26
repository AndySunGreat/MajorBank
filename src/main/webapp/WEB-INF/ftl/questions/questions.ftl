<div>
    <form>
        <div class="form-group">
            <label for="pkgInputBankId">题库编号</label>
            <input type="text" class="form-control"
                   id="pkgInputBankId"
                   placeholder="Enter package Name"
                   style="width:200px;"  ng-model="searchFilter.bankId" ng-required="true"
            >
        </div>
        <div class="form-group">
            <label for="pkgInputQuestionId">问题编号</label>
            <input type="text" class="form-control"
                   id="pkgInputQuestionId"
                   placeholder="Enter question ID"
                    style="width:200px;"  ng-model="searchFilter.questionId"
            >
        </div>

        <div class="form-group">
            <label for="pkgInputQuestContent">问题内容</label>
            <input type="text" class="form-control"
                   id="pkgInputQuestContent"
                   placeholder="Enter question content"
                   style="width:200px;" ng-model="searchFilter.questContent"
            >
        </div>
        <div class="form-group">
            <label for="pkgInputQuesType">问题类型</label>
            <select id="pkgInputQuesType" class="form-control"
                    ng-model="searchFilter.questType" style="width:200px;">
                <option value ="单选题">单选题</option>
                <option value ="多选题">多选题</option>
                <option value="判断题">判断题</option>
                <option value="实践题">实践题</option>
            </select>
        </div>
        <div class="form-group">
            <button type="button" class="btn btn-default" ng-click="queryForm(searchFilter)" >查询</button>
            <button type="button" class="btn btn-default" ng-click="resetForm()">重置</button>
        </div>
    </form>
</div>
<div ui-view="data-list"></div>
<div ui-view="data-detail"></div>