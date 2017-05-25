<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.*;"%>
<!--Rafael Velásquez Millán, Version:0.3, 6/2/2017-->
<!DOCTYPE html>
<html lang="en">
    <head>
    <!-- Common -->
    <%@include file="generales/common.html" %>  
    <!-- ------------------------------------ -->   
     <script type="text/javascript" src="js/modificar.js"></script>  
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
        <div class="row" style="margin:0.2em 0em;">
         <%
    		String error=(String)request.getAttribute("error");
    		String respuesta=(String)request.getAttribute("respuesta");
    		Test test=(Test)session.getAttribute("testCompleto");
    		String nombreTest=test.getNombre();
    		
       /*busco la repuesta del servlet corregirTest que si tiene una respuesta 
         hay un test resuelto pero si tiene error lo explica
         al final muestra el formulario para volver a intentarlo, o volver al tema*/
       if(respuesta!=null){
    	   
    	   if(respuesta.equals("s")){
       %>

       <h1 class="alert alert-success text-center">
        <i class="fa fa-hand-peace-o fa-2"></i>
       		El test <%=nombreTest %> fue superado
       </h1>
      	<%
    	   }else if(respuesta.equals("n")){
      	%>
       		 <h1 class="alert alert-danger text-center">
		       	<i class="fa fa-times-circle fa-2"></i>
		       El test <%=nombreTest %> no a sido superado
		       </h1>
       <%
    	   }
       //si hay error 
       }
       if(error!=null){       
       %>
       <h1 class="alert alert-danger text-center">
       	<i class="fa fa-info-circle fa-2"></i>
       	<%=error%>
       </h1>
       <%
       }
       %>

		<p>
	  		 <a href="Welcome">
	  		 	<input class="btn btn-info" type="button" value="Volver al inicio" />
	  		 </a>
       </p>
        </div><!--Fin del row-->   
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-->
	</body>
</html>
