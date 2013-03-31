<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>

    <meta charset="utf-8">
    <title>Sign in &middot; Twitter Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
    <link href="/css/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <script src="/js/jquery-1.9.0.js" type="text/javascript"></script>
    <script src="/js/jquery-migrate-1.1.0.js" type="text/javascript"></script>
</head>
<body>
     <div class="container">
         <form class="form-signin" action="/login/dologin.shtml">
             <h2 class="form-signin-heading">请登录 -test</h2>
             <input name="account" type="text" class="input-block-level" placeholder="Email address">
             <input name="password" type="password" class="input-block-level" placeholder="Password">
             <label class="checkbox">
                 <input type="checkbox" value="remember-me"> 记住我
             </label>
             <button class="btn btn-large btn-primary" type="submit">登录</button>
         </form>
     </div>
</body>
</html>
