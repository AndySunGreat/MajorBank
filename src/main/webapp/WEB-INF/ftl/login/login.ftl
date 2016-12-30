<div class="container">
    <div class="row myCenter">
        <div class="col-xs-6 col-md-4" style="float:none;display:block;margin-left:auto;margin-right:auto;padding:10px;">
            <h2>Major System</h2>
            <form role="form" name="loginForm" ng-submit="logonForm()"
                      novalidate>
                    <div class="form-group">
                        <label for="username">名称:</label>
                        <input type="text" id="username"
                               ng-model="credentials.username" placeholder="请输入名称">
                     </div>
                    <div class="form-group">
                        <label for="password">密码:</label>
                        <input type="password" id="password"
                               ng-model="credentials.password">
                    </div>
                    <div class="form-group">
                        <label  class="control-label col-sm-2" ></label>
                        <div class="col-sm-2">
                            <button type="submit"  class="btn btn-small btn-success">查询</button>
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-small btn-primary" ng-click="resetForm()">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>