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
        <div class="row borde" style=" background-color:rgba(51, 122, 183, 0.17); text-align: center;  color:#fff;">
			<div class="col-sm-12">
				<h1>
					<a href="" class="typewrite" data-period="2000"
						data-type='[ "Bienvenidos","Mi Escuela De Informática", 
									 "Estudia tus tecnologías preferidas",
									 "J2EE",
									  "Java, HTML, CSS, SQL" ,
									  "Resuelve test y refuerza tu conocimiento",
									  "hazte profesor y crear tu propios test"]'  style="color:#3e2b2b;">
						<span class="wrap"  style="color:#3e2b2b;"></span>
					</a>
				</h1>
			</div>
	 </div><!--Fin del row-->
	 <div class="row">
	 	<div class="col-sm-12 text-center" style=" background-color: #474e5d; color: #ffffff;">
				<h3 style="margin-bottom:1em;">Estudia las tecnologías necesarias para el desarrollo de aplicaciones web</h3>
				<p>
					Está aplición fue creada como proyecto final del grado superior <abbr title="Desarrollo de Aplicaciones Web">DAW</abbr><br>
					con el fin de ayudar a todos los estudiantes de este módulo a encontrar de forma más sencilla los temas 
					relacionados con sus estudios, encontrando ejemplos claros de cada código.
					Se trataran los temas básicos de las principales tecnologías y podrás hacer pequeños test, para reforzar tus 
					conocimientos 
				</p>
			</div> 
	 </div>
	 <div class="row">
	 	<div class="col-sm-12 text-center" style="background-color: rgba(75, 75, 75, 0.58); color: #ffffff;">
				<div class="container-fluid bg-3 text-center">
					<h3 class="margin">¿Qué puedes hacer?</h3>
					<br>
					<div class="row">
						<div class="col-sm-4">
							<p>Estudia el código Básico de los principales lenguajes</p>
							<img src="img/html.png" class="img-responsive margin"
								style="width: 100%" alt="Image">
						</div>
						<div class="col-sm-4">
							<p>Crea tu perfil de usuario muy rápidamente solo con tu email.
								Añade profesores y pide que te cree test personalizados sobre cada 
								tema o temas que estés estudiando</p>
							<img src="img/usuario.png" class="img-responsive margin"
								style="width: 100%" alt="Image">
						</div>
						<div class="col-sm-4">
							<p>Pide a tus estudiantes que te añadan como profesor y crea test
							personalizados para ellos</p>
							<img src="img/profesor.png" class="img-responsive margin"
								style="width: 100%" alt="Image">
						</div>
					</div>
				</div>
			</div> 
	 </div>
        <script type="text/javascript">
      //made by vipul mirajkar thevipulm.appspot.com
        var TxtType = function(el, toRotate, period) {
                this.toRotate = toRotate;
                this.el = el;
                this.loopNum = 0;
                this.period = parseInt(period, 10) || 2000;
                this.txt = '';
                this.tick();
                this.isDeleting = false;
            };

            TxtType.prototype.tick = function() {
                var i = this.loopNum % this.toRotate.length;
                var fullTxt = this.toRotate[i];

                if (this.isDeleting) {
                this.txt = fullTxt.substring(0, this.txt.length - 1);
                } else {
                this.txt = fullTxt.substring(0, this.txt.length + 1);
                }

                this.el.innerHTML = '<span class="wrap">'+this.txt+'</span>';

                var that = this;
                var delta = 200 - Math.random() * 100;

                if (this.isDeleting) { delta /= 2; }

                if (!this.isDeleting && this.txt === fullTxt) {
                delta = this.period;
                this.isDeleting = true;
                } else if (this.isDeleting && this.txt === '') {
                this.isDeleting = false;
                this.loopNum++;
                delta = 500;
                }

                setTimeout(function() {
                that.tick();
                }, delta);
            };

            window.onload = function() {
                var elements = document.getElementsByClassName('typewrite');
                for (var i=0; i<elements.length; i++) {
                    var toRotate = elements[i].getAttribute('data-type');
                    var period = elements[i].getAttribute('data-period');
                    if (toRotate) {
                      new TxtType(elements[i], JSON.parse(toRotate), period);
                    }
                }
                // INJECT CSS
                var css = document.createElement("style");
                css.type = "text/css";
                css.innerHTML = ".typewrite > .wrap { border-right: 0.08em solid #fff}";
                document.body.appendChild(css);
            };
        </script>     
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
