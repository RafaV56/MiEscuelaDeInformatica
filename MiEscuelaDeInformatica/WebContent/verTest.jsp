<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="domain.*,java.util.*;"%>
<!--Rafael Vel�squez Mill�n, Version:0.2, 6/2/2017-->
<!DOCTYPE html>
<html lang="en">
    <head>
    <!-- Common -->
    <%@include file="generales/common.html" %>  
    <!-- ------------------------------------ -->   
       
	</head>
	<body>   
       <!-- Barra de navegaci�n -->
       <%@ include file="generales/barraNavegacion.jsp" %>
       <!-- ---------------------- -->  
    
		<div class="container borde">
   		
   		<!-- Cabecera -->
   		<%@ include file="generales/cabecera.html" %>
   		<!-- ------------------------------------ -->
        
        <!--Secci�n principal-->
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
		ArrayList<HacerTest> testDesarrollados=(ArrayList<HacerTest>)session.getAttribute("testDesarrollados");
        if(usuario!=null){ 	
        	//Si hay test desarrollados y son almenos 1l
        	%><div class="col-md-10 col-md-offset-1"><%
        	if(testDesarrollados!=null && testDesarrollados.size()>0){
        %>

		
			<div class="panel panel-default">
				<div class="panel-heading text-center">
				<span class=" text-info titulo" style="font-size: 1.8em">
					 	Tus test desarrollados
				</span>
				</div>
				<div class="panel-body">
				
				
				<div class="table-responsive" style="padding:0.2em;">
				<table class="table table-striped table-bordered">
			    <thead>
			      <tr>
			        <th>Nombre del Test</th>
			        <th>�Superado?</th>
			        <th>�Repetir?</th>
			      </tr>
			    </thead>
			    <% 
			    	for(HacerTest test: testDesarrollados){
			    %>
			    <tbody>
			    	<tr>
			    		<td>
			    		<%=test.getTestCorregido().getNombreTest()%>
			    		</td>
			    		<td>
			    		<%=test.getSuperado().equals("s")?"Si":"No"%>
			    		</td>
			    		<td>
			    		<form action="Test?nombre=<%=test.getTestCorregido().getNombreTest()%>" method="post">
                   			<input type="submit" value="ir al test" class="btn btn-info" />
               	   		</form>
			    		</td>
			    	</tr>
				</tbody>
				
				<%
				}//fin del for
				
				%>
					</table>
					</div>
					</div><!-- fin panel body -->
				</div><!-- fin panel-default -->
				<%
			    
        	}else{//fin del if test
        		%>
        		
        		 <h1 class="alert alert-info text-center">
			       	<i class="fa fa-info-circle fa-2"></i>
			       	No tienes test desarrollados
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
     	
     	<!-- Pie de p�gina -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>
