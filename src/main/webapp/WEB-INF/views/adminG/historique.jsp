<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    

    <link href="<c:url value="/resources/assets/css/bootstrap.css"/>" rel="stylesheet">
    
    <link href="<c:url value="/resources/mdb/css/style.css"/>" rel="stylesheet">
    
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- FontAwesome Styles-->
    
    
    <link href="<c:url value="/resources/assets/css/font-awesome.css"/>" rel="stylesheet">
    <!-- Morris Chart Styles-->
    
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
 <div id="page-wrapper" >
            <div id="page-inner">
             <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Liste Des Devices
                        </h1>
                    </div>
                </div> 
<div class="container" style="width:100rem;">
<c:forEach items="${historiques}" var="h">
<div class="col-md-4 col-sm-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading" id="newColor">
                          ID :  ${h.idHProd} 
                          <c:if test="${h.actif ==false} ">
                          <span class="glyphicon glyphicon-bookmark" style="margin-left: 160px; color: red;"> New</span>
                          </c:if>
                        </div>
                        <div class="panel-body">
                        <c:choose>
                         <c:when test="${h.type == 1}">
                            <h4 style="color:red;">Serial Number :</h4>${h.nameProd}
                          </c:when>
                            <c:when test="${h.type== 2}">
                            <h4 style="color:red;">Devices :</h4>${h.nameProd}
                          </c:when>
                          <c:otherwise>
                          <h4 style="color:red;">Titre :</h4>${h.nameProd}
                          </c:otherwise>
                        </c:choose>
                            <h4 style="color:red;">Opération :</h4>${h.operationProd}
                            <h4 style="color:red;">Date d'Opération :</h4>${h.dateHProd}
                            <h4 style="color:red;">Site :</h4>${h.site.nameSite}
                             
                        </div>
                        <div class="panel-footer">
                            
                        </div>
                    </div>

</div>
</c:forEach>
</div>
</div>
</div>

 </div> 
   <script src="<c:url value="/resources/assets/js/jquery-1.10.2.js" />"></script> 
    <script src="<c:url value="/resources/assets/js/jquery.metisMenu.js" />"></script>
    <script src="<c:url value="/resources/assets/js/custom-scripts.js" />"></script>
    <script src="<c:url value="/resources/assets/js/bootstrap.min.js" />"></script>
   
  

    
    
    
</body>
</html>