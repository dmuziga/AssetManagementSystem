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

<div role="main">
    <section id="new-asset">
        <div class="container">
            <h1 class="page-header text-center">Add Asset</h1>
            <div class="row">
                <div class="alert alert-info">
                    To add an Asset in the system ,please provide as much information as possible in the fields below. When you click the Add button.
                </div>
            </div>
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <form:form role="form" class="simple_form asset-form bv-form" id="new_asset"
                          action="${pageContext.request.contextPath}/asset/processingAssetForm" modelAttribute="newAsset"
                               accept-charset="UTF-8" method="post" novalidate="novalidate">
                        <form:hidden path="assetId" />


                        <c:if test="${assetRegistrationError != null}">
                                <div class="row">
                                    <div class="alert alert-danger">
                                                    ${assetRegistrationError}
                                    </div>
                                </div>
                        </c:if>

                        <button type="submit" class="bv-hidden-submit" style="display: none; width: 0px; height: 0px;"></button>
                        <input name="utf8" type="hidden" value="✓">
                        <input type="hidden" name="authenticity_token" value="HTLLhZhKsvh+fd4XyC4ush3bMVfQba9iOsnQon2IMGBIercNmP4l6dRBZ3bsmvU6/9wjjxfBq4XZbvK+aQRE1Q==">

                        <div class="form-group string required asset_name has-feedback">
                            <form:input path="manufacture" class="string required form-control" required="required" aria-required="true" placeholder="Manufacture" type="text" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>
                        <div class="form-group string required asset_name has-feedback">
                            <form:input path="model" class="string required form-control" required="required" aria-required="true" placeholder="Model" type="text" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>
                        <div class="form-group string required asset_name has-feedback">
                            <form:input path="serialNumber" class="string required form-control" required="required" aria-required="true" placeholder="Serial Number" type="text" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>
                        <div class="form-group string required asset_name has-feedback">
                            <form:input path="acquiredDate" class="string required form-control" required="required" aria-required="true" placeholder="acquiredDate" type="date" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>
                        <div class="form-group string required asset_name has-feedback">
                            <form:input path="purchasePrice" class="string required form-control" required="required" aria-required="true" placeholder="Purchase Date" type="text" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>
                        <div class="form-group string required asset_name has-feedback">
                            <form:textarea path="description" rows="5" class="string required form-control" required="required" aria-required="true" placeholder="Device Description" type="textarea" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>
                        <div class="form-group string required asset_name has-feedback">
                            <form:input path="comments" class="string required form-control" required="required" aria-required="true" placeholder="Comment" type="text" data-bv-field="asset[name]"/><i class="form-control-feedback bv-no-label" data-bv-icon-for="asset[name]" style="display: none;"></i><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[name]" data-bv-result="NOT_VALIDATED" style="display: none;">The asset name is required</small>
                        </div>



                        <div class="form-group select required asset_purpose">
                            <form:select path="assetcategory.assetcategoryid" data-bv-feedbackicons="false" class="select required form-control" required="required" aria-required="true" name="asset[purpose]" id="asset_purpose" data-bv-field="asset[purpose]">
                                <form:option value="-1" >Select The Asset Type</form:option>
                                <form:options items="${assetCategoryList}" itemValue="assetcategoryid" itemLabel="categoryname" />
                           </form:select><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[purpose]" data-bv-result="NOT_VALIDATED" style="display: none;">You must choose an asset type</small>
                        </div>



                        <div class="form-group select required asset_purpose">
                            <form:select path="employee.id" data-bv-feedbackicons="false" class="select required form-control" required="required" aria-required="true" name="asset[purpose]" id="asset_purpose" data-bv-field="asset[purpose]">
                                <form:option value="-1" required="required">Select Asset Owner</form:option>--%>
                                <form:options items="${employeeList}" itemValue="id" itemLabel="firstName" />
                            </form:select><small class="help-block" data-bv-validator="notEmpty" data-bv-for="asset[purpose]" data-bv-result="NOT_VALIDATED" style="display: none;">You must choose an asset type</small>
                        </div>

                        <div class="pull-right">
                            <a data-confirm="Are you sure?" class="btn btn-link" href="${pageContext.request.contextPath}/homePage" >Cancel</a>
                            <input type="submit" name="commit" value="Add Asset" class="btn btn-default btn-primary" onclick="if(!(confirm('Are you sure you want to add this Asset?')))return false">
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    </section>
</div>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="/resources/js/holder.min.js"></script>
</body>
</html>
