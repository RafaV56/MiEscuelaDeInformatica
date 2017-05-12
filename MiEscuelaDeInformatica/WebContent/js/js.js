	$(document).ready(function(e) {
		
	   //Nombre del usuario
	   $('#nombre').on("change",nombre);
	   //Email del usuario
	   $('#email').on("change",email);
	   //Edad del usuario
	   $('#edad').on("change",edad);
	   //Nick del usuario
	   $('#nick').on("change",nick);
	   //Contrase�a del usuario
	   $('#contrasena').on("change",contrasena);
	   //Si se pierde el foco tamibien se llama confirmar contrase�a para ver si est� correcta
	   $('#contrasena').on("blur",rContrasena);
	   //Repetir la conntrase�a
	   $('#rContrasena').on("change",rContrasena);
	   
	   
	   
	   //Funci�n para borrar de la pantalla el div de errores con solo dar click en cualquier parte de �l
	   $('#principio').click(function(e) {
	   	$('#principio').fadeOut(1000);
		});
	
	   $('#enviar').click(function(e) {//funcion para validar
			var bandera=true;
			//Borro todo lo que contenga el div principio para rellenarlo de los errores
			$('#principio').empty();
			//llamo a validar nombre si devuelve falso agrego el error al div principio y as� con todos
			if(!nombre()){
				$('#principio').append('<h3>-El campo nombre es obligatorio, m�ximo 50 caracteres.</h3>');
					bandera=false;
			}
			//valido el email.
			if(!email()){
				$('#principio').append(
				'<h3>-El email es obligatorio, y tiene que ser correcto, no puede tener m�s de 50 		caracteres</h3>'
				);
					bandera=false;
			}
			//Valido la edad
			if(!edad()){
				$('#principio').append('<h3>-El campo edad es obligatorio, deber ser entre 7 y 120 a�os</h3>');
					bandera=false;
			}
			//Valido el nick
			if(!nick()){
				$('#principio').append('<h3>-El nick es obligatorio, deber ser entre 1 y 50 caracteres</h3>');
					bandera=false;
			}
			//V�lido la contrase�a
			if(!contrasena()){
				$('#principio').append('<h3>-La contrase�a es obligatoria, deber ser entre 1 y 10 caracteres</h3>');
					bandera=false;
			}
			//V�lido la contrase�a repetida
			if(!rContrasena()){
				$('#principio').append('<h3>-Repite la contrase�a es obligatoria, deber ser igual a la contrase�a</h3>');
					bandera=false;
			}
			if(bandera){		
				 $('#rContrasena').remove();
				alert('Completado correctamente');
			}
			$('body,html').animate({scrollTop : 100}, 1200);//para ir al principio de la p�gina
			$('#principio').show(2000).focus();
					
			return bandera;
		});
	});
	
	//Funci�n para comparar que la contrase�a este correcta
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
				$('#rContrasena').attr('title',"Repite la contrase�a correctamente");
				$('#sRcontrasena').removeClass('glyphicon glyphicon-ok form-control-feedback');
				$('#rContrasena').parent().addClass('has-error has-feedback');
				$('#sRcontrasena').addClass('glyphicon glyphicon-remove form-control-feedback');
			}	
			return bandera;
	}
	
	
	//funcion para validar la contrase�a del usuario
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
				$('#contrasena').attr('title',"T� contrase�a es obligatoria, debe ser entre 1 y 10 caracteres");
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
	//si es un n�mero entro
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
			$('#sEdad').removeClass('glyphicon glyphicon-remove form-control-feedback');
			$('#edad').parent().addClass('has-success has-feedback');
			$('#sEdad').addClass('glyphicon glyphicon-ok form-control-feedback');
			bandera=true;
		}else{
			$('#edad').parent().removeClass('has-success has-feedback');
			$('#edad').attr('data-toggle',"tooltip");
			$('#edad').attr('title',"Tu edad debe ser v�lida y estar en el rango de 7 a 120 a�os");
			$('#sEdad').removeClass('glyphicon glyphicon-ok form-control-feedback');
			$('#edad').parent().addClass('has-error has-feedback');
			$('#sEdad').addClass('glyphicon glyphicon-remove form-control-feedback');
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
				$('#sNombre').removeClass('glyphicon glyphicon-remove form-control-feedback');
				$('#nombre').parent().addClass('has-success has-feedback');
				$('#sNombre').addClass('glyphicon glyphicon-ok form-control-feedback');
				bandera=true;
			}else{
				$('#nombre').parent().removeClass('has-success has-feedback');
				$('#nombre').attr('data-toggle',"tooltip");
				$('#nombre').attr('title',"T� nombre es obligatorio");
				$('#sNombre').removeClass('glyphicon glyphicon-ok form-control-feedback');
				$('#nombre').parent().addClass('has-error has-feedback');
				$('#sNombre').addClass('glyphicon glyphicon-remove form-control-feedback');
			}	
			return bandera;
		}