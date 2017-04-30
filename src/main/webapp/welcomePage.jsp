<%--
  Created by IntelliJ IDEA.
  User: ivans
  Date: 22/04/2017
  Time: 16:50
  To change this template use File | Settings | File Templates.

  <link rel="stylesheet" href="<c:url value="/assets/css/w3.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/css/ralewayFonts.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/css/font-awesome.min.css"/>">
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome App2Act!</title>
    <link rel="stylesheet" href="assets/css/wStyle.css" >
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/welc.js"></script>
</head>
<body>
<div class="form">
    <ul class="tab-group">
        <li class="tab active"><a href="#login">Log In</a></li>
        <li class="tab"><a href="#signup">Sign Up</a></li>
    </ul>
    <div class="tab-content">
        <div id="login">
            <h1>Welcome Back!</h1>
            <form action="/app2act/" method="post">
                <input type="hidden" name="form" value="login"/>
                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input type="email" required autocomplete="off" name="email"/>
                </div>
                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input type="password" required autocomplete="off" name="password"/>
                </div>
                <p class="forgot"><a href="#">Forgot Password?</a></p>
                <button type="submit" class="button button-block" />Log In</button>
            </form>
        </div>
        <div id="signup">
            <h1>Sign Up for Free</h1>
            <form action="/app2act/" method="post">
                <input type="hidden" name="form" value="signup"/>
                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            First Name<span class="req">*</span>
                        </label>
                        <input type="text" required autocomplete="off" name="firstname" />
                    </div>
                    <div class="field-wrap">
                        <label>
                            Last Name<span class="req">*</span>
                        </label>
                        <input type="text" required autocomplete="off" name="lastname"/>
                    </div>
                </div>
                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input type="email" required autocomplete="off" name="email"/>
                </div>
                <div class="field-wrap">
                    <label>
                        Set A Password<span class="req">*</span>
                    </label>
                    <input type="password" required autocomplete="off" name="password"/>
                </div>
                <button type="submit" class="button button-block" />Get Started</button>
            </form>
        </div>
    </div>
    <!-- tab-content -->
</div>
<!-- /form -->
</body>
</html>





<%--<html>
<head>

</head>
<body>
<form action="/app2act/" method="post">
    <input type="text" name="email"/>
    <input type="text" name="password"/>
    <input type="submit" value="login"/>
</form>
</body>
</html>--%>

