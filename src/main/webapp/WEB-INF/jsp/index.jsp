<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  System.out.print("basePath:"+basePath);
%>
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
  <script src="<%=basePath %>common/angular/ui-bootstrap-tpls-2.2.0.min.js"></script>
  <script src="<%=basePath %>common/angular/angular-ui-router.js"></script>
  <script src="<%=basePath %>common/angular/angular-resource.min.js"></script>
  <script src="<%=basePath %>common/angular/angular-animate.js"></script>
  <script src="<%=basePath %>js/package/states/packages-state-add-controller.js"></script>
  <script src="<%=basePath %>js/package/states/packages-state-update-controller.js"></script>
  <script src="<%=basePath %>js/package/states/packages-state-detail-controller.js"></script>
  <script src="<%=basePath %>js/package/states/packages-state-controller.js"></script>
  <script src="<%=basePath %>js/package/states/packages-states.js"></script>
  <script src="<%=basePath %>js/package/packages-state-config.js"></script>
  <script src="<%=basePath %>js/package/packages-service.js"></script>
  <script src="<%=basePath %>js/package/packages.js"></script>
  <script src="<%=basePath %>js/home/home.js"></script>
  <script src="<%=basePath %>js/app.js"></script>

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
        <li class="dropdown">
          <a ui-sref="BanksMgt" class="dropdown-toggle" data-toggle="dropdown">
            题库管理
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