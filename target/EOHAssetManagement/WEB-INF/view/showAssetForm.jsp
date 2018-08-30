<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">X</button>
    <h1>Asset Detail </h1>
</div>
<div class="modal-body">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            Asset Information
        </div>
       <%-- <div class="panel-body">
            <form>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Category</label>
                    <div class="col-sm-10">
                        <select class="form-control form-control-lg">
                            <option>Select Category</option>
                            <option value="1">Mouse</option>
                            <option value="2">Keyboard</option>
                            <option value="3">Screen</option>
                            <option value="3">Laptop</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label  class="col-sm-2 col-form-label">Manufacturer</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"  placeholder="Manufacturer">
                    </div>
                </div>

                <div class="form-group row">
                    <label  class="col-sm-2 col-form-label">Model</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"  placeholder="Model">
                    </div>
                </div>

                <div class="form-group row">
                    <label  class="col-sm-2 col-form-label">Serial Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"  placeholder="Serial Number">
                    </div>
                </div>

                <div class="form-group row">
                    <label  class="col-sm-2 col-form-label">Acquired Date</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Date" data-provide="datepicker" />
                    </div>
                </div>

                <div class="form-group row">
                    <label  class="col-sm-2 col-form-label">Purchase Price</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"  placeholder="Purchase Price">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-10">
                        <select class="form-control form-control-lg">
                            <option>Select Description</option>
                            <option value="1">New Asset</option>
                            <option value="2">Used Asset</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label  class="col-sm-2 col-form-label">Comments</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"  placeholder="Comments">
                    </div>
                </div>

                &lt;%&ndash;retrieve the list of employee from the DB and display it on this drop down&ndash;%&gt;

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Employee</label>
                    <div class="col-sm-10">
                        <select class="form-control form-control-lg">
                            <option>Select Employee</option>
                            <option value="1">Mouse</option>
                            <option value="2">Keyboard</option>
                            <option value="3">Screen</option>
                            <option value="3">Laptop</option>
                        </select>
                    </div>
                </div>



                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">SAVE</button>
                    </div>
                </div>
            </form>



        </div>
--%<%-->	<form:form action="${pageContext.request.contextPath}/employee/processRegistrationForm"
                   class="form-horizontal">--%>

        <form:form action="${pageContext.request.contextPath}/employee/processRegistrationForm">

            <c:forEach var="tempEmployee" items="${employeesList}">

                <form:select path="firstName" items="${tempEmployee.firstName}"/>
            </c:forEach>

        </form:form>

    </div>
    <div class="modal-footer">
        <div class="panel-footer">
            <div class="col-xs-10" id="lblstatus"></div>
        </div>
    </div>
</div>
