<div>
    <form>
        <div class="form-group">
            <label for="pkgInputPackageId">套餐编号</label>
            <input type="text" class="form-control"
                   id="pkgInputPackageId"
                   aria-describedby="packageIdHelp"
                   placeholder="Enter package ID">
            <small id="packageIdHelp"
                   class="form-text text-muted">
                We'll never share your id with anyone else.</small>
        </div>
    </form>
</div>
<div ui-view="data-list"></div>
<div ui-view="data-detail"></div>