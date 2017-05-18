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
     <script type="text/javascript">
     
 	$(document).ready(function(e) {
		
 	   //Nombre del usuario
 	   $('#nombre').on("change",nombre);
 	  //Edad del usuario
	   $('#edad').on("change",edad);
 	  
	   //Función para borrar de la pantalla el div de errores con solo dar click en cualquier parte de él
	   $('#principio').click(function(e) {
	   	$('#principio').fadeOut(500);
		});
 	   
 	   

 	   $('#enviar').click(function(e) {//funcion para validar
 			var bandera=true;
 			//Borro todo lo que contenga el div principio para rellenarlo de los errores
 			$('#principio').empty();
 			//llamo a validar nombre si devuelve falso agrego el error al div principio y así con todos
 			if(!nombre()){
 				$('#principio').append('<h3>-El campo nombre es obligatorio, máximo 50 caracteres.</h3>');
 					bandera=false;
 			}
 			//Valido la edad
			if(!edad()){
				$('#principio').append('<h3>-El campo edad es obligatorio, deber ser entre 7 y 120 años</h3>');
					bandera=false;
			}
 			$('body,html').animate({scrollTop : 100}, 1200);//para ir al principio de la página
 			$('#principio').show(2000).focus();
 					
 			return bandera;
 		});
 	});
 	
 	//Función para comparar que la contraseña este correcta
 	function rContrasena(){
 		var bandera=false;
 		//hay que comparar cada vez que no este disabled
 		 if(($('#rContrasena').val().length>0 && $('#rContrasena').val().length<=10)&&($('#rContrasena').val()==$('#contrasena').val())){
 				$('#rContrasena').removeAttr('data-toggle');
 				$('#rContrasena').removeAttr('title');
 				$('#rContrasena').parent().removeClass('has-error has-feedback');
 				$('#sRcontrasena').removeClass('glyphicon glyphicon-remove form-control-feedback');
 				$('#rContrasena').parent().addClass('has-success has-feedback');
 				$('#sRcontrasena').addClass('glyphicon glyphicon-ok form-control-feedback');
 			
 				bandera=true;
 			}else{
 				$('#rContrasena').parent().removeClass('has-success has-feedback');
 				$('#rContrasena').attr('data-toggle',"tooltip");
 				$('#rContrasena').attr('title',"Repite la contraseña correctamente");
 				$('#sRcontrasena').removeClass('glyphicon glyphicon-ok form-control-feedback');
 				$('#rContrasena').parent().addClass('has-error has-feedback');
 				$('#sRcontrasena').addClass('glyphicon glyphicon-remove form-control-feedback');
 			}	
 			return bandera;
 	}
 	
 	
 	//funcion para validar la contraseña del usuario
 	function contrasena(){
 		var bandera=false;
 		 if($('#contrasena').val().length>0 && $('#contrasena').val().length<=10){
 				$('#contrasena').removeAttr('data-toggle');
 				$('#contrasena').removeAttr('title');
 				$('#contrasena').parent().removeClass('has-error has-feedback');
 				$('#sContrasena').removeClass('glyphicon glyphicon-remove form-control-feedback');
 				$('#contrasena').parent().addClass('has-success has-feedback');
 				$('#sContrasena').addClass('glyphicon glyphicon-ok form-control-feedback');
 				
 				$('#rContrasena').removeAttr("disabled");
 				bandera=true;
 			}else{
 				$('#contrasena').parent().removeClass('has-success has-feedback');
 				$('#contrasena').attr('data-toggle',"tooltip");
 				$('#contrasena').attr('title',"Tú contraseña es obligatoria, debe ser entre 1 y 10 caracteres");
 				$('#sContrasena').removeClass('glyphicon glyphicon-ok form-control-feedback');
 				$('#contrasena').parent().addClass('has-error has-feedback');
 				$('#sContrasena').addClass('glyphicon glyphicon-remove form-control-feedback');
 				
 				$('#rContrasena').attr("disabled","disabled");
 				$('#rContrasena').val("");
 			}	
 			return bandera;
 		}
 	
 	
 	//funcion para validar el nick del usuario
 	function nick(){
 		var bandera=false;
 		 if($('#nick').val().length>0 && $('#nick').val().length<=50){
 				$('#nick').removeAttr('data-toggle');
 				$('#nick').removeAttr('title');
 				$('#nick').parent().removeClass('has-error has-feedback');
 				$('#sNick').removeClass('glyphicon glyphicon-remove form-control-feedback');
 				$('#nick').parent().addClass('has-success has-feedback');
 				$('#sNick').addClass('glyphicon glyphicon-ok form-control-feedback');
 				bandera=true;
 			}else{
 				$('#nick').parent().removeClass('has-success has-feedback');
 				$('#nick').attr('data-toggle',"tooltip");
 				$('#nick').attr('title',"Tu nick es obligatorio, debe ser entre 1 y 50 caracteres");
 				$('#sNick').removeClass('glyphicon glyphicon-ok form-control-feedback');
 				$('#nick').parent().addClass('has-error has-feedback');
 				$('#sNick').addClass('glyphicon glyphicon-remove form-control-feedback');
 			}	
 			return bandera;
 		}
 	
 	
 	//funcion para validar la edad del usuario 
 	function edad(){
 	var bandera=false;
 	var nombreVer=$('#edad').val();
 	var vale=true;
 	//pregunto si el la edad tiene algo difer
 	if(isNaN(nombreVer)){
 		vale=false;
 	}
 	//si es un número entro
 	if(!isNaN(nombreVer)){
 		//si esta en el rango que quiero no entro.
 		if(!(parseInt(nombreVer)>=7 && parseInt(nombreVer)<=120)){
 		vale=false;
 		}
 	}
 	if($('#edad').val().length>=1 && $('#edad').val().length<=3 && vale){
 			$('#edad').removeAttr('data-toggle');
 			$('#edad').removeAttr('title');
 			$('#edad').parent().removeClass('has-error has-feedback');
 			$('#edad').parent().addClass('has-success has-feedback');
 			bandera=true;
 		}else{
 			$('#edad').parent().removeClass('has-success has-feedback');
 			$('#edad').attr('data-toggle',"tooltip");
 			$('#edad').attr('title',"Tu edad debe ser válida y estar en el rango de 7 a 120 años");			
 			$('#edad').parent().addClass('has-error has-feedback');
 		} 
 	return bandera;	
 	}
 		
 	//funcion para validar un mail.	
 	function email(){
 	var nombre= $('#email').val();
 	var bandera=false;
 	var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
 	if (nombre=="") {
 		$('#email').parent().removeClass('has-success has-feedback');
 		$('#email').attr('data-toggle',"tooltip");
 		$('#email').attr('title',"El mail es obligatorio");
 		$('#sEmail').removeClass('glyphicon glyphicon-ok form-control-feedback');
 		$('#email').parent().addClass('has-error has-feedback');
 		$('#sEmail').addClass('glyphicon glyphicon-remove form-control-feedback');
 	}else if (patron.test(nombre) &&  $('#email').val().length<=50){
 		$('#email').removeAttr('data-toggle');
 		$('#email').removeAttr('title');
 		$('#email').parent().removeClass('has-error has-feedback');
 		$('#sEmail').removeClass('glyphicon glyphicon-remove form-control-feedback');
 		$('#email').parent().addClass('has-success has-feedback');
 		$('#sEmail').addClass('glyphicon glyphicon-ok form-control-feedback');
 		bandera=true;
 	} else {
 		$('#email').parent().removeClass('has-success has-feedback');
 		$('#email').attr('data-toggle',"tooltip");
 		$('#email').attr('title',"El mail es obligatorio");
 		$('#sEmail').removeClass('glyphicon glyphicon-ok form-control-feedback');
 		$('#email').parent().addClass('has-error has-feedback');
 		$('#sEmail').addClass('glyphicon glyphicon-remove form-control-feedback');
 	}
 	
 	
 	return bandera;
 	}	
 		
 	//Para validar el nombre del usuario.
 	function nombre(){
 		var bandera=false;
 		 if($('#nombre').val().length>0 && $('#nombre').val().length<50){
 				$('#nombre').removeAttr('data-toggle');
 				$('#nombre').removeAttr('title');
 				$('#nombre').parent().removeClass('has-error has-feedback');
 				$('#nombre').parent().addClass('has-success has-feedback');
 				bandera=true;
 			}else{
 				$('#nombre').parent().removeClass('has-success has-feedback');
 				$('#nombre').attr('data-toggle',"tooltip");
 				$('#nombre').attr('title',"Tú nombre es obligatorio");
 				$('#nombre').parent().addClass('has-error has-feedback');
 			}	
 			return bandera;
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
          <!-- Div donde se escribiran los errores del usuario --> 
      
       <div class="row">
       <!-- Div id principio sera usado en javaScrip para visualizar los errores que el usuario tiene en el form -->
       	<div id="principio" style="background:#000; color:red; font-size:1.5em; padding:0.1em; border-radius:5px;">
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
				<!--  <h4 class="alert alert-danger">
					<i class="fa fa-user-times fa-2" aria-hidden="true"></i>
						vuelva a intentarlo
				</h4>-->
			<p>
			<form class="form-horizontal">

			<!-- Email Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Email</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="email" name="email" class="form-control" placeholder="Contraseña" type="text" value="<%=usuario.getEmail()%>" disabled="disabled" maxlength="50" required="required">
			      <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
			    </div>  
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="nombre">Nombre</label>  
			  <div class="col-md-4">
			  <input id="nombre" name="nombre" type="text" placeholder="nombre" class="form-control input-md" value="<%=usuario.getNombre()%>" maxlength="50" required>
			  </div>
			</div>
			
			<!-- Appended Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="nick">Nick</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="nick" name="nick" class="form-control" placeholder="Nick" type="text" value="<%=usuario.getNick()%>">
			      <span class="input-group-addon"><i class="fa fa-user-secret"></i></span>
			    </div>
			  </div>
			</div>
			<!-- Edad input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="edad">Edad</label>  
			  <div class="col-md-4">
			  <input id="edad" name="edad" type="text" placeholder="Edad" class="form-control input-md" value="<%=usuario.getEdad()%>">
			    
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
			
			<!-- Contraseña Input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="contrasena">Modificar contraseña</label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <input id="contrasena" name="contrasena" class="form-control" placeholder="Contraseña" type="text">
			      <span class="input-group-addon"><i class="fa fa-unlock"></i></span>
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
