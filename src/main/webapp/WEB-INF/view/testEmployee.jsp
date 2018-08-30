<%--
  Created by IntelliJ IDEA.
  User: NgenziDanny
  Date: 30/08/2018
  Time: 06:44
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/employee/processRegistrationForm">

    <c:forEach var="tempEmployee" items="${employeesList}">

        <form:select path="firstName" items="${tempEmployee.firstName}"/>
    </c:forEach>

</form:form>

</body>
</html>
