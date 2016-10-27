<div>
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label class="control-label col-sm-2" for="pkgInputIndustryType">行业类型</label>
            <div class="col-sm-3">
                <select id="pkgInputIndustryType" class="form-control"
                        ng-model="searchFilter.industryType"
                        ng-options="option.itemValue for option in industryTypeOptions"
                        ng-change="changeForIndustryOption(searchFilter.industryType)">
                    <option value="">-- 请选择 --</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pkgInputQbCategory">题库范畴</label>
            <div class="col-sm-3">
                <select id="pkgInputQbCategory" class="form-control"
                        ng-model="searchFilter.qbCategory"
                        ng-options="option.itemValue for option in searchFilter.industryType.child"
                        ng-change="changeForQBCategoryOption(searchFilter.qbCategory)"
                >
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="pkgInputBankId">题库编号</label>
            <input type="text" class="form-control"
                   id="pkgInputBankId"
                   placeholder="Enter bank Id"
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
            <button type="button"
                    class="btn btn-default"
                    ng-click="queryForm(searchFilter)" >查询</button>
            <button type="button"
                    class="btn btn-default"
                    ng-click="resetForm()">重置</button>
        </div>
    </form>
</div>
<div ui-view="data-list"></div>
<div ui-view="data-detail"></div>