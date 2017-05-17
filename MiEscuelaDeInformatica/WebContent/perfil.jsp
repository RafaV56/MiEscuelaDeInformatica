<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--Rafael Vel�squez Mill�n, Version:0.2, 6/2/2017-->
<!DOCTYPE html>
<html lang="en">
    <head>
    <!-- Common -->
    <%@include file="generales/common.html" %>  
    <!-- ------------------------------------ -->   
       
	</head>
	<body>   
       <!-- Barra de navegaci�n -->
       <%@ include file="generales/barraNavegacion.jsp" %>
       <!-- ---------------------- -->  
    
		<div class="container borde">
   		
   		<!-- Cabecera -->
   		<%@ include file="generales/cabecera.html" %>
   		<!-- ------------------------------------ -->
        
        <!--Secci�n principal-->
        <div class="row borde">
        <h1>Crear la p�gina de perfil de usuario</h1>
        <p>email: <%=request.getParameter("emailUsuario") %></p>
        <p>contrase�a: <%=request.getParameter("contrasena") %></p>
        <p>Error: 
        <%
        	String error=(String)request.getAttribute("error");
        %>
        <%=error%>
        </p>
        

        
        
        </div><!--Fin del row-->      
     	
     	<!-- Pie de p�gina -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
