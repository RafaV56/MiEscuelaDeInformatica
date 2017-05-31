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
    	 
     })
     
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
				<div class="row">
    <div class="col-md-10 col-md-offset-1">
    
      <div class="row">
      <form action="InsertarPregunta" method="post">
        <div class="col-md-6">
          <span style="font-size: 1.3em; color:#2c8042;">Código de ejemplo</span>
        </div>
      </div>
      <textarea class="form-control" id="codigoEjemplo" name="codigoEjemplo" placeholder="Código de ejemplo" rows="5" ></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <input type="submit" value="Guardar pregunta" class="btn btn-success" id="enviarCodigo" />
        </div>
      </div>
        </form>
    </div>
  </div>

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
