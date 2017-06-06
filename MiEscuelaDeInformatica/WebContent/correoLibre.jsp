<%@page import="domain.Usuario"%>
<%@page import="exceptions.DomainException"%>
<%@page import="exceptions.ServiceException"%>
<%@page import="service.ServiceUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String email=request.getParameter("name");
	ServiceUsuario serviceUsuario=null;
	Usuario usu=null;
	
	String resultado="Usuario disponible";
	try{
		serviceUsuario=new ServiceUsuario();
		usu=serviceUsuario.recuperarUsuario(Usuario.crearUsuario(email));
		if(usu!=null){
			throw new ServiceException("El email ya está en uso");
		}	
	}catch(ServiceException e){
		resultado=e.getMessage();
	}catch(DomainException e){
		resultado="El email no es correcto";		
	}
	
	if(resultado.equals("El email ya está en uso")){
%>
	<h2 class="alert alert-danger text-center"><i class="fa fa-info-circle fa-2"></i> <%=resultado%></h2>
<% }else if(resultado.equals("El email no es correcto")){ %>
	<h2 class="alert alert-warning text-center"><i class="fa fa-times fa-2"></i> <%=resultado%></h2>
<%}else{%>
	<h2 class="alert alert-success text-center"><i class="fa fa-check fa-2"></i> <%=resultado%></h2>
<%}%>