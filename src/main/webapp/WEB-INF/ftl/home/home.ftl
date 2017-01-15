<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" ui-sref="home">首页</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a ui-sref="home.questions">试题管理</a></li>
                <li><a ui-sref="home.banks">题库管理</a></li>
                <li><a ui-sref="home.packages">套餐管理</a></li>
                <li>
                    <a ui-sref="home.orders" data-toggle="dropdown">订单管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">查询所有订单</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a ui-sref="BanksMgt" class="dropdown-toggle" data-toggle="dropdown">
                        用户管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">后端开发</a></li>
                        <li><a href="#">前端开发</a></li>
                        <li><a href="#">移动开发</a></li>
                        <li class="divider"></li>
                        <li><a href="#">测试</a></li>
                        <li class="divider"></li>
                        <li><a href="#">运维</a></li>
                        <li class="divider"></li>
                        <li><a href="#">DBA</a></li>
                        <li class="divider"></li>
                        <li><a href="#">硬件开发</a></li>
                        <li class="divider"></li>
                        <li><a href="#">高端职位</a></li>
                    </ul>
                </li>
                <li><a ui-sref="logon">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div>
    <div class="well">
        <div ui-view="home-condition"></div>
    </div>
</div>