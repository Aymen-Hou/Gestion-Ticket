
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%><!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Free Bootstrap Admin Template : Dream</title>
    <!-- Bootstrap Styles-->
    <link href="<c:url value="/resources/assets/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/mdb/css/style.css"/>" rel="stylesheet">
    
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
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">


                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Tableau De Bord 
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-green">
                            <div class="panel-body">
                                <i class="fa fa-bar-chart-o fa-5x"></i>
                                <h3>${NbrHistoriquesTick}</h3>
                            </div>
                           <a href="/eboutique/admin/historique?type=3"> <div class="panel-footer back-footer-green">
                                Tickets

                            </div></a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-blue">
                            <div class="panel-body">
                                <i class="fa fa-shopping-cart fa-5x"></i>
                                <h3>${NbrHistoriquesMod}</h3>
                            </div>
                            <a href="/eboutique/admin/historique?type=1">
                            <div class="panel-footer back-footer-blue">
                                Modèles

                            </div></a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-red">
                            <div class="panel-body">
                                <i class="fa fa fa-comments fa-5x"></i>
                                <h3>${NbrHistoriquesDevices}</h3>
                            </div>
                            <a href="/eboutique/admin/historique?type=2">
                            <div class="panel-footer back-footer-red">
                                Devices

                            </div></a>
                        </div>
                    </div>
                    
                </div>


                <div class="row">


                    <div class="col-md-9 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Bar Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-bar-chart"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Statut Des Tickets 
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /. ROW  -->

                <div class="row">
                   
                    <div class="col-md-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Responsive Table Example 
                                <c:forEach items="${date}" var="p"> 
	<tr>
		<td>${p}</td>

	</tr>
	</c:forEach>
                            </div> 
                                                      </div> 
 <div class="panel panel-primary" style="width:100rem;" >  
<div class="panel-heading" id="newColor">
						<h3 class="panel-title">Tickets</h3>
</div>
<table class="table table-striped" id="dev-table">
	<thead>
		<tr>
			<th>Titre</th>
			<th>Produit Concernée</th>
			<th>Date Ouverture</th>
			<th>Date Fermeture</th>
			<th>Description</th>
			<th>Priorité</th>
			<th>Statut</th>
			<th>Solution</th>
		</tr>
	<thead>
	<tbody id="myTable">
<c:forEach items="${tickets}" var="p"> 
	<tr>
		<td>${p.titre}</td>
		<td>${p.produit.serialNumber}</td>
		<td>${p.dateO}</td>
		<td>${p.dateF}</td>
		<td>${p.description}</td>
		<td>${p.priorite.namePrio}</td>
		<td>${p.statut.nameStatut}</td>
		<td>${p.solution}</td>
		

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
                <!-- /. ROW  -->
				<footer><p>All right reserved. Template by: <a href="http://webthemez.com">WebThemez</a></p></footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="<c:url value="/resources/assets/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/resources/assets/js/bootstrap.min.js" />"></script>
    <!-- Bootstrap Js -->
    <script src="<c:url value="/resources/assets/js/jquery.metisMenu.js" />"></script>
    <script src="<c:url value="/resources/assets/js/morris/morris.js" />"></script>
    <script src="<c:url value="/resources/assets/js/custom-scripts.js" />"></script>
    <script src="<c:url value="/resources/assets/js/morris/raphael.js" />"></script>
    <!-- Metis Menu Js -->
    <script type="text/javascript">

          var NewTick="${NewTick}";
          var ResolvedTick="${ResolvedTick}";
          var TaitTick="${TraitTick}";// use expression tag in JSP here
          var NumberT ="${NumberT}";
          var NumberP ="${NumberP}";
</script>


</body>

</html>