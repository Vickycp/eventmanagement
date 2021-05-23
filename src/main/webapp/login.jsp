<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="login.css">

</head>
<body>
  <div class="login">
    <div class="login-screen">
    <h3 style="color:red;">   <%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
     
    }
%></h3>
      <div class="app-title">
        <h1>Login</h1>
      </div>
      
  <form action="signin" method="post">
      <div class="login-form">
        <div class="control-group">
        <input type="text" class="login-field" value="" placeholder="username" id="login-name" name="username" required="required">
        <label class="login-field-icon fui-user" for="login-name"></label>
        </div>

        <div class="control-group">
        <input type="password" class="login-field" value="" placeholder="password" id="login-pass" name="password" required="required" min="6" >
        <label class="login-field-icon fui-lock" for="login-pass"></label>
        </div>
       <a class="login-link" href="forgetpassword.jsp">forget password?</a>
        <br>
        <button class="btn btn-primary btn-large btn-block" type="submit">login</button>
       <br><a class="login-link" href="reg.jsp">register</a>
      </div>
      </form>
    </div>
  </div>
 
</body>
</html>