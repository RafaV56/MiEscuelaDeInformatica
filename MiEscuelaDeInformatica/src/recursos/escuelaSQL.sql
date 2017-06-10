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
 ('alumno@luisvives.com','java-identificadores','n'),
 ('alumno@luisvives.com','java-variables','n'),
 ('rafael_v56@hotmail.com','java-identificadores','s'),
 ('rafael_v56@hotmail.com','java-tipos_de_datos','s'),
 ('rafael_v56@hotmail.com','java-variables','n');
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
 ('java-identificadores','<div>Un identificador en Java puede ser cualquier combinación de letras y números</div><div>&nbsp;(es decir, un&nbsp;<span style=\"font-size: 1em;\">identificador<span style=\"color: rgb(0, 0, 255);\"> alfanumérico</span>), siempre y cuando se empiece por una letra y no un número.</span></div>','<span style=\"font-weight: bold;\">¿Es correcta la afirmación?</span>','No','Si','No siempre',NULL,NULL,'b'),
 ('java-identificadores','String &nbsp;<span style=\"color: rgb(0, 255, 0);\">3nombre;</span>','<span style=\"font-family: &quot;courier new&quot;, monospace; font-weight: bold;\">¿El identificar es válido?</span>','Si','No','Es válido pero muy corto',NULL,NULL,'b'),
 ('java-identificadores','<p><span style=\"font-size: xx-large;\">int <span style=\"color: rgb(0, 0, 255);\">final</span>=5;</span></p>','<span style=\"font-weight: bold; font-style: italic;\">¿Es correcto el identificador?</span>','Si','No, la palabra es reservada por el lenguaje',NULL,NULL,'Si, el entero tiene valor de 5','b'),
 ('java-variables','<div><span style=\"font-size: xx-large; font-weight: bold;\">int <span style=\"color: rgb(0, 0, 255);\">x</span>, y;</span></div><div><span style=\"font-size: xx-large; font-weight: bold;\"><br></span></div><div><span style=\"font-size: xx-large; font-weight: bold;\">y=<span style=\"color: rgb(0, 0, 255);\">x</span>+1;&nbsp;</span></div>','<span style=\"font-size: large; font-weight: bold;\">&nbsp;¿Cuánto vale x?</span>','X no tiene valor',NULL,'Vale 0 \"Cero\"',NULL,NULL,'a'),
 ('java-variables','<span style=\"font-size: xx-large; color: rgb(0, 0, 255);\">float mas, menos, igual;</span>','<span style=\"font-family: &quot;courier new&quot;, monospace; font-size: large; font-weight: bold;\">¿ Es correcta la asignación las variables, mas, menos, igual?</span>',NULL,'Si','No',NULL,NULL,'b'),
 ('java-tipos_de_datos','<span style=\"font-size: xx-large;\"><span style=\"color: rgb(255, 0, 0);\">byte</span> unByte=-129;</span>','<span style=\"font-size: x-large; font-weight: bold;\">¿ El valor -129 es soportado por un tipo primitivo<span style=\"color: rgb(0, 0, 255);\"> byte</span>?</span>','Si','No ',NULL,NULL,NULL,'b'),
 ('java-tipos_de_datos','<span style=\"font-size: xx-large;\"><span style=\"color: rgb(0, 0, 255);\">boolean</span> unBoleano=true;</span>','<span style=\"font-weight: bold; font-size: x-large; color: rgb(0, 0, 0);\">¿Está bien construida la sentencia?</span>','Si, un tipo boolean soporta true y false;','No, un tipo boolean solo soporta caracteres',NULL,NULL,NULL,'a');
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
 ('rafael_v56@hotmail.com','alumno@luisvives.com');
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
 ('java-identificadores','rafael_v56@hotmail.com'),
 ('java-tipos_de_datos','rafael_v56@hotmail.com'),
 ('java-variables','rafael_v56@hotmail.com');
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
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Usuarios de la aplicación';

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`email`,`nombre`,`edad`,`nick`,`contrasena`) VALUES 
 ('alumno@luisvives.com','Alumno',20,'alumnoDAW','555'),
 ('rafael_v56@hotmail.com','Rafael',33,'Admin Escuela','555');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
