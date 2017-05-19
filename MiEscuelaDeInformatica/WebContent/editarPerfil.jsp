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
          <!-- Div donde se escribiran los errores del usuario --> 
      
       <div class="row">
       <!-- Div id principio sera usado en javaScrip para visualizar los errores que el usuario tiene en el form -->
       	<div id="principio" style="background:#000; color:red; font-size:1.5em; margin:0.5em; padding:0.1em; border-radius:5px;">
        </div>
       </div>
       
        <!--Sección principal-->
        <div class="row" style="margin:0.2em 0em;">

		<%
        Usuario usuario=(Usuario)session.getAttribute("usuario");
        if(usuario!=null){
        %>

		<div class="col-md-10 col-md-offset-1">
		<div class="panel panel-default">
				<div class="panel-heading">
					<span class=" text-info titulo" style="font-size: 1.8em">
					Editar Perfil
					</span>
			</div><!-- fin panel-default -->
				<div class="panel-body">
			<form class="form-horizontal" method="post" action="AceptarCambios">

			<!-- Email Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Email</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="email" name="email" class="form-control" placeholder="Contraseña" type="text" value="<%=usuario.getEmail()%>" readonly="readonly" maxlength="50" required="required">
			      <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
			    </div>  
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="nombre">Nombre</label>  
			  <div class="col-md-4">
			   <div class="input-group">
			  	<input id="nombre" name="nombre" type="text" placeholder="nombre" class="form-control input-md" value="<%=usuario.getNombre()%>" maxlength="50" required>
			    <span class="input-group-addon"><i class="fa fa-address-book"></i></span>
			   </div>	
			  </div>
			</div>
			
			<!-- Appended Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="nick">Nick</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="nick" name="nick" class="form-control" placeholder="Nick" type="text" value="<%=usuario.getNick()%>" maxlength="50">
			      <span class="input-group-addon"><i class="fa fa-user-secret"></i></span>
			    </div>
			  </div>
			</div>
			<!-- Edad input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="edad">Edad</label>  
			  <div class="col-md-4">
			   <div class="input-group">
			  	<input id="edad" name="edad" type="text" placeholder="Edad" class="form-control input-md" value="<%=usuario.getEdad()%>" maxlength="3">
			     <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			   </div> 
			  </div>
			</div>
						
			<!-- Multiple Radios -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="sexo">Sexo</label>
			  <div class="col-md-4">
			  <div class="radio">
			    <label for="sexo-0">
			      <input type="radio" name="sexo" id="sexo-0" value="f" checked="checked" disabled="disabled">
			      Femenino
			    </label>
				</div>
			  <div class="radio">
			    <label for="sexo-1">
			      <input type="radio" name="sexo" id="sexo-1" value="m" disabled="disabled">
			      Masculino
			    </label>
				</div>
			  <div class="radio">
			    <label for="sexo-2">
			      <input type="radio" name="sexo" id="sexo-2" value="o" disabled="disabled">
			      Otro
			    </label>
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
			
			
			<!-- Multiple Radios (inline) -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="cambiarContrasena">¿Cambiar contraseña?</label>
			  <div class="col-md-4"> 
			    <label class="radio-inline" for="cambiarContrasena-0">
			      <input type="radio" name="cambiarContrasena" id="cambiarContrasenaSi" value="s" >
			      Si
			    </label> 
			    <label class="radio-inline" for="cambiarContrasena-1">
			      <input type="radio" name="cambiarContrasena" id="cambiarContrasenaNo" value="n" checked="checked">
			      No
			    </label>
			  </div>
			</div>
			
				
			<!-- Contraseña vieja Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasenaVieja">Contraseña antigua</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="contrasenaVieja" name="contrasenaVieja" class="form-control" placeholder="Contraseña antigua" type="password" maxlength="10" disabled="disabled">
			      <span class="input-group-addon"><i class="fa fa-unlock-alt"></i></span>
			    </div>  
			  </div>
			</div>
						
			<!-- Contraseña nueva Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Contraseña nueva</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="contrasena" name="contrasena" class="form-control" placeholder="Contraseña nueva" type="password" maxlength="10" disabled="disabled">
			      <span class="input-group-addon"><i class="fa fa-unlock"></i></span>
			    </div>  
			  </div>
			</div>
			
			<!-- Contraseña repetida Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Repite la contraseña</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="rContrasena" name="rContrasena" class="form-control" placeholder=" Repite contraseña" type="password" maxlength="10" disabled="disabled">
			      <span class="input-group-addon"><i class="fa fa-unlock"></i></span>
			    </div>  
			  </div>
			</div>
			
			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="enviar"></label>
			  <div class="col-md-4">
			    <button id="enviar" class="btn btn-success">Modificar</button>
			  </div>
			</div>
			
			</form>	
				
			</p>
			</div><!-- fin panel body -->
			</div><!-- fin panel-primary -->
				<%} %>
<p>
	  		 <a href="Welcome">
	  		 	<input class="btn btn-info" type="button" value="Volver al inicio" />
	  		 </a>
       </p>
			</div><!-- fin del col-10 -->
        </div><!--Fin del row-->   
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
