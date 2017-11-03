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

<script src="<c:url value="/resources/js/jquery-1.12.4.js" />"></script>
<script src="<c:url value="/resources/js/pagination.js" />"></script>
<script src="<c:url value="/resources/js/filtrage.js" />"></script>
<script src="<c:url value="/resources/js/bootbox.min.js" />"></script>
<script src="<c:url value="/resources/js/dialogComfirm.js" />"></script>
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
<div class="container">
<div>
<a href="<c:url value="/j_spring_security_logout" />">
Logout</a>

</div>
    <div class="page-header hello" >
        <h1></h1>
        ${exception}
    </div>
    <div class="page-header" >
        <div class="divider-new">
                <h2 class="h2-responsive wow bounceIn" id="textColor">Ajouter Un Modèle</h2>
 </div>
    </div>
    
        
<div id="formProd" class="example z-depth-3">
<f:form modelAttribute="produit" action="saveProd" method="post"
 class="form-horizontal">

<div class="form-group">
	<label for="idProduit" class="col-sm-2 control-label">ID Modèle:</label>
		<div class="col-sm-8">
 			<f:input type="hidden" path="idProduit" class="form-control" 
 					 placeholder="ID Produit"/>
 			
 		</div>
</div>
<div class="form-group">
	<label for="designation" class="col-sm-2 control-label">Nom Modèle</label>
		<div class="col-sm-9">
 			<f:input type="text"  path="modele" class="form-control" 
 					id="designation" placeholder="Nom Modèle"/>
       

 		</div>
</div>

<div class="form-group">
	<label for="Categorie" class="col-sm-2 control-label">Devise Name:</label>
		<div class="col-sm-9">
 		<f:select path="categorie.idCategorie" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie"  class="form-control"/> 
 				
 	</div>
</div>

<div class="form-group">
	<label for="description" class="col-sm-2 control-label">Fonction:</label>
		<div class="col-sm-9">
 			<f:input type="text"  path="fonction" class="form-control" 
 					id="description" placeholder="Fonction"/>
 					
 		</div>
</div>

<div class="form-group">
	<label for="prix" class="col-sm-2 control-label">Serial Number:</label>
		<div class="col-sm-9">
 			<f:input type="text"  path="serialNumber" class="form-control" 
 					id="prix" placeholder="Serial Number"/>
 					
 		</div>
</div>

<div class="form-group">
	<label for="quantite" class="col-sm-2 control-label">Product Number:</label>
		<div class="col-sm-9">
 			<f:input type="text"  path="productNumber" class="form-control" 
 					id="quantite" placeholder="Product Number"/>
 					
 		</div>
</div>

<div class="form-group">
	<label for="selectionne" class="col-sm-2 control-label" >Sous Contrat de Maitenance ?:</label>
		<div class="col-sm-9">
 			<f:checkbox path="selectionne" class="form-control" 
 					id="selectionne" placeholder="Cochez si OUI !"/>
 				
 			
 		</div>
</div>
 			 
 			 <div class="form-group">
	<label for="da" class="col-sm-2 control-label">Date d'ajout:</label>
		<div class="col-sm-9">
 			<f:input type="date"  path="dateAM" class="form-control" 
 					id="da" placeholder="Date d'ajout"/>
 					
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
<div class="divider-new">
<div class="page-header" >
                <h2 class="h2-responsive wow fadeInDown" id="textColor">Liste des Modèles</h2>
                </div>
 </div>
    
<div class="panel panel-primary" >  
<div class="panel-heading" id="newColor">
						<h3 class="panel-title">Modèles</h3>
						<div class="pull-right" >
							<span class="clickable filter" data-toggle="tooltip" title="Toggle table filter" data-container="body">
								<i class="glyphicon glyphicon-filter"></i>
							</span>
						</div>
</div>
<div class="panel-body">
	<input type="text" class="col-sm-11 form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Developers" />
</div>


<table class="table table-striped" id="dev-table">
	<thead>
		<tr>
			<th>ID Modèle</th>
			<th>Nom Modèle</th>
			<th>Device Name</th>
			<th>Serial Number</th>
			<th>Product Number</th>
			<th>Fonction</th>
			<th>Sous Contrat de maintenance ?</th>
			<th>Date d'ajout</th>
		</tr>
	<thead>
	<tbody id="myTable">
<c:forEach items="${produits}" var="p"> 
	<tr>
		<td>${p.idProduit}</td>
		<td>${p.modele}</td>
		<td>${p.categorie.nomCategorie}</td>
		<td>${p.serialNumber}</td>
		<td>${p.productNumber}</td>
		<td>${p.fonction}</td>
		<td>${p.selectionne}</td>
		<td>${p.dateAM}</td>
		<td><a href="editProd?idProd=${p.idProduit}" class="btn btn-info"><span class="glyphicon glyphicon-edit"></span> Editer</a></td>
		<td><a class="delete btn btn-danger" data-id="${p.idProduit}" href="javascript:void(0)"><span class="glyphicon glyphicon-trash"></span> Supprimer</a> </td>
	</tr>
	</c:forEach>
 </tbody>

</table>
 <div class="col-md-12 text-center">
      <ul class="pagination pagination-lg pager" id="myPager"></ul>
      
      </div>
</div>

</div>

</body>

