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
        <%
       		String error=(String)request.getAttribute("error");
       		String respuesta=(String)request.getAttribute("respuesta");
       	%>
       
       <!-- Div id principio sera usado en javaScrip para visualizar los errores que el usuario tiene en el form -->
       	<div id="principio" style="background:#000; color:red; font-size:1.5em; padding:0.1em; border-radius:5px;">
        </div>
       </div>
       
       <%
       /*busco la repuesta del servlet agregar usuario que si tiene una respuesta 
         hay un usuario creado correctamente pero si tiene error lo explica
         al final muestra el formulario para insertar un usuario*/
       if(respuesta!=null){
       %>
       <h1 class="alert alert-success text-center"><%=respuesta%></h1>
       <%
       }else if(error!=null){       
       %>
       <h1 class="alert alert-danger text-center"><%=error%></h1>
       <%
       }else{
       %>
       <!-- Formulario de registro -->
   		<%@ include file="generales/formularioRegistro.html" %>
   		<!-- ------------------------------------ -->
       <%} %> 
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>