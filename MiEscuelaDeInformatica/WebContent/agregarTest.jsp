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
    		String error=(String)request.getAttribute("error");
    		String respuesta=(String)request.getAttribute("respuesta");
      		 if(error!=null){       
       %>
       <h1 class="alert alert-danger text-center">
       	<i class="fa fa-info-circle fa-2"></i>
       	<%=error%>
       </h1>
       <%
       }else if(respuesta!=null){
    	%>   
    	 <h1 class="alert alert-success text-center">
      		 <i class="fa fa-hand-peace-o fa-2"></i>
       	 <%=respuesta%>
      	 </h1>
    	<%	   
       }
        %>
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class=" text-info titulo" style="font-size: 1.8em">
					Añadir nuevo test
					</span>
			</div><!-- fin panel-default -->
			<div class="panel-body">
			<form class="form-horizontal" method="post" action="InsertarTest">
			
			<!-- Nombre del test Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Nombre del test</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="nombreTest" name="nombreTest" class="form-control" placeholder="Nombre del test" type="text" maxlength="50" />
			      <span class="input-group-addon"><i class="fa fa-paperclip"></i></span>
			    </div>  
			  </div>
			</div><!-- fin del form group -->
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="enviar"></label>
			  <div class="col-md-4">
			    <input type="submit" class="btn btn-success" value="Crear" />
			  </div>
			</div>
		
			</form>
			</div><!-- fin panel body -->
			</div><!-- fin panel-primary -->
			
				<div class="panel panel-default">
				<div class="panel-heading">
					<span class=" text-info titulo" style="font-size: 1.8em">
					Añadir preguntas a un test
					</span>
			</div><!-- fin panel-default -->
			<div class="panel-body">
			<form class="form-horizontal" method="post" action="InsertarPreguntasTest">
			
			<!-- Nombre del test Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Nombre del test</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="nombreTest" name="nombreTest" class="form-control" placeholder="Nombre del test" type="text" maxlength="50" />
			      <span class="input-group-addon"><i class="fa fa-paperclip"></i></span>
			    </div>  
			  </div>
			</div><!-- fin del form group -->
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="enviar"></label>
			  <div class="col-md-4">
			    <input type="submit" class="btn btn-success" value="Insertar" />
			  </div>
			</div>
		
			</form>
			</div><!-- fin panel body -->
			</div><!-- fin panel-primary -->
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
