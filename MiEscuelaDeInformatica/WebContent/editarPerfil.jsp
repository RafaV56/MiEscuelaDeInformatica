<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.*;"%>
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
        <div class="row borde">
			<div class="col-sm-12">
				<%
        Usuario usuario=(Usuario)session.getAttribute("usuario");
        if(usuario!=null){
        %>
				<p>
				<h5 class="alert alert-info">
					Nombre usuario:<%=usuario.getNombre()%>
				</h5>
				<h5 class="alert alert-info">
					Nick usuario:<%=usuario.getNick()%>
				</h5>
				</p>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Editar Perfil</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nombre">Nombre</label>  
  <div class="col-md-4">
  <input id="nombre" name="nombre" type="text" placeholder="nombre" class="form-control input-md" value="<%=usuario.getNombre()%>">
  </div>
</div>

<!-- Appended Input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nick">nick</label>
  <div class="col-md-4">
    <div class="input-group">
      <input id="nick" name="nick" class="form-control" placeholder="Nick" type="text">
      <span class="input-group-addon"><i class="fa fa-user-secret" aria-hidden="true"></i></span>
    </div>
    
  </div>
</div>
<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="Foto">Foto</label>
  <div class="col-md-4">
    <input id="Foto" name="Foto" class="input-file" type="file" disabled="disabled">
  </div>
</div>

<!-- Appended Input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="contrasena">Contraseña</label>
  <div class="col-md-4">
    <div class="input-group">
      <input id="contrasena" name="contrasena" class="form-control" placeholder="Contraseña" type="text">
      <span class="input-group-addon">icono</span>
    </div>
    
  </div>
</div>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="enviar"></label>
  <div class="col-md-4">
    <button id="enviar" name="enviar" class="btn btn-success">Modificar</button>
  </div>
</div>

</fieldset>
</form>

				<%} %>

			</div>
			<!-- fin del col-12 -->
        </div><!--Fin del row-->      
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
