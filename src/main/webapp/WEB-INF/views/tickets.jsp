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
                        <a class="dropdown-item" href="/eboutique/adminTick/tickets">Tickets</a>
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
                <h2 class="h2-responsive wow bounceIn" id="textColor">Tickets</h2>
 </div>
    </div>
 <% int i=1;%>   
 <c:forEach items="${tickets}" var="t">    
<%
if(i%3==0){
%>      
               
                <%i=i+1; %>
                <div class="col-md-4" id="dims">
                    <!--Card-->
                    
                    <div class="card wow fadeInUp" style="width: 20rem;max-height:27rem;">

                        <!--Card image-->
                        <div class="view overlay hm-white-slight">
                            <img src="https://mdbootstrap.com/images/regular/city/img%20(2).jpg" class="img-fluid" style="max-height:14rem;" alt="">
                            <a>
                                <div class="mask"></div>
                            </a>
                        </div>
                        <!--/.Card image-->

                        <!--Card content-->
                        <div class="card-block text-center">
                            <!--Title-->
                            <h4 class="card-title">${t.titre}</h4>
                            <hr>
                            <!--Text-->
                            <p class="card-text">${t.description}</p>
                            <a href="detailTickets?idTick=${t.idTicket}"class="btn btn-primary">Details</a>
                            <a href="solutionTickets?idTick=${t.idTicket}"  class="btn btn-danger">Solutionné ?</a>
                        </div>
                        <!--/.Card content-->

                    </div>
                    <!--/.Card-->
                
                 <div class="row"></div>
               </div>
<%}else { %>               
                   <div class="col-md-4">
                   <%i=i+1; %>
                    <!--Card-->
                    <div class="card wow fadeInUp" style="width: 20rem;max-height:27rem;">

                        <!--Card image-->
                        <div class="view overlay hm-white-slight">
                            <img src="https://mdbootstrap.com/images/regular/city/img%20(2).jpg" class="img-fluid" style="width: 20rem;max-height:14rem;"  alt="">
                            <a>
                                <div class="mask"></div>
                            </a>
                        </div>
                        <!--/.Card image-->

                        <!--Card content-->
                        <div class="card-block text-center">
                            <!--Title-->
                            <h4 class="card-title">${t.titre}</h4>
                            <hr>
                            <!--Text-->
                            <p class="card-text">${t.description}</p>
                            <a href="detailTickets?idTick=${t.idTicket}" class="btn btn-primary">Details</a>
                            <a href="solutionTickets?idTick=${t.idTicket}" class="btn btn-danger">Solutionné ?</a>
                        </div>
                        <!--/.Card content-->

                    </div>
                    <!--/.Card-->
                
                </div>
  <%} %>    
                </c:forEach>
                
             
</body>
</div> 

</html>