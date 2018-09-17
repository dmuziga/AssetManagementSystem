<%--
  Created by IntelliJ IDEA.
  User: NgenziDanny
  Date: 10/08/2018
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>

     <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/resources/css/dashboard.css" rel="stylesheet">


    <!-- Bootstrap datepicker JS and CSS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"></link>



</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Asset Management System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form:form action="${pageContext.request.contextPath}/logout" method="post" Class="login-btn">
                    <input type="submit" value="logout" class="add-button btn"/>
                </form:form>

                </li>
                <li><a class="nav-link" href="#"><security:authentication property="principal.username"/> </a>/li>
            </ul>

            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <%--<li><a href="${pageContext.request.contextPath}/assets/showAssetForm">Asset</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/asset/showAssetForm" >Asset</a></li>
                <li><a href="${pageContext.request.contextPath}/asset/showAssetForm"
                       data-target="#theModal" data-toggle="modal" >Lab 6</a></li>

                <li><a href="${pageContext.request.contextPath}/employee/registerEmployee">Employee</a></li>
            </ul>


        </div>
           <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Asset</h1>

            <div class="row placeholders">

            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Asset Manufacture</th>
                        <th>Asset Model </th>
                        <th>Asset AcquiredDate</th>
                        <th>Asset Category</th>
                        <th>Asset Owner</th>
                        <th>Update/Delete</th>
                    </tr>
                    </thead>

                   <c:forEach var="tempAsset" items="${assets}">

                       <%--construct an update Link with the Asset Id--%>

                       <c:url var="updateAsset" value="/asset/showAssetForUpdate">

                           <c:param name="assetId" value="${tempAsset.assetId}"/>
                       </c:url>

                       <c:url var="deleteAsset" value="/asset/deleteAsset">

                           <c:param name="assetId" value="${tempAsset.assetId}"/>
                       </c:url>

                        <tr>
                            <td>${tempAsset.manufacture}</td>
                            <td>${tempAsset.model}</td>
                            <td>${tempAsset.acquiredDate}</td>
                            <td>${tempAsset.assetcategory.categoryname}</td>
                            <td>${tempAsset.employee.firstName}</td>

                            <%--authorize who can view the Link to update or not--%>

                            <security:authorize access="hasRole('ADMIN')">
                                <td>
                                        <%--display the update Link for the Asset--%>
                                    <a href="${updateAsset}">Update/</a>
                                    <a href="${deleteAsset}"
                                       onclick="if(!(confirm('Are you sure you want to delete this Asset?'))) return false">Delete</a>
                                </td>


                            </security:authorize>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="theModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

        </div>
    </div>
</div>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="/resources/js/holder.min.js"></script>
</body>
</html>
