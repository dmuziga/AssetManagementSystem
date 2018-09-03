<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
              <form:form action="${pageContext.request.contextPath}/asset/assetProcessingForm"
                           modelAttribute="newAsset"
                           class="form-horizontal">

                  <!-- Place for messages: error, alert etc ... -->
                  <div class="form-group">
                      <div class="col-xs-15">
                          <div>

                              <!-- Check for registration error -->
                              <c:if test="${registrationError != null}">

                                  <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                          ${registrationError}
                                  </div>

                              </c:if>

                          </div>
                      </div>
                  </div>

                  <!-- firstName -->
                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.manufacture" placeholder="Manufacture" class="form-control" />
                  </div>


                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.serialNumber" placeholder="Serial Number" class="form-control" />
                  </div>

                  <div class="bfh-datepicker">
                      <form:input type="date" path="asset.acquiredDate"/>
                  </div>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.purchasePrice" placeholder="Purchase Price" class="form-control" />
                  </div>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.description" placeholder="Description" class="form-control" />
                  </div>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.comments" placeholder="comment" class="form-control" />
                  </div>


               <%--   <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.employee" placeholder="First Name" class="form-control" />
                  </div>--%>

                  <div style="margin-bottom: 25px" class="input-group">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                      <form:input path="asset.assetcategory" placeholder="First Name" class="form-control" />
                  </div>


                  <form:select path="asset.employee">
                      <form:option value="-" label="--Please Select"/>
                          <c:forEach var="theEmp" items="${employeeList}">
                                  <form:option value="${theEmp}" >
                                     <c:out value="${theEmp.firstName}"/>

                              </form:option>

                          </c:forEach>

                  </form:select>




              </form:form>




                    <%--<c:forEach var="employeeName" items="${employeesList}">


                            <td>${employeeName.firstName}</td>


                    </c:forEach>--%>



            </div>



        </div>

    </div>

</div>

</body>
</html>