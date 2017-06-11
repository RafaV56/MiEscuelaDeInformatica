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
     <script type="text/javascript">
     $(document).ready(function(e) {
 		
    	 $('#emailProfesor').on("blur",ajax);
  	   
     });
     
   //Funcion ajax para ver si un email está en la base de datos
 	function ajax(){
 		$.post("ajax/usuarioLibre.jsp",
 			    {
 			        name: $('#emailProfesor').val(),
 			    },
 			    function(data){			    	
 			    	$('#ajaxEmail').empty();
 			        $('#ajaxEmail').append(data);
 			    });
 	}
     
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
			<div class="col-sm-10 col-sm-offset-1">
		  <%
    		String error=(String)request.getAttribute("error");
		 	String respuesta=(String)request.getAttribute("respuesta");
		  	if(error!=null){
		  %>
			   <h1 class="alert alert-danger text-center">
       			<i class="fa fa-info-circle fa-2"></i>
       	 	<%=error%>
      		   </h1>
      		   <%}else if(respuesta!=null){ %>
      		   <h1 class="alert alert-success text-center">
        <i class="fa fa-hand-peace-o fa-2"></i>
        <%=respuesta%>
       </h1>
       <% } %>
			<div class="panel panel-default">
				<div class="panel-heading text-center">
					<span class=" text-info titulo" style="font-size: 1.8em">
						Añadir profesor
					</span>
			</div><!-- fin panel-default -->
				<div class="panel-body">
				<p>
				<form method="post" action="AgregarProfesor">
				<div id="ajaxEmail">
       			</div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email" class="form-control" id="emailProfesor" value="" name="emailProfesor" maxlength="50">
					  </div>
					  <button type="submit" class="btn btn-success" id="enviarDatos">Enviar</button>
					</form>
				
			</p>
			</div><!-- fin panel body -->
			</div><!-- fin panel-default -->
		<p>
	  		 <a href="Welcome">
	  		 	<input class="btn btn-info" type="button" value="Volver al inicio" />
	  		 </a>
       </p>
			</div><!-- fin del col-sm-10 -->
		</div><!--Fin del row-->    
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
