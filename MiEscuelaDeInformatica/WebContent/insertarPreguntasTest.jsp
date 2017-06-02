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
    	 $('#pregunta').Editor();
    	 
    	 $('#enviar').click(function(e){
    		$('#codigoEjemplo').text($('#codigoEjemplo').Editor('getText'));
    		$('#pregunta').text($('#pregunta').Editor('getText'));
    		 e.preventDefault();
    		$('#formulario').submit();
    	 });
    	 
     });
     
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
    	String error=(String)request.getAttribute("error");
    	String respuesta=(String)request.getAttribute("respuesta");
      	Test test=(Test)session.getAttribute("test");
       if(respuesta!=null){
       %>
       <h1 class="alert alert-success text-center">
        <i class="fa fa-hand-peace-o fa-2"></i>
        <%=respuesta%>
       </h1>
       <%
       //si hay error 
       }
       if(error!=null){       
       %>
       <h1 class="alert alert-danger text-center">
       	<i class="fa fa-info-circle fa-2"></i>
       	<%=error%>
       </h1>
       <%
       }
       %>
       <div class="panel panel-default">
				<div class="panel-heading text-center">
				<span class=" text-info titulo" style="font-size: 1.8em">
					 	Insertar preguntas al test: <%=test.getNombre()%>
				</span>
				</div><!-- fin panel heading -->
				<h3 class="alert alert-success" style="margin:0.2em 0.2em;">
			       Rellena cada panel con la información necesaria.<br><br>
			        1) El código de ejemplo no es obligatorio <br>
			        2) La pregunta es obligatoria, con mínimo dos respuestas	
			    </h3>
				<div class="panel-body">
				<form action="InsertarPregunta" method="post" id="formulario">
				  <div class="form-group">
				  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#codigoPanel">Codigo Ejemplo</a>
					      </h4>
					    </div>
					    <div id="codigoPanel" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="8" class="form-control" name="codigoEjemplo" id="codigoEjemplo"></textarea>
						</div>
					      <div class="panel-footer">Inserta un código de ejemplo, no es obligatorio.</div>
					    </div>
					  </div>
					</div><!-- fin del panel group -->
					
					  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#preguntaPanel">Pregunta</a>
					      </h4>
					    </div>
					    <div id="preguntaPanel" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="3" class="form-control" name="pregunta" id="pregunta"></textarea>
						</div>
					      <div class="panel-footer">Escribe la pregunta</div>
					    </div>
					  </div>
					</div> <!-- fin panel group -->
					
					  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#respuestaA">(Respuesta A) &nbsp;</a> 
						  	   	 ¿Correcta? 
						  		<input type="radio" name="respuestaValida" value="a" checked="checked">
						  	 </span>	
					      </h4>
					    </div>
					    <div id="respuestaA" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="3" class="form-control" name="respuestaA" id="respuestaA"></textarea>
						</div>
					      <div class="panel-footer">Escribe la respuesta A</div>
					    </div>
					  </div>
					</div> <!-- fin panel group -->
					  
					  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#respuestaB">(Respuesta B)  &nbsp;</a>
					        ¿Correcta? 
						  	<input type="radio" name="respuestaValida" value="b">
					      </h4>
					    </div>
					    <div id="respuestaB" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="3" class="form-control" name="respuestaB" id="respuestaB"></textarea>
						</div>
					      <div class="panel-footer">Escribe la respuesta B</div>
					    </div>
					  </div>
					</div> <!-- fin panel group -->
					  
					  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#respuestaC">(Respuesta C)  &nbsp;</a>
					        ¿Correcta? 
						  	<input type="radio" name="respuestaValida" value="c">
					      </h4>
					    </div>
					    <div id="respuestaC" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="3" class="form-control" name="respuestaC" id="respuestaC"></textarea>
						</div>
					      <div class="panel-footer">Escribe la respuesta C</div>
					    </div>
					  </div>
					</div> <!-- fin panel group -->
					 
					  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#respuestaD">(Respuesta D)  &nbsp;</a>
					        ¿Correcta? 
						  	<input type="radio" name="respuestaValida" value="d">
					      </h4>
					    </div>
					    <div id="respuestaD" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="3" class="form-control" name="respuestaD" id="respuestaD"></textarea>
						</div>
					      <div class="panel-footer">Escribe la respuesta D</div>
					    </div>
					  </div>
					</div> <!-- fin panel group -->
					
					  <div class="panel-group">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" href="#respuestaE">(Respuesta E)  &nbsp;</a>
					        ¿Correcta? 
						  	<input type="radio" name="respuestaValida" value="e">
					      </h4>
					    </div>
					    <div id="respuestaE" class="panel-collapse collapse">
					      <div class="panel-body">
							 <textarea rows="3" class="form-control" name="respuestaE" id="respuestaE"></textarea>
						</div>
					      <div class="panel-footer">Escribe la respuesta E</div>
					    </div>
					  </div>
					</div> <!-- fin panel group -->
				  </div>
				   <button id="enviar" class="btn btn-success">Enviar pregunta</button>
				</form>
				
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
