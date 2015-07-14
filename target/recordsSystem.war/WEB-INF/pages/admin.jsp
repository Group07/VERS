<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>
    <title>AVERS</title>
    <script type='text/javascript' src="<c:url value='/JS/jquery-1.10.1.min.js'/>"></script>
    <script type='text/javascript' src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
    <link href="<c:url value='/CSS/main.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/bootstrap/css/bootstrap-combined.min.css'/>" type="text/css" rel="stylesheet">
</head>
<body>
<h1>Title : ${title}</h1>
<h2>Message : ${message}</h2>

<%--imported code--%>
<div class="container">
    <div class="accordion" id="searchAccordion">
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#searchAccordion" href="#collapseOne">Add Lecturer</a>
            </div>
            <div id="collapseOne" class="accordion-body collapse in">
                <div class="accordion-inner">
                    <form method="post" action="index.html">
                        <p><input type="text" name="username" value="" placeholder="Username"></p>
                        <p><input type="text" name="fullName" value="" placeholder="Full Name"></p>
                        <p><input type="password" name="password" value="" placeholder="Password"></p>
                        <p class="submit"><input type="submit" name="commit" value="Login"></p>
                    </form>
                </div>
            </div>
        </div>
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                   data-parent="#searchAccordion" href="#collapseTwo">Other
                    Options</a>
            </div>
            <div id="collapseTwo" class="accordion-body collapse">
                <div class="accordion-inner">
                    <p> add other functions of Admin here</p>
                </div>
            </div>
        </div>
    </div>
</div>

<%--imported code--%>
<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} | <a
            href="javascript:formSubmit()"> Logout</a>
    </h2>
</c:if>

</body>
</html>