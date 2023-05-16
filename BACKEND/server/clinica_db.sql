-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: bbdd
-- Tiempo de generación: 17-05-2022 a las 16:52:14
-- Versión del servidor: 8.0.27
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: 'Clinica_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Paciente`
--
USE clinica_db;
CREATE TABLE `paciente` (
  `dni` varchar(13) NOT NULL PRIMARY KEY,
  `nombrePaciente` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fnac` date NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



--
-- Estructura de tabla para la tabla `Tratamiento`
--

CREATE TABLE `tratamiento` (
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `precio` float NOT NULL,
  `cobrado` boolean NOT NULL,
  `dniPaciente` varchar(13) NOT NULL,
  FOREIGN KEY (`dniPaciente`) REFERENCES `Paciente`(`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



--
-- Volcado de datos para las tablas.
--

-- INSERT INTO Paciente
INSERT INTO Paciente (nombrePaciente, apellidos, dni, fnac, telefono, email)
VALUES ('SOS', 'Proyecto', '12345678A', '2023-05-14', '123456789', 'sos@proyecto.com');

-- INSERT INTO Tratamiento
INSERT INTO Tratamiento (codigo, descripcion, fecha, precio, cobrado, dniPaciente)
VALUES ('T01', 'Altas dosis de cafeína', '2023-05-14', 100.00, 1, '12345678A');

COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
