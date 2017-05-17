<%
	String barra=(String)session.getAttribute("barra");//para identificar cual es el link local
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
              <li><a href="<%=barra.equals("CSS")?"#":"CSS"%>">CSS</a></li>
              <li><a href="<%=barra.equals("SQL")?"#":"SQL"%>">SQL</a></li>
            </ul>
            <%
            	//Pregunta para saber si viene de test o de registrar, si es así no se pintan los botones
            	if(!barra.equals("registrar") && !barra.equals("test")){
            %>
             <ul class="nav navbar-nav navbar-right">
		        <li>
		        	<form action="Registrar" method="post">
		        		<input type="submit" value="Registrate" class="btn btn-default navbar-btn">
		        	</form>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
		           <span class="glyphicon glyphicon-user"></span> Login &nbsp;
		          </a>
		          <ul class="dropdown-menu">
		            <li style="padding: 1em 2em;">
		            <!-- formulario para identificar al usuario -->
		            <form method="post" action="Identificar">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email" class="form-control" id="emailUsuario" placeholder="Email" name="emailUsuario" maxlength="50">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Contraseña</label>
					    <input type="password" class="form-control" id="contrasena" placeholder="Contraseña" name="contrasena" maxlength="10">
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