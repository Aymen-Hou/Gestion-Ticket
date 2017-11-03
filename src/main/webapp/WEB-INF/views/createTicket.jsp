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
                <h2 class="h2-responsive wow bounceIn" id="textColor">Ajouter Un Ticket</h2>
 </div>
    </div>
    
        
<div id="formProd" class="example z-depth-3">
<f:form modelAttribute="ticket" action="saveTick" method="post"
enctype="multipart/form-data" class="form-horizontal">

<div class="form-group">
	<label for="idTicket" class="col-sm-2 control-label">ID Ticket:</label>
		<div class="col-sm-8">
 			<f:input type="hidden" path="idTicket" class="form-control" 
 					 placeholder="ID Ticket"/>
 			
 		</div>
</div>
<div class="form-group">
	<label for="titre" class="col-sm-2 control-label">Titre</label>
		<div class="col-sm-9">
 			<f:input type="text"  path="titre" class="form-control" 
 					id="titre" placeholder="titre"/>
       

 		</div>
</div>

<div class="form-group">
	<label for="Categorie" class="col-sm-2 control-label">Equipement:</label>
		<div class="col-sm-9">
 		<f:select path="produit.idProduit" items="${produits}" itemValue="idProduit" itemLabel="serialNumber"  class="form-control"/> 
 		
 	</div>
</div>
<div class="form-group">
	<label for="Categorie" class="col-sm-2 control-label">Statut:</label>
		<div class="col-sm-9">
 		<f:select path="statut.idStatut" items="${statuts}" itemValue="idStatut" itemLabel="nameStatut"  class="form-control"/> 
 				
 	</div>
</div>

<div class="form-group">
	<label for="Categorie" class="col-sm-2 control-label">Priorité:</label>
		<div class="col-sm-9">
 		<f:select path="priorite.idPrio" items="${priorites}" itemValue="idPrio" itemLabel="namePrio"  class="form-control"/> 
 				
 	</div>
</div>



<div class="form-group">
	<label for="do" class="col-sm-2 control-label">Date d'ouverture:</label>
		<div class="col-sm-9">
 			<f:input type="date"  path="dateO" class="form-control" 
 					id="do" placeholder="Date d'ouverture"/>
 					
 		</div>
</div>

<div class="form-group">
	<label for="de" class="col-sm-2 control-label">Date d'echéance:</label>
		<div class="col-sm-9">
 			<f:input type="date"  path="dateF" class="form-control" 
 					id="de" placeholder="Date d'echéance"/>
 					
 		</div>
</div>

<div class="form-group">
	<label for="description" class="col-sm-2 control-label">Description:</label>
		<div class="col-sm-9">
 			<f:textarea path="description" class="form-control" 
 					id="de" placeholder="Description"/>
 				
 		</div>
</div>






 

<div class="form-group">
<div class="col-sm-offset-10 col-sm-12 reload" >
<button type="submit"  class="btn btn-primary" id="reload" >
<span class="glyphicon glyphicon-ok-sign"></span> Enregistrer</button>
</div>
</div>
	
</f:form>
</div>

 
</div>
</body>
</html>