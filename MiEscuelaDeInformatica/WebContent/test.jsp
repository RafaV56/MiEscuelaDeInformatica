<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        
                  </p>
                 
       <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Test Básico</button>

                    <!-- Modal -->
                    <div class="modal fade" id="myModal" role="dialog">
                      <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color:rgba(255,0,0,1);">Test Básico</h4>
                          </div>
                          <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-6 alert alert-info">
                                                                        <pre class="pre-scrollable">
public class Indentificadores {

public static void main(String[] args) {
<span style="color:green;">String x1</span>;
}

}

</pre>
                                    
                                    

                                </div>
                                <div class="col-sm-6 alert alert-success">
                                    <input type="text" disabled value="String 1x;   ¿Es correcto?" class="form-control text-center">
                                    <input name="" type="button" value="Si" class="btn btn-info form-control">
                                    <input name="" type="button" value="No" class="btn btn-info form-control">
                                </div>
                            </div>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    
                 </p>
     	<!-- Pie de página -->
     	<%@include file="generales/piePagina.html" %>
     	<!-- ------------------------------------ -->
			
		</div><!--fin container-fluid-->
	</body>
</html>