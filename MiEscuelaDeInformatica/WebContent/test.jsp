<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.*,java.util.List" %>
<!--Rafael Velásquez Millán, Version:0.1, 6/2/2017-->
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
   		
   		
   	  	<%
       	//si en el servler test, hay error se pinta ve los siguiente
   	  	String error=(String)request.getAttribute("error");
   		  
   		 if(error!=null){
  		%>
       	<div class="row borde">
   		<h1 class="alert alert-danger text-center col-sm-10  col-sm-offset-1">
       	<i class="fa fa-exclamation-circle fa-2"></i>
       		<%=error%>
       	</h1>
       	</div><!--fin container-fluid-->
       	<%
       	//si todo va bien se pinta el test
   		 }else{
   		%>
      <div class="row" style="margin:0.2em 0em;">
      
      <div class="col-md-12">
      <%
      //creo panel para las preguntas del test
      //cargo el test
      Test test=(Test)session.getAttribute("testCompleto");
      
      //nombre del test
      String nombreTest=test.getNombre();
      List<Pregunta> preguntas=test.getPreguntas();
      int contador=1;
       
      %>
      <div class="panel panel-default">
				<div class="panel-heading text-center">
					<span class=" text-info text-capitalize titulo" style="font-size: 1.8em">
						<%=nombreTest%>
					</span>
			</div><!-- fin panel-default -->
				<div class="panel-body">
				
				
				<div class="table-responsive">
				<table class="table table-striped table-bordered">
			    <thead>
			      <tr>
			        <th>Pregunta</th>
			        <th>Responder</th>
			      </tr>
			    </thead>
			    <tbody>
			    <%
			    	for(Pregunta pregunta: preguntas){
			    %>
			      <tr>
			        <td>Número <%=contador%></td>
			        <td>
			        	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal<%=contador%>">
			        	Pregunta <%=contador%>
			        	</button>
			        <!-- Modal -->
                    <div class="modal fade" id="myModal<%=contador%>" role="dialog">
                      <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color:rgba(255,0,0,1);"><%=nombreTest%></h4>
                          </div>
                          <div class="modal-body">
                            <div class="row" style="margin:0.2em 0em;">
                                <div class="alert alert-info">
                                 <pre class="pre-scrollable">
<%=pregunta.getPregunta()%>
								</pre>      
                                </div>
                                <div class="alert alert-success">
                                <%
                                if(pregunta.getA()!=null){
                                %>
                                    <input type="text" disabled value="<%=pregunta.getA()%>" class="form-control text-center">
                                <%
                                }if(pregunta.getB()!=null){
                                %>
                                    <input type="text" disabled value="<%=pregunta.getB()%>" class="form-control text-center">
                                  <%
                                }if(pregunta.getC()!=null){
                                %>
                                    <input type="text" disabled value="<%=pregunta.getC()%>" class="form-control text-center">
                                  <%
                                }if(pregunta.getD()!=null){
                                %>
                                    <input type="text" disabled value="<%=pregunta.getD()%>" class="form-control text-center">
                                <%
                                }if(pregunta.getE()!=null){
                                %>
                                    <input type="text" disabled value="<%=pregunta.getE()%>" class="form-control text-center">
                                <%} %>
                            </div>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                          </div>
                        </div>
                      </div>
                    </div><!-- fin modal -->
			        </td>
			      </tr>	
			      <%
			      contador++;
			    	}
			      %>	     
			    </tbody>
			  </table>
				</div><!-- fin table responsive -->
				
			</div><!-- fin panel body -->
			</div><!-- fin panel-default -->
                 
         </div><!-- fin col-md-10 -->
        </div><!-- fin del row -->
        <%} %>
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
     	

			
		</div><!--fin container-fluid-->
	</body>
</html>