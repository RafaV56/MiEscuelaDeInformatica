<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="domain.*,java.util.*;"%>
<!--Rafael Velásquez Millán, Version:0.2, 6/2/2017-->
<!DOCTYPE html>
<html lang="en">
    <head>
    <!-- Common -->
    <%@include file="generales/common.html" %>  
    <!-- ------------------------------------ -->   
     <link rel="stylesheet" href="css/editor.css">
     <script src="js/editor.js"></script>
     <script type="text/javascript">
     $(document).ready(function(){
    	 
    	 $('#codigoEjemplo').Editor();
    	 
    	 $('#enviar').click(function(e){
    		$('#codigoEjemplo').text($('#codigoEjemplo').Editor('getText'));
    		 e.preventDefault();
    		$('#formulario').submit();
    	 });
    	 
     });
     
     </script>
     
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
		 <div class="col-md-10 col-md-offset-1">
         <%
    	//	String error=(String)request.getAttribute("error");
    	//	String respuesta=(String)request.getAttribute("respuesta");
      	Test test=(Test)session.getAttribute("test");
       %>
       <div class="panel panel-default">
				<div class="panel-heading text-center">
				<span class=" text-info titulo" style="font-size: 1.8em">
					 	Insertar preguntas al test: <%=test.getNombre()%>
				</span>
				</div><!-- fin panel heading -->
				<div class="panel-body">
				<form action="InsertarPregunta" method="get" id="formulario">
				  <div class="form-group">
				    <label for="codigoEjemplo">Codigo Ejemplo</label>
				    <textarea rows="8" class="form-control" name="codigoEjemplo" id="codigoEjemplo"></textarea>
				  </div>
				   <button id="enviar" class="btn btn-success">Modificar</button>
				</form>
				
				</div><!-- fin panel body -->
				</div><!-- fin panel-default -->
		 <p>
	  	  <a href="Welcome">
	  	 	<input class="btn btn-info" type="button" value="Volver al inicio" />
	  	  </a>
         </p>	
		</div><!-- fin del col-10 -->
		</div><!-- fin del row -->   
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
