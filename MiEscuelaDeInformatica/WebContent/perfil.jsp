<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<div class="col-sm-10 col-sm-offset-1">
			<%
				if(request.getAttribute("error")!=null){
					String error=(String)request.getAttribute("error");
			%>
				
			<div class="panel panel-default">
				<div class="panel-heading text-center">
					<span class=" text-info titulo" style="font-size: 1.8em">
						Información de error
					</span>
			</div><!-- fin panel-default -->
				<div class="panel-body">
				<h4 class="alert alert-danger">
					<i class="fa fa-user-times fa-2" aria-hidden="true"></i>
						<%=error%>
						vuelva a intentarlo
				</h4>
				<p>
				<form method="post" action="Identificar">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email" class="form-control" id="emailUsuario" value="<%=request.getParameter("emailUsuario") %>" name="emailUsuario" maxlength="50">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Contraseña</label>
					    <input type="password" class="form-control" id="contrasena" placeholder="contraseña" name="contrasena" maxlength="10">
					  </div>
					  <div class="checkbox">
					    <label>
					      <input type="checkbox" name="recuerdame"> Recuerdame
					    </label>
					  </div>
					  <button type="submit" class="btn btn-success" id="enviarDatos">Enviar</button>
					</form>
				
			</p>
			</div><!-- fin panel body -->
			</div><!-- fin panel-default -->
		<%
				}else{	
        %>
       <h2 class="alert alert-info text-center">
			Usuario identificado correctamente <i class="fa fa-thumbs-o-up fa-2" aria-hidden="true"></i>
	   </h2>
        <%
        	}
		%>
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
