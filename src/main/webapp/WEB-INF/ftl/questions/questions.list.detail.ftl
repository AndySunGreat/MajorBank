
<div class="container">
        <form>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">问题编号:</label>
                <label class="col-sm-2 col-form-label">{{questionDetail.questionId}} </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">题库编号:</label>
                <label class="col-sm-2 col-form-label">{{questionDetail.bankId}} </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">问题内容:</label>
                <label class="col-sm-2 col-form-label">{{questionDetail.questContent}} </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">问题类型:</label>
                <label class="col-sm-2 col-form-label">{{questionDetail.questType}} </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">正确答案:</label>
                <label class="col-sm-2 col-form-label">{{questionDetail.correctAnswer}} </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">修改日期:</label>
                <label class="col-sm-2 col-form-label">{{questionDetail.changeDate}} </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">问题选项:</label>
                <div class="span7">
                    <table class="table table-striped table-condensed">
                        <thead>
                            <tr>
                                <th style="width:150px;padding:5px;">选项序号</th>
                                <th style="width:150px;padding:5px;">选项内容</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="option in questionDetail.questOptionsJson">
                                <td style="width:150px;padding:5px;" ">{{option.optSeq}}</td>
                                <td style="width:150px;padding:5px;" ">{{option.optContent}}</td>
                            </tr>
                    </table>
                 </div>
            </div>
        </form>
    </div>