<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>AVERS</title>
    <link href="<c:url value='/CSS/main.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css" rel="stylesheet">
</head>
<body>
<div class="buttonBox">

    <section>
        <input type="button" class="btn btn-lg btn-primary" name="commit1" value="Admin"
               onclick="window.location.href='/recordsSystem/admin'">
        <input type="button" class="btn btn-lg btn-primary" name="commit2" value="Lecturer"
               onclick="window.location.href='/recordsSystem/lecturer'">
        <input type="button" class="btn btn-lg btn-primary" name="commit3" value="Student"
               onclick="window.location.href='/recordsSystem/student'">
    </section>
</div>
</body>
</html>