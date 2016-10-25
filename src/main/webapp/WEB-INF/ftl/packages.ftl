<div>
    <form>
        <div class="form-group">
            <label for="pkgInputPackageId">套餐编号</label>
            <input type="text" class="form-control"
                   id="pkgInputPackageId"
                   placeholder="Enter package ID"
                    style="width:200px;"  ng-model="searchFilter.packageId"
            >
        </div>
        <div class="form-group">
            <label for="pkgInputPackageName">套餐名称</label>
            <input type="text" class="form-control"
                   id="pkgInputPackageName"
                   placeholder="Enter package Name"
                   style="width:200px;"  ng-model="searchFilter.packageName"
            >
        </div>
        <div class="form-group">
            <label for="pkgInputJobId">职业编号</label>
            <input type="text" class="form-control"
                   id="pkgInputJobId"
                   placeholder="Enter Job Id"
                   style="width:200px;" ng-model="searchFilter.jobId"
            >
        </div>
        <div class="form-group">
            <label for="pkgInputBankIds">题库编号</label>
            <input type="text" class="form-control"
                   id="pkgInputBankIds"
                   placeholder="Enter Bank Ids"
                   style="width:200px;" ng-model="searchFilter.bankIdsJson"
            >
        </div>
        <div class="form-group">
            <button type="button" class="btn btn-default" ng-click="queryForm(searchFilter)" >查询</button>
            <button type="button" class="btn btn-default" ng-click="resetForm()">重置</button>
        </div>
    </form>
</div>
<div ui-view="data-list"></div>
<div ui-view="data-detail"></div>