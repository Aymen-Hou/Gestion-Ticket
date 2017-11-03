<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootbox.min.js" />"></script>
<title>E-Commerce</title>
</head>
<body>

<div class="container">
<div class="page-header">
        <h1>Bienvenu </h1>
</div>

<form action="j_spring_security_check" method="post" class="form-horizontal" >

<div class="form-group">
	<label for="login" class="col-sm-2 control-label" >Login:</label>
		<div class="col-sm-10">
 			<input type="text" name="j_username" class="form-control" 
 					id="login"  placeholder="Login"/>
 		</div>
</div>

<div class="form-group">
	<label for="password" class="col-sm-2 control-label">Mot de Passe:</label>
		<div class="col-sm-10">
 			<input type="password" name="j_password" class="form-control" 
 					id="password" placeholder="Mot de passe"/>
 		</div>
</div>

<div class="form-group">
<div class="col-sm-offset-2 col-sm-12">
<button type="submit"  class="btn btn-primary col-lg-10"  >
<span class="glyphicon glyphicon-ok-sign"></span> Se Connecter</button>
</div>
</div>
</form>
</div>
</body>
</html>