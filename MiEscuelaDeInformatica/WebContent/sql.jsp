<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    <!-- Seccion Principal -->
   	<%@ include file="generales/sqlRecursos/sql.html" %>
   	<!-- ------------------------------------ -->
    
    
    <!-- Pie de página -->
     <%@include file="generales/piePagina.html" %>
     <!-- ------------------------------------ -->
    
    </div><!--fin container-fluid-->
</body>
</html>