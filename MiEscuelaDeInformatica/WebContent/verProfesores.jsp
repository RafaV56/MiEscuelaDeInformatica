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
         <%
    		String error=(String)request.getAttribute("error");
      		 if(error!=null){       
       %>
       <h1 class="alert alert-danger text-center">
       	<i class="fa fa-info-circle fa-2"></i>
       	<%=error%>
       </h1>
       <%
       }
        Usuario usuario=(Usuario)session.getAttribute("usuario");
		ArrayList<Profesor> profesores=(ArrayList<Profesor>)session.getAttribute("profesores");
        if(usuario!=null){ 	
        	//Si hay test desarrollados y son almenos 1l
        	%><div class="col-md-10 col-md-offset-1"><%
        	if(profesores!=null && profesores.size()>0){
        %>

		
			<div class="panel panel-default">
				<div class="panel-heading text-center">
				<span class=" text-info titulo" style="font-size: 1.8em">
					 	Tus Profesores
				</span>
				</div>
				
				<div class="table-responsive" style="padding:0.2em;">
				<table class="table table-striped table-bordered">
			    <thead>
			      <tr>
			        <th>Nombre</th>
			        <th>Email</th>
			        <th>Nick</th>
			      </tr>
			    </thead>
			    <% 
			    	for(Profesor profesor: profesores){
			    %>
			    <tbody>
			    	<tr>
			    		<td>
			    		<%=profesor.getProfesor().getNombre()%>
			    		</td>
			    		<td>
			    		<%=profesor.getProfesor().getEmail()%>
			    		</td>
			    		<td>
			    		<%=profesor.getProfesor().getNick()%>
			    		</td>
			    	</tr>
			    	
			    <%
			    	//Si las lista de test no es nula y tiene al menus un test se pinta una fila en la tabla
			    	if(profesor.getTestProfesor()!=null && profesor.getTestProfesor().size()>0){
			    		
			    		
			    %>
			    
			    	 <thead>
				      <tr>
				        <th colspan="3" class="text-center bg-success">
				        <span class="text-info">Todos los test del profesor</span>
				         <span class="text-danger"><%=profesor.getProfesor().getNick() %></span>
				        </th>
				      </tr>
				    </thead>
			    
			    
			    <%		
			    		for(Test test: profesor.getTestProfesor()){
			    %>
			    	
			    	<tr>
			    		<td colspan="3" class="text-center bg-warning">
			    			<%=test.getNombre() %>		
			    	
			    			<form action="Test?nombre=<%=test.getNombre()%>" method="post">
                   				<input type="submit" value="ir al test" class="btn btn-info">
               	   			</form>
               	   		</td>
			    	</tr>
			    
			    <%}} %>
				</tbody>
				
				<%
				}//fin del for
				
				%>
					</table>
					</div><!-- fin panel body -->
				</div><!-- fin panel-default -->
				<%
			    
        	}else{//fin del if test
        		%>
        		
        		 <h1 class="alert alert-info text-center">
			       	<i class="fa fa-info-circle fa-2"></i>
			       	No tienes Profesores
			       </h1>
        		<%		
        	}//fin else test
        	
        	}//fin del if usuario
        	%>
			
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
