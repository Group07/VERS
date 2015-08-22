<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>AVERS</title>
  <script type='text/javascript' src="<c:url value='/JS/jquery-1.10.1.min.js'/>"></script>
  <script type='text/javascript' src="<c:url value='/jquery-ui/jquery-ui.min.js'/>"></script>
  <script type='text/javascript' src="<c:url value='/JS/common.js'/>"></script>
  <script type='text/javascript' src="<c:url value='/JS/student.js'/>"></script>
  <script type='text/javascript' src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
  <link href="<c:url value='/CSS/main.css'/>" type="text/css" rel="stylesheet">
  <link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
  <link href="<c:url value='/bootstrap/css/bootstrap-theme.min.css'/>" type="text/css" rel="stylesheet">
  <link href="<c:url value='/bootstrap/css/bootstrap-combined.min.css'/>" type="text/css" rel="stylesheet">
  <link href="<c:url value='/jquery-ui/jquery-ui.min.css'/>" type="text/css" rel="stylesheet">
</head>
<body>

<h3 class="alignCenter">Welcome to Student Home</h3>
<c:if test="${not empty message}">
  <h4  class="alignCenter">${message}</h4>
</c:if>

<div id="accordion">
<h3>View Results</h3>
<div>
  <form method="post" action="/recordsSystem/viewResult">
    <div>Subject &nbsp<select name="subjectID" id="studentSubject"></select> <c:if test="${not empty marks}"><span  class="alignRight marks">${marks}</span></c:if> </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="submit"><input type="submit" name="commit" value="View Result"></div>
  </form>
</div>
<h3>Get Result Sheet</h3>
  <div></div>
</div>
<%--imported code--%>

<c:url value="/j_spring_security_logout" var="logoutUrl"/>

<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}"
         value="${_csrf.token}"/>
</form>


<script>
  $("#accordion").accordion({
    heightStyle: "content"
  });
</script>

<script>
  function formSubmit() {
    document.getElementById("logoutForm").submit();
  }
  $("#searchAccordion").accordion({collapsible: true, active: false });

</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h5 style="float: right; margin-right: 10px">
    Welcome : ${pageContext.request.userPrincipal.name} | <a
          href="javascript:formSubmit()"> Logout</a>
  </h5>
</c:if>

</body>
</html>
