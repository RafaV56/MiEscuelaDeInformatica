<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.*;"%>
<!--Rafael Velásquez Millán, Version:0.3, 6/2/2017-->
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
       
        <!--Sección principal-->
        <div class="row" style="margin:0.2em 0em;">
        <div class="col-sm-12">
         <%
    		TestCorregido test=(TestCorregido)session.getAttribute("testCorregido");  	
        	 String nombre=test.getNombreTest();
      		 if(test.getError()!=null){       
       %>
       <h1 class="alert alert-danger text-center">
       	<i class="fa fa-info-circle fa-2"></i>
       	<%=test.getError()%>
       </h1>
       <%
      		 }else{
    	   
    	   if(test.getSuperado().equals("s")){
       %>

       <h1 class="alert alert-success text-center">
        <i class="fa fa-hand-peace-o fa-2"></i>
       		El test <%=test.getTema()%> fue superado<br />
       		Correctas: <%=test.getCorrectas()%> Errores: <%=test.getErrores()%>
       		
       </h1>
      	<%
    	   }else{
      	%>
       		 <h1 class="alert alert-danger text-center">
		       	<i class="fa fa-times-circle fa-2"></i>
		     	 El test <%=test.getTema()%> no a sido superado <br />
       			 Correctas: <%=test.getCorrectas()%> Errores: <%=test.getErrores()%>
		       </h1>
       <%
    	   }
    	   //pintamos los botones para volver a intentar o para volver al tema
    	%>
    		<div class="btn-group btn-group-justified">
			 <a href="Test?intentar=s" class="btn btn-warning">
		 		<span style="font-size: 1.3em">Intentar nuevamente</span>
			</a>
			 <a href="<%=test.getTecnologia()%>" class="btn btn-success">
				<span style="font-size: 1.3em">Volver al tema</span>
			 </a>
			</div>
	  		
    	<%
    	//Agrego el tema
    	session.setAttribute("tema",test.getTema());
       }%>
		<p style="margin:0.2em 0em;">
	  		 <a href="Welcome">
	  		 	<input class="btn btn-info" type="button" value="Volver al inicio" />
	  		 </a>
       </p>
       
       	</div><!-- fin del col-sm-12 -->
        </div><!--Fin del row-->   
     	
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-->
	</body>
</html>
