<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--Rafael Velásquez Millán, Version:0.1, 6/2/2017-->
<!DOCTYPE html>
<html lang="en">
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
        
        <!--Sección principal-->
        <div class="row borde">
        <h1>Hola la session es:</h1>
        <%=
        session.getId()
        %>
        
        <div class="well">
        	<p class="text-justify">
        		Esta aplicación se hizo con el fin de ayudar a todos los alumnos que estudian desarrollo de aplicaciones web
        		dando información corta y con ejemplos, de las tecnologías que se usan en el proceso de contruir una todo el 
        		software necesario.
        	</p>
        </div>
        
        </div><!--Fin del row-->      
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
