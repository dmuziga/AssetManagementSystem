<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!doctype html>
<html lang="en">

<head>

    <title>Register New Asset </title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<div>

    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-primary">

            <div class="panel-heading">
                <div class="panel-title">Add New Asset</div>
            </div>

            <div style="padding-top: 30px" class="panel-body">

                <!-- Registration Form -->
              <form:form action="${pageContext.request.contextPath}/asset/processingAssetForm"
                           modelAttribute="newAsset"
                           class="form-horizontal">

                  <!-- Place for messages: error, alert etc ... -->
                  <div class="form-group">
                      <div class="col-xs-15">
                          <div>

                              <!-- Check for registration error -->
                              <c:if test="${assetRegistrationError != null}">

                                  <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                          ${assetRegistrationError}
                                  </div>

                              </c:if>

                          </div>
                      </div>
                  </div>

                  <!-- firstName -->
                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="manufacture" placeholder="Manufacture" class="form-control" />
                  </div>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="model" placeholder="Model" class="form-control" />
                  </div>


                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="serialNumber" placeholder="Serial Number" class="form-control" />
                  </div>

                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>

                     <form:input type="date" path="acquiredDate"/>
                </div>
                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="purchasePrice" placeholder="Purchase Price" class="form-control" />
                  </div>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="description" placeholder="Description" class="form-control" />
                  </div>

                  <div style="margin-bottom: 25px" class="form-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>


                      <form:input path="comments" placeholder="comment" class="form-control" />
                  </div>


               <%--   <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.employee" placeholder="First Name" class="form-control" />
                  </div>--%>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"></span>

                  <%--    <form:select path="assetcategory">
                          <form:option value="-" label="--Please Select Asset Category"/>
                          <c:forEach var="theAsset" items="${assetCategories}">
                              <form:option value="${theAsset}" >
                                  <c:out value="${theAsset.categoryname}"/>
                              </form:option>

                          </c:forEach>

                      </form:select>--%>

                      <form:select path="assetcategory.assetcategoryid" >
                          <form:option value="-1">Select...</form:option>
                          <form:options items="${assetCategoryList}" itemValue="assetcategoryid" itemLabel="categoryname" />
                      </form:select>



                  </div>

                <%--<div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"></span>

                    <form:select path="employee">
                      <form:option value="-" label="--Please Select Employee"/>
                          <c:forEach var="theEmp" items="${employeeList}">
                                  <form:option value="${theEmp}" >
                                     <c:out value="${theEmp.firstName}"/>

                              </form:option>

                          </c:forEach>

                  </form:select>
                </div>
--%>

<%--                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"></span>

                    <spring:bind path="employee">
                      <select name="${status.expression}">
                          <option value="-" label="--Please Select Employee"></option>

                          <c:forEach items="${employeeList}" var="theEmp">
                              <option value="${theEmp.id}"
                                      <c:if test="${status.value ==theEmp.id}">selected="selected"</c:if>
                              >${theEmp.firstName}</option>

                          </c:forEach>
                          <span class="fieldError">${status.errorMessage}</span>

                      </select>


                  </spring:bind>
                </div>--%>

               <%--   <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"></span>



                      <form:select path="employee">
                          <form:option value="-" label="--Please Select Employee"/>
                          <c:forEach var="theEmp" items="${employeeList}">
                              <form:option value="${theEmp}" >
                                  <c:out value="${theEmp.firstName}"/>

                              </form:option>

                          </c:forEach>

                      </form:select>
                  </div>--%>

                <%--  <form:select class="form-control" path="employee">
                      <form:option value="-1">Select...</form:option>
                      <form:options items="${employeeList}" itemValue="id" itemLabel="firstName"/>
                  </form:select>
--%>

               <%--   <form:select path="employee" >
                      <c:forEach items="${employeeList}" var="employee">
                          <form:option value="${employee}">${employee.firstName}</form:option>
                      </c:forEach>
                  </form:select>


--%>
                  <form:select path="employee.id" >
                      <form:option value="-1">Select...</form:option>
                      <form:options items="${employeeList}" itemValue="id" itemLabel="firstName" />
                  </form:select>




                  <!-- Register Button -->
                  <div style="margin-top: 10px" class="form-group">
                      <div class="col-sm-6 controls">
                          <button type="submit" class="btn btn-primary">Save Asset</button>
                      </div>
                  </div>

              </form:form>

            </div>



        </div>

    </div>

</div>

</body>
</html>