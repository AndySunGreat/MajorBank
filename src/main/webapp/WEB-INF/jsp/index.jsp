<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <![endif]-->
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">[后台管理系统]</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">套餐管理</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            IT题库管理
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

<h1>Hello : ${name}</h1>
<h1>这里是SpringMVC Demo首页</h1>

<h3>出现此页面，说明配置成功。</h3>
</body>
</html>