
<div>
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
            <label class="control-label col-sm-2" for="pkgInputBankId">题库编号</label>
            <div class="col-sm-3">
                <input type="text" class="form-control"
                       id="pkgInputBankId"
                       placeholder="Enter Bank Id"
                         ng-model="searchFilter.bankId" ng-required="true"
                >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"  for="pkgInputBankName">题库名称</label>
            <div class="col-sm-3">
                <input type="text" class="form-control"
                       id="pkgInputBankName"
                       placeholder="Enter Bank Name"
                         ng-model="searchFilter.bankName"
                >
            </div>
        </div>

        <div class="form-group">
            <label  class="control-label col-sm-2" ></label>
            <div class="col-sm-1">
                <button type="button"
                    class="btn btn-small btn-success"
                    ng-click="queryForm(searchFilter)" >查询</button>
             </div>
            <div class="col-sm-1">
                <button type="button"
                    class="btn btn-small btn-primary"
                    ng-click="resetForm()">重置</button>
            </div>
        </div>
    </form>
</div>
<div ui-view="data-list"></div>
<div ui-view="data-detail"></div>