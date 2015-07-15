<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title>AVERS Login Page</title>
    <script type='text/javascript' src="<c:url value='/JS/jquery-1.10.1.min.js'/>"></script>
    <script type='text/javascript' src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
    <link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap-combined.min.css'/>" type="text/css" rel="stylesheet">
    <style>
        body {
            background: url("Images/add.jpg")no-repeat scroll 0 0 / 100% 100% transparent !important;
            height: 100%;
            margin: 0;
            padding: 0;
        }

        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 400px;
            height : 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

<div id="login-box">

    <h3>Login with Username and Password</h3>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form name='loginForm'
          action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />"
          method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input autofocus="" required="true" class="form-control" type='text' name='username'></td>

            </tr>
            <tr>
                <td>Password:</td>
                <td><input autofocus="" required="true" class="form-control" type='password' name='password' /></td>
            </tr>
            <tr>
                <br>
                <td colspan='2'><input class="btn btn-lg btn-primary" name="submit" type="submit" value="submit" /></td>
            </tr>

        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

    </form>

    <a href="/recordsSystem"><h4 style="float: right; color: #003bb3"> < Back</h4></a>

</div>

</body>
</html>