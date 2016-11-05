<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>后台管理系统</title>

  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.js"></script>
  <script src="common/angular/ui-bootstrap-tpls-2.2.0.min.js"></script>
  <script src="common/angular/angular-ui-router.js"></script>
  <script src="common/angular/angular-resource.min.js"></script>
  <script src="common/angular/angular-animate.js"></script>
  <script src="js/packages/states/packages-state-add-controller.js"></script>
  <script src="js/packages/states/packages-state-update-controller.js"></script>
  <script src="js/packages/states/packages-state-detail-controller.js"></script>
  <script src="js/packages/states/packages-state-controller.js"></script>
  <script src="js/packages/states/packages-states.js"></script>
  <script src="js/packages/packages-state-config.js"></script>
  <script src="js/packages/packages-service.js"></script>
  <script src="js/packages/packages.js"></script>
  <script src="js/questions/states/questions-state-add-controller.js"></script>
  <script src="js/questions/states/questions-state-update-controller.js"></script>
  <script src="js/questions/states/questions-state-detail-controller.js"></script>
  <script src="js/questions/states/questions-state-controller.js"></script>
  <script src="js/questions/states/questions-states.js"></script>
  <script src="js/questions/questions-state-config.js"></script>
  <script src="js/questions/questions-service.js"></script>
  <script src="js/questions/questions.js"></script>
  <script src="js/banks/states/banks-state-add-controller.js"></script>
  <script src="js/banks/states/banks-state-update-controller.js"></script>
  <script src="js/banks/states/banks-state-detail-controller.js"></script>
  <script src="js/banks/states/banks-state-controller.js"></script>
  <script src="js/banks/states/banks-states.js"></script>
  <script src="js/banks/banks-state-config.js"></script>
  <script src="js/banks/banks-service.js"></script>
  <script src="js/banks/banks.js"></script>
  <script src="js/home/home.js"></script>
  <script src="js/app.js"></script>

  <![endif]-->
</head>
<body ng-app="myApp">
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" ui-sref="home">[BMS]</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a ui-sref="packages">套餐管理</a></li>
        <li><a ui-sref="banks">题库管理</a></li>
        <li><a ui-sref="questions">试题管理</a></li>
        <li class="dropdown">
          <a ui-sref="BanksMgt" class="dropdown-toggle" data-toggle="dropdown">
            菜单管理
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
        <li><a href="#">订单管理</a>
          <ul class="dropdown-menu">
            <li><a href="#">查询所有订单</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div>
  <div class="container">
    <div ui-view></div>
  </div>
</div>
</body>
</html>