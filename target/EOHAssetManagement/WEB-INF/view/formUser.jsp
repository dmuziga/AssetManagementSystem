<%--
  Created by IntelliJ IDEA.
  User: NgenziDanny
  Date: 21/08/2018
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet"
          href="style.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container jf-form">
    <form data-licenseKey="" name="jqueryform-628998" id="jqueryform-628998"
          action='${pageContext.request.contextPath}/employee/processRegistrationForm' method='post' enctype='multipart/form-data' novalidate autocomplete="on">
        <input type="hidden" name="method" value="validateForm">
        <input type="hidden" id="serverValidationFields" name="serverValidationFields" value="">



        <div class="form-group f1 required" data-fid="f1">
            <label class="control-label" for="f1" required>First Name </label>


            <input type="text" class="form-control" id="f1" name="f1" value=""   placeholder="First Name "
                   data-rule-required="true"  />



        </div>




        <div class="form-group f2 required" data-fid="f2">
            <label class="control-label" for="f2">Last Name</label>


            <input type="text" class="form-control" id="f2" name="f2" value=""   placeholder="Last Name "
                   data-rule-required="true"  />



        </div>




        <div class="form-group f7 required" data-fid="f7">
            <label class="control-label" for="f7">Phone</label>

            <div class="input-group"><span class="input-group-addon left"><i class="glyphicon glyphicon-earphone"></i> </span>
                <input type="tel" class="form-control" id="f7" name="f7" value=""   placeholder="xxx-xxx-xxxx"
                       data-rule-pattern="[0-9]{3,4}[ -.]*[0-9]{3,4}[ -.]*[0-9]{4}" data-msg-pattern="Invalid phone number"
                       data-rule-required="true"   /></div>


        </div>




        <div class="form-group f8 required" data-fid="f8">
            <label class="control-label" for="f8">Email</label>

            <div class="input-group"><span class="input-group-addon left"><i class="glyphicon glyphicon-envelope"></i> </span>
                <input type="email" class="form-control" id="f8" name="f8" value=""
                       data-rule-email="true"
                       data-rule-required="true"  />
            </div>

        </div>




        <div class="form-group f5 required" data-fid="f5">
            <label class="control-label" for="f5">User Name </label>


            <input type="text" class="form-control" id="f5" name="f5" value=""   placeholder="Last Name "
                   data-rule-required="true"  />



        </div>




        <div class="form-group f6 required" data-fid="f6">
            <label class="control-label" for="f6">Password </label>


            <input type="text" class="form-control" id="f6" name="f6" value=""   placeholder="Last Name "
                   data-rule-required="true"  />



        </div>



        <div class="form-group submit f0 " data-fid="f0" style="position: relative;">
            <label class="control-label sr-only" for="f0" style="display: block;">Submit Button</label>

            <div class="progress" style="display: none; z-index: -1; position: absolute;">
                <div class="progress-bar progress-bar-striped active" role="progressbar" style="width:100%">
                </div>
            </div>

            <button type="submit" class="btn btn-primary btn-lg" style="z-index: 1;">
                Register Now
            </button>

        </div><div class="clearfix"></div>

        <div class="submit">
            <p class="error bg-warning" style="display:none;">
                Please check the required fields.  </p>
        </div>

        <div class="clearfix"></div>


    </form>


</div>

</body>
</html>
