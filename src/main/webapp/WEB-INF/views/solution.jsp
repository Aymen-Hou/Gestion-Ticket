<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

 <link href="<c:url value="/resources/css/jquerryFilter.css" />" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <link href="<c:url value="/resources/mdb/css/mdb.css"/>" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="<c:url value="/resources/mdb/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/mdb/css/mdb.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/mdb/css/bootstrap.min.css"/>" rel="stylesheet">
 
    
    
<!-- jQuery library -->
<!--  
<script src="<c:url value="/resources/mdb/js/tether.min.js"/>"></script>
<script src="<c:url value="/resources/mdb/js/jquery-3.1.1.js"/>"></script>
<script src="<c:url value="/resources/mdb/js/bootstrap.min.js"/>"></script>
-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jquery-1.12.4.js" />"></script>
<script src="<c:url value="/resources/js/pagination.js" />"></script>
<script src="<c:url value="/resources/js/filtrage.js" />"></script>
<script src="<c:url value="/resources/js/bootbox.min.js" />"></script>
<script src="<c:url value="/resources/js/dialogComfirm.js" />"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="container">
<body class="hidden-sn mdb-skin">

    <!--Double navigation-->
    <header>
        <!-- Sidebar navigation -->

        <!--/. Sidebar navigation -->
        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav" >
            <!-- SideNav slide-out button -->
           
            <!-- Breadcrumb-->
            
            <div class="breadcrumb-dn mr-auto" >
                <h3><strong>&nbsp;&nbsp;&nbsp;Onda</strong></h3>
            </div>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <li class="nav-item">
                    <a href="/eboutique/adminCat/index" class="nav-link"><i class="fa fa-envelope"></i> <span class="clearfix d-none d-sm-inline-block">Gestion Categories</span></a>
                </li>
                <li class="nav-item">
                    <a href="/eboutique/adminProd/index" class="nav-link"><i class="fa fa-comments-o"></i> <span class="clearfix d-none d-sm-inline-block">Gestion Produits</span></a>
                </li>
               
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     <i class="fa fa-user"></i> Gestion Tickets
                    </a>
                    <div class="dropdown-menu dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/eboutique/adminTick/index">Créer Un Ticket</a>
                        <a class="dropdown-item" href="/eboutique/adminTick/listTickets">Tickets</a>
                        <a class="dropdown-item" href="/eboutique/adminTick/optTickets">Opérations</a>
                    </div>
                </li>
                 <li class="nav-item">
                    <a href="<c:url value="/j_spring_security_logout" />" class="nav-link"><i class="fa fa-user"></i> <span class="clearfix d-none d-sm-inline-block">Deconnexion</span></a>
                </li>
            </ul>
        </nav>
        <!-- /.Navbar -->
    </header>
    <div class="page-header hello" >
        <h1></h1>
    </div>
    <div class="page-header" >
        <div class="divider-new">
                <h2 class="h2-responsive wow bounceIn" id="textColor">Solution Proposée</h2>
 </div>
    </div>
  

<f:form modelAttribute="ticket" action="saveSolution" method="post"
enctype="multipart/form-data" class="form-horizontal">      
<div class="panel panel-primary" >  
<div class="panel-heading" id="newColor">
						<h3 class="panel-title">Solution</h3>
						<div class="pull-right" >
						</div>
</div>
<div class="panel-body">
	<input type="text" class="col-sm-11 form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Developers" />
</div>


<table class="table table-striped" id="dev-table">
	<thead>
		<tr>
			<th>Titre :</th>
			<th>${ticket.titre}</th>
		</tr>
		<tr>
			<th>Equipement Concerné :</th>
			<th>${ticket.produit.serialNumber}</th>
		</tr>
		<tr>
			<th>Problème :</th>
			<th>${ticket.description}</th>
		</tr>
		
		<tr>
			<th>Solution Proposée :</th>
			<th>${ticket.solution}</th>
		</tr>
					
	<thead>

</table>
    </div>

<div class="form-group">
	
		<div class="col-sm-8">
 			<f:input type="hidden" path="idTicket" class="form-control" 
 					 placeholder="ID Produit"/>
 		</div>
</div>

<div class="form-group">
	<label for="description" class="col-sm-2 control-label">Solution Proposée:</label>
		<div class="col-sm-9">
 			<f:textarea path="solution" class="form-control" 
 					id="de" placeholder="Votre Solution"/>
 				
 		</div>
</div>


<div class="form-group">
<div class="col-sm-offset-10 col-sm-12" >
<button type="submit"  class="btn btn-danger">
<span class="glyphicon glyphicon-ok-sign"></span> Enregistrer</button>
</div>
</div>
</f:form>

 <div class="page-header" >
        <div class="divider-new">
                <h2 class="h2-responsive wow bounceIn" id="textColor">Commentaires</h2>
 </div>
    </div>
    <c:forEach items="${commentaire}" var="com">
                <section id="reviews">
                <div class="row">
                    <div class="col-md-12">
                        <!--First review-->
                        <div class="media">
                            <a class="media-left waves-light">
                                <img class="rounded-circle" src="https://mdbootstrap.com/img/Photos/Avatars/avatar-13.jpg" alt="Generic placeholder image">
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading">Admin</h4>
                                <p>${com.commentaire}</p>
                            </div>
                        </div>
                 </div>
                </div>
         </section>   
    </c:forEach>
</body>
</div>
</html>