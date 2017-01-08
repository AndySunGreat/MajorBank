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
  <script src="common/angular/angular-cookies.min.js"></script>
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
  <script src="js/login/states/logon-state-controller.js"></script>
  <script src="js/login/states/logon-states.js"></script>
  <script src="js/login/logon-state-config.js"></script>
  <script src="js/login/logon-service.js"></script>
  <script src="js/login/logon.js"></script>
  <script src="js/home/home.js"></script>
  <script src="js/app.js"></script>

  <![endif]-->
</head>
<body ng-app="majorApp">
    <div class="container">
        <div ui-view></div>
    </div>
</body>
</html>