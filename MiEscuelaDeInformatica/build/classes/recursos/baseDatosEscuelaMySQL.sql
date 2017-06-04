-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.24


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema escuela
--

CREATE DATABASE IF NOT EXISTS escuela;
USE escuela;

--
-- Definition of table `hacer_test`
--

DROP TABLE IF EXISTS `hacer_test`;
CREATE TABLE `hacer_test` (
  `email` varchar(50) NOT NULL DEFAULT '',
  `nombre_test` varchar(50) NOT NULL DEFAULT '',
  `superado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`email`,`nombre_test`),
  KEY `fk_hacer_test_id_test` (`nombre_test`),
  CONSTRAINT `fk_hacer_test_id_test` FOREIGN KEY (`nombre_test`) REFERENCES `test` (`nombre`),
  CONSTRAINT `fk_hacer_test_email` FOREIGN KEY (`email`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hacer_test`
--

/*!40000 ALTER TABLE `hacer_test` DISABLE KEYS */;
INSERT INTO `hacer_test` (`email`,`nombre_test`,`superado`) VALUES 
 ('carlos@yo.com','java-identificadores','n'),
 ('carlos@yo.com','java-operadores','s'),
 ('carlos@yo.com','sql-definicion datos','s'),
 ('rafael@hotmail.com','java-identificadores','n'),
 ('rafael@hotmail.com','java-operadores','s'),
 ('rafael@hotmail.com','sql-definicion datos','n'),
 ('rafael@hotmail.coml','java-identificadores','s'),
 ('rafael@hotmail.coml','java-operadores','n'),
 ('SandraWE@aboattime.com','java-identificadores','n'),
 ('SandraWE@aboattime.com','sql-definicion datos','n');
/*!40000 ALTER TABLE `hacer_test` ENABLE KEYS */;


--
-- Definition of table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
CREATE TABLE `preguntas` (
  `nombre_test` varchar(50) NOT NULL,
  `codigo_ejemplo` varchar(2000) DEFAULT NULL,
  `pregunta` varchar(250) NOT NULL,
  `a` varchar(250) DEFAULT NULL,
  `b` varchar(250) DEFAULT NULL,
  `c` varchar(250) DEFAULT NULL,
  `d` varchar(250) DEFAULT NULL,
  `e` varchar(250) DEFAULT NULL,
  `correcta` varchar(1) NOT NULL,
  KEY `FK_preguntas_test` (`nombre_test`),
  CONSTRAINT `FK_preguntas_test` FOREIGN KEY (`nombre_test`) REFERENCES `test` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preguntas`
--

/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` (`nombre_test`,`codigo_ejemplo`,`pregunta`,`a`,`b`,`c`,`d`,`e`,`correcta`) VALUES 
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta','a','b','c','d','e','b'),
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta1','a','b','c','d','e','b'),
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta2','a','b','c','d','e','b'),
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta3','a','b','c','d','e','b'),
 ('java-operadores','soy el codigo de ejemplo','soy la pregunta3','a','b','c','d','e','b'),
 ('java-operadores','soy el codigo de ejemplo','soy la pregunta2','a','b','c','d','e','b'),
 ('java-operadores','soy el codigo de ejemplo','soy la pregunta2','a','b',NULL,NULL,NULL,'b'),
 ('java-operadores',NULL,'soy la pregunta2','a','b',NULL,NULL,NULL,'b'),
 ('sql-definicion datos',NULL,'soy la pregunta sql','a','b',NULL,NULL,NULL,'b'),
 ('sql-definicion datos',NULL,'soy la pregunta sql2','a','b',NULL,NULL,NULL,'b'),
 ('sql-definicion datos',NULL,'soy la pregunta sql','a','b',NULL,NULL,NULL,'b'),
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta3','a','b','c','d','e','b'),
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta3','a','b','c','d','e','b'),
 ('java-operadores','codigo ejemplo','pregunta','a','b','c','d','e','c'),
 ('5','<div><span class=\"Apple-tab-span\" style=\"white-space:pre\">		</span>request.setAttribute(<span style=\"background-color: rgb(0, 0, 255);\">\"respuesta\", \"La pregunta se añadio correctamente\"</span>);</div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">		</span>} catch (DomainException e) {</div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">			</span>request.setAttribute(\"error\", e.getMessage());</div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">		</span>} catch (ServiceException e) {</div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">		<span style=\"font-weight: bold;\">	</span></span><span style=\"font-weight: bold;\">request.setAttribute(\"error\", e.getMessage());</span></div>','pregunta de ejemplo','respueta a','Respuesta b',NULL,NULL,NULL,'a'),
 ('java-operadores','codigo ejemplo','pregunta','a','b','c','d','e','c'),
 ('5','<div><span style=\"color: rgb(255, 0, 0);\">&nbsp; &nbsp; public InsertarPregunta() {</span></div><div>&nbsp; &nbsp; &nbsp; &nbsp; super();</div><div>&nbsp; &nbsp; &nbsp; &nbsp; // TODO Auto-generated constructor stub</div><div>&nbsp; &nbsp; }</div><div><br></div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span><span style=\"color: rgb(61, 133, 198);\">/**</span></div><div><span style=\"color: rgb(61, 133, 198);\"><span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span> * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)</span></div><div><span style=\"color: rgb(61, 133, 198);\"><span class=\"Apple-tab-span\" style=\"white-space: pre;\">	</span> */</span></div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span>protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {</div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">		</span>doPost(request, response);</div><div><span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span>}</div>','¿Que tipo de archivos es?',NULL,NULL,NULL,'lllopjo','ppp','d');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;


--
-- Definition of table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
CREATE TABLE `profesores` (
  `profesor` varchar(50) NOT NULL DEFAULT '',
  `alumno` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`profesor`,`alumno`),
  KEY `fk_alumno` (`alumno`),
  CONSTRAINT `fk_profesor` FOREIGN KEY (`profesor`) REFERENCES `usuario` (`email`),
  CONSTRAINT `fk_alumno` FOREIGN KEY (`alumno`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profesores`
--

/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` (`profesor`,`alumno`) VALUES 
 ('rafael@hotmail.com','carlos@yo.com'),
 ('carlos@yo.com','rafael@hotmail.com'),
 ('SandraWE@aboattime.com','rafael@hotmail.com'),
 ('rafael@hotmail.com','rafael@hotmail.coml');
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;


--
-- Definition of table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `creado_por` varchar(50) NOT NULL,
  PRIMARY KEY (`nombre`),
  KEY `FK_test` (`creado_por`),
  CONSTRAINT `FK_test` FOREIGN KEY (`creado_por`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`nombre`,`creado_por`) VALUES 
 ('java-identificadores','Aplicación'),
 ('java-operadores','Aplicación'),
 ('java:basico','Aplicación'),
 ('java:operadores','Aplicación'),
 ('sql-definicion datos','Aplicación'),
 ('5','carlos@yo.com'),
 ('6','carlos@yo.com'),
 ('test','carlos@yo.com');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `email` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `edad` int(3) unsigned NOT NULL,
  `nick` varchar(50) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `profesor` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Usuarios de la aplicación';

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`email`,`nombre`,`edad`,`nick`,`contrasena`,`profesor`) VALUES 
 ('Aplicación','miEscuela',7,'escuela','escuela',NULL),
 ('carlos@yo.com','Carlos',22,'carlosguay2','555',NULL),
 ('jabvi@hhh.conm','javi',18,'morenito','22',NULL),
 ('javi@maroto.com','javi',28,'moreno','admin',NULL),
 ('pepe@ya-com.com','pepe',55,'pepeSoyyo','44',NULL),
 ('rafael@hotmail.com','Rafael',32,'Prueba............................................','admin',NULL),
 ('rafael@hotmail.coml','rafa',22,'admin','admin',NULL),
 ('rafaeldfdfd@hotmail.com','rafae',22,'admin','admin',NULL),
 ('rafaelvelasquez@gmail.com','Pedro',25,'PedritoCrack','123',NULL),
 ('rafael_v55@hotmail.com','rasrd',22,'admin','admin',NULL),
 ('rafael_v56@hotmail.com','rafa',22,'admin','admin',NULL),
 ('rafaesssssl@hotmail.com','rafa',22,'admin','admin',NULL),
 ('SandraWE@aboattime.com','Sandra ',18,'SandraGuapa','5555',NULL),
 ('zrafael@hotmail.com','admin',22,'admin','admin',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
