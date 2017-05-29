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
 ('rafael@hotmail.com','java-identificadores','n');
/*!40000 ALTER TABLE `hacer_test` ENABLE KEYS */;


--
-- Definition of table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
CREATE TABLE `preguntas` (
  `nombre_test` varchar(50) DEFAULT NULL,
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
 ('java-identificadores','soy el codigo de ejemplo','soy la pregunta3','a','b','c','d','e','b');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;


--
-- Definition of table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`nombre`) VALUES 
 ('java-identificadores'),
 ('java-operadores'),
 ('java:basico'),
 ('java:operadores'),
 ('sql-definicion datos');
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
 ('carlos@yo.com','Carlos',21,'carlosguay2','555'),
 ('jabvi@hhh.conm','javi',18,'morenito','22'),
 ('javi@maroto.com','javi',28,'moreno','admin'),
 ('pepe@ya-com.com','pepe',55,'pepeSoyyo','44'),
 ('rafael@hotmail.com','Rafael',32,'Prueba............................................','admin'),
 ('rafael@hotmail.coml','rafa',22,'admin','admin'),
 ('rafaeldfdfd@hotmail.com','rafae',22,'admin','admin'),
 ('rafaelvelasquez@gmail.com','Pedro',25,'PedritoCrack','123'),
 ('rafael_v55@hotmail.com','rasrd',22,'admin','admin'),
 ('rafael_v56@hotmail.com','rafa',22,'admin','admin'),
 ('rafaesssssl@hotmail.com','rafa',22,'admin','admin'),
 ('SandraWE@aboattime.com','Sandra ',18,'SandraGuapa','5555'),
 ('zrafael@hotmail.com','admin',22,'admin','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
