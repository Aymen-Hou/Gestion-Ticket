<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    

    <link href="<c:url value="/resources/assets/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/jquerryFilter.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/mdb/css/style.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/js/filtrage.js" />"></script>
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- FontAwesome Styles-->
    
    
    <link href="<c:url value="/resources/assets/css/font-awesome.css"/>" rel="stylesheet">
    <!-- Morris Chart Styles-->
    <link href="<c:url value="/resources/assets/js/morris/morris-0.4.3.min.css"/>" rel="stylesheet">
    <!-- Custom Styles-->
    <link href="<c:url value="/resources/assets/css/custom-styles.css"/>" rel="stylesheet">
    
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />


<script src="<c:url value="/resources/js/jquery-1.12.4.js" />"></script>
<script src="<c:url value="/resources/js/pagination.js" />"></script>
<script src="<c:url value="/resources/js/filtrage.js" />"></script>
<script src="<c:url value="/resources/js/bootbox.min.js" />"></script>
<script src="<c:url value="/resources/js/dialogComfirm.js" />"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ONDA</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
              
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu" href="/eboutique/adminG/dashboard"><i class="fa fa-dashboard"></i> Tableau De Bord</a>
                    </li>
                     <li>
                        <a href="/eboutique/adminG/ListTicket"><i class="fa fa-desktop"></i> Tickets</a>
                    </li>
                    
                    <li>
                        <a href="/eboutique/adminG/ListDevices"><i class="fa fa-qrcode"></i> Devices</a>
                    </li>
                    <li>
                        <a href="/eboutique/adminG/ListModeles"><i class="fa fa-qrcode"></i> Modèles</a>
                    </li>

                   

                    <li>
                        <a href="#"><i class="fa fa-table"></i> Historiques<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/eboutique/adminG/historique?type=3">Tickets</a>
                            </li>
                            <li>
                                <a href="/eboutique/adminG/historique?type=2">Modèles</a>
                            </li>
                            <li>
                                <a href="/eboutique/adminG/historique?type=1">Produits</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>

            </div>

        </nav>
 <div id="page-wrapper" >
            <div id="page-inner">
             <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Liste Des Modèles 
                            <a href="excel?output=excel" class="btn btn-danger" style="margin-left: 500px"><span class="glyphicon glyphicon-plus-sign"></span> Exporter Vers Excel</a>
                        </h1>
                        
                    </div>
                </div> 
<div class="container" style="width:100rem;">
<div class="panel panel-primary" style="width:100rem;" >  
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
			<th>Sous Contrat?</th>
			<th>Date d'ajout</th>
			<th>Site</th>
		</tr>
	<thead>
	<tbody id="myTable">
<c:forEach items="${produits}" var="p"> 
	<tr>
		<td>${p.idProduit}</td>
		<td>${p.modele}</td>
		<td>${p.categorie.nomCategorie}</td>
		<td>${p.serialNumber}</td>
		<td>${p.selectionne}</td>
		<td>${p.dateAM}</td>
		<td>${p.site.nameSite}</td>
		
	</tr>
	</c:forEach>
 </tbody>

</table>
 <div class="col-md-12 text-center">
      <ul class="pagination pagination-lg pager" id="myPager"></ul>
      
      </div>
</div>
</div>
</div>
</div>
</div>
  
<!--      <script src="<c:url value="/resources/assets/js/jquery-1.10.2.js" />"></script>-->
    <script src="<c:url value="/resources/assets/js/jquery.metisMenu.js" />"></script>
    <script src="<c:url value="/resources/assets/js/custom-scripts.js" />"></script>
    
    
    
</body>
</html>