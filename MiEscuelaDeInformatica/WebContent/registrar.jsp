<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    <!-- Common -->
    <%@include file="generales/common.html" %>  
    <!-- ------------------------------------ -->  
    <!-- JavaScrip para validar el formulario de registro js.js -->
    <script src="js/js.js"></script> 
       
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
       	<div id="principio" style="background:#000; color:red; font-size:1.5em; padding:0.1em; border-radius:5px;">
        </div>
       </div>
        
        <!--Sección principal-->
        <div class="row borde">
       	
       	   <h3 class="alert alert-success text-uppercase text-center col-sm-10  col-sm-offset-1">Formulario de registro</h3>
      
      <form class="form-horizontal" method="post" id="formularioRegistro">
      
      	<div class="col-sm-6">
         <div class="form-group">
          <label class="control-label col-sm-2" for="nombre">Nombre </label>
          <div class="col-sm-9">
          	 <input type="text" class="form-control" id="nombre" placeholder="Tú nombre" name="nombre" maxlength="50" required>
             <span id="sNombre"></span>
          </div><!-- fin col 9-->
      	</div><!-- fin form-group -->
        
 		 <div class="form-group">
          <label class="control-label col-sm-2" for="email">Email </label>
          <div class="col-sm-9">
          	 <input type="text" class="form-control" id="email" placeholder="Tú email" name="email" maxlength="50" required>
             <span id="sEmail"></span>
          </div><!-- fin col 9-->
      	</div><!-- fin form-group -->
        
        <div class="form-group">
          <label class="control-label col-sm-2" for="edad">Edad </label>
          <div class="col-sm-9">
          	 <input type="text" class="form-control" id="edad" placeholder="Edad" name="edad" maxlength="3" required>
             <span id="sEdad"></span>
          </div><!-- fin col 9-->
      	</div><!-- fin form-group -->
        
        </div><!-- fin col-6 -->
        
        <div class="col-sm-6">
        	<div class="form-group">
          <label class="control-label col-sm-2" for="nick">Nick </label>
          <div class="col-sm-9">
          	 <input type="text" class="form-control" id="nick" placeholder="Nombre por el que te llamaremos" name="nick" maxlength="50" required>
             <span id="sNick"></span>
          </div><!-- Fin del col 9 -->
      	</div><!-- fin form-group -->
        
        <div class="form-group">
          <label class="control-label col-sm-2" for="contrasena">Contraseña </label>
          <div class="col-sm-9">
  <input type="password" class="form-control" id="contrasena" placeholder="Contraseña para indentificarte" name="contrasena" maxlength="10"required>
             <span id="sContrasena"></span>
          </div><!-- fin col 9-->
      	</div><!-- fin form-group -->
        
            <div class="form-group">
          <label class="control-label col-sm-2" for="rContrasena">Repite la Contraseña </label>
          <div class="col-sm-9">
  <input type="password" class="form-control" id="rContrasena" placeholder="Repite la contraseña" name="rContrasena" maxlength="10" disabled required>
             <span id="sRcontrasena"></span>
          </div><!-- fin col 9-->
      	</div><!-- fin form-group -->
        
        </div><!-- fin col-6 -->
        
        
        <div class="col-sm-12">
         <div class="form-group">
            <div class="col-sm-offset-5 col-sm-2">
            <button type="submit" id="enviar" class="btn btn-success btn-block">
            	<span class="glyphicon glyphicon-paperclip"></span>
            	Guardar
            </button>
            </div><!--Fin del col 2-->
         </div><!--Fin form group-->
        </div><!--Fin col 12-->
      </form>
        
        </div><!--Fin del row-->      
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>