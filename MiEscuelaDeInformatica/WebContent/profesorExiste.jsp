<%@page import="domain.Profesor"%>
<%@page import="service.ServiceProfesor"%>
<%@page import="domain.Usuario"%>
<%@page import="exceptions.DomainException"%>
<%@page import="exceptions.ServiceException"%>
<%@page import="service.ServiceUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	//recupero el parametro enviado desde el js. que envia parametro name
	String email=request.getParameter("name");
	ServiceProfesor serviceProfesor=null;
	Profesor profe=null;
	
	String resultado="El Profesor con email: "+email+" exite";
	try{
		serviceProfesor=new ServiceProfesor();
		profe=serviceProfesor.recuperarProfesor(Usuario.crearUsuario(email));
		if(profe==null){
			throw new ServiceException("El profesor no existe");
		}	
	}catch(ServiceException e){
		resultado=e.getMessage();
	}catch(DomainException e){
		resultado="El email del profesor no es correcto";		
	}
	
	if(resultado.equals("El profesor no existe")){
%>
	<h2 class="alert alert-danger text-center"><i class="fa fa-info-circle fa-2"></i> <%=resultado%></h2>
<% }else if(resultado.equals("El email del profesor no es correcto")){ %>
	<h2 class="alert alert-warning text-center"><i class="fa fa-times fa-2"></i> <%=resultado%></h2>
<%}else{%>
	<h2 class="alert alert-success text-center"><i class="fa fa-check fa-2"></i> <%=resultado%></h2>
<%}%>