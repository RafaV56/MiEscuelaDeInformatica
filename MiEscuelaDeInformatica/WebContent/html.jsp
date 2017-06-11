<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.*" %>
<!--Rafael Velásquez, Version:0.1, 6/2/2017-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Common -->
    <%@include file="generales/common.html" %>  
    <!-- ------------------------------------ -->   
</head>
<body>
	<!-- Barra de navegación -->
    <%@ include file="generales/barraNavegacion.jsp" %>
    <!-- ---------------------- -->
        
    <div class="container borde">
    <!-- Cabecera -->
   	<%@ include file="generales/cabecera.html" %>
   	<!-- ------------------------------------ -->
   	
   	    <%
    	//Si un test a sido corregido y quieren volver al tema, viene de respuestaTest.jsp
    	TestCorregido test=(TestCorregido)session.getAttribute("testCorregido");  	
    	if(test!=null){
    		if(test.getTecnologia().equalsIgnoreCase("html")){
    %>
    <div class="row">
    	<div class="col-sm-12">
    	<p style="margin:0.2em 0em;">
	  		    <h2 class="alert alert-success text-center text-capitalize">
        <i class="fa fa-undo fa-2"></i>
       	 	 Seguir en el tema:  		 
	  		 <a href="#<%=test.getTema()%>" data-toggle="collapse" data-parent="#accordion" class="btn btn-primary">
	  		 	<%=test.getTema()%>
	  		 </a>
	  		 </h2>
       </p>
    	</div>
    </div>
    
    <%} } %>
    
    <!-- Seccion Principal -->
   	<%@ include file="generales/htmlRecursos/html.html" %>
   	<!-- ------------------------------------ -->
    
    
    <!-- Pie de página -->
     <%@include file="generales/piePagina.html" %>
     <!-- ------------------------------------ -->
    
    </div><!--fin container-fluid-->
</body>
</html>