<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
<script src="<c:url value="/resources/js/dialogComfirmCat.js" />"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--Import Google Icon Font-->
     
</head>

<body class="hidden-sn mdb-skin">

    <!--Double navigation-->
    <header>
        <!-- Sidebar navigation -->

        <!--/. Sidebar navigation -->
        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav" >
            <!-- SideNazv slide-out button -->
           
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

<div class="container">
<div>
<a href="<c:url value="/j_spring_security_logout" />">
Logout</a>

</div>
    <div class="page-header hello" >
        <h4 style="margin-top:8rem;color:#243a51">Espace de Gestion Des Equipements IT Aéroportuaires </h4>
        <div>${exception}</div>
    </div>
          

        <h1>${nameSite}</h1>
    <div class="page-header" >
        <div class="divider-new">
                <h2 class="h2-responsive wow bounceIn" id="textColor">Adding Devices</h2>
 </div>
    </div>
    
    
        
<div id="formCat" class="example z-depth-3">
<f:form modelAttribute="categorie" action="saveCat" method="post"
enctype="multipart/form-data" class="form-horizontal">

<div class="form-group">
	<label for="idCategorie" class="col-sm-2 control-label">ID Device:</label>
		<div class="col-sm-9">
 			<f:input type="hidden" path="idCategorie" class="form-control" 
 					 placeholder="ID Catégorie"/>
 			
 		</div>
</div>
<div class="form-group">
	<label for="nomCategorie" class="col-sm-2 control-label">Device Name:</label>
		<div class="col-sm-9">
 			<f:input type="text"  path="nomCategorie" class="form-control" 
 					id="nomCatégorie" placeholder="Device Name:"/>


 		</div>
</div>


<div class="form-group">
	<label for="Categorie" class="col-sm-2 control-label">Localite:</label>
		<div class="col-sm-9">
 		<f:select path="localite.idLocalite" items="${localites}" itemValue="idLocalite" itemLabel="nameLocalite"  class="form-control"/> 
 				
 	</div>
</div> 			
 
<div class="form-group">
	<label for="da" class="col-sm-2 control-label">Date d'ajout:</label>
		<div class="col-sm-9">
 			<f:input type="date"  path="dateA" class="form-control" 
 					id="da" placeholder="Date d'ajout"/>
 					
 		</div>
</div>
<div class="form-group">
<div class="col-sm-offset-10 col-sm-12 reload">
<button type="submit"  class="btn btn-primary"  id="reload" >
<span class="glyphicon glyphicon-ok-sign"></span> Enregistrer</button>
</div>
</div>
	
</f:form>
</div>

<div class="divider-new">
<div class="page-header" >
                <h2 class="h2-responsive wow fadeInDown" id="textColor">Liste des Devices</h2>
                </div>
 </div>
 
 <div class="panel panel-primary">  
<div class="panel-heading" id="newColor">
						<h3 class="panel-title">Devices</h3>
						<div class="pull-right">
						</div>
</div>


<table class="table table-striped">
<tr>
<th>ID</th><th>Device Name</th><th>Date D'ajout</th><th>Localité</th>
<th></th><th></th>
</tr>
<c:forEach items="${categories}" var="cat">
<tr>
<td>${cat.idCategorie}</td>
<td>${cat.nomCategorie}</td>
<td>${cat.dateA}</td>
<td>${cat.localite.nameLocalite}</td>
<td><a href="editCat?idCat=${cat.idCategorie}" class="btn btn-info"><span class="glyphicon glyphicon-edit"></span> Editer</a></td>
<td><a href="modeleCat?idCat=${cat.idCategorie}" class="btn btn-danger"><span class="glyphicon glyphicon-plus-sign"></span> Modèles</a></td>
<!--  <td><a class="deleteCat btn btn-danger" data-id="${cat.idCategorie}" href="javascript:void(0)"><span class="glyphicon glyphicon-trash"></span> Supprimer</a></td>
-->
</tr>
</c:forEach>
</table>
</div>
</div>
