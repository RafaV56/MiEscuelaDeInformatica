<%
	String barra=(String)session.getAttribute("barra");//para identificar cual es el link local
	String nick=(String)session.getAttribute("nickUsuario");//para identificar el nick del usuario	
	String email=(String)session.getAttribute("email");//para identificar el nick del usuario	
	String contrasena=(String)session.getAttribute("contrasena");//para identificar el nick del usuario	
%>
 <nav class="navbar navbar-inverse">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>                        
          </button>
          <a class="navbar-brand" href="<%=barra.equals("Welcome")?"#":"Welcome"%>">Mi escuela de informática</a>
        </div><!-- Fin del navbar-header -->
        <div>
          <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
              <li><a href="<%=barra.equals("Java")?"#":"Java"%>">Java</a></li>
              <li><a href="<%=barra.equals("Css")?"#":"Css"%>">CSS</a></li>
              <li><a href="<%=barra.equals("Sql")?"#":"Sql"%>">SQL</a></li>
            </ul>
            <%
            	//si hay un usuario indentificado mostramos su barra de perfil
            	if(nick!=null){
            %>
            <ul class="nav navbar-nav navbar-right" style="margin-right:0.3em;" >
		      <li class="dropdown">
				  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-education"></span> <%=nick%>
				  <span class="caret"></span></a>
				  <ul class="dropdown-menu alert-warning">
				    <li><a href="CerrarSesion" class="text-center"><i class="fa fa-power-off" style="color:#ff4a4a;"></i> Cerrar sesión</a></li>
				  </ul>
		      </li>
		      <li>
		      	<a href="EditarPerfil"><span class="glyphicon glyphicon-log-in"></span> Perfil</a>
		      </li>
		    </ul>
            <%
            	//Pregunta para saber si viene de test o de registrar o de indentificar, si es así no se pintan los botones
            	}else if(!barra.equals("registrar")){
            %>
             <ul class="nav navbar-nav navbar-right">
		        <li>
		        	<form action="Registrar" method="post">
		        		<input type="submit" value="Registrate" class="btn btn-default navbar-btn">
		        	</form>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" >
		           <span class="glyphicon glyphicon-user"></span> Login &nbsp;
		          </a>
		          <ul class="dropdown-menu">
		            <li style="padding: 1em 2em;">
		            <!-- formulario para identificar al usuario -->
		            <form method="post" action="Identificar">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email" class="form-control" id="emailUsuario" placeholder="Email" name="emailUsuario" maxlength="50" value="<%=email!=null?email:""%>">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Contraseña</label>
					    <input type="password" class="form-control" id="contrasena" placeholder="Contraseña" name="contrasena" maxlength="10" value="<%=contrasena!=null?contrasena:""%>">
					  </div>
					  <div class="checkbox">
					    <label>
					      <input type="checkbox" name="recuerdame"> Recuerdame
					    </label>
					  </div>
					  <button type="submit" class="btn btn-default" id="enviarDatos">Enviar</button>
					</form>
		            </li>
		          </ul>
		        </li>
		      </ul>
		      <%} %>
          </div><!-- Fin del nav nav-bar -->
        </div><!-- Fin myNavBar -->
    </nav>