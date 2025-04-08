-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2025 a las 16:17:28
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pokemones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `id_entrenador` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `pokedollares` int(11) DEFAULT 1000
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mochila`
--

CREATE TABLE `mochila` (
  `id_entrenador` int(11) NOT NULL,
  `id_objeto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id_movimiento` int(11) NOT NULL,
  `nom_movimiento` varchar(20) DEFAULT NULL,
  `nivel_aprendizaje` int(11) NOT NULL,
  `pp_max` int(11) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL CHECK (`tipo` in ('ataque','estado','mejora')),
  `potencia` int(11) DEFAULT NULL,
  `tipo_mov` enum('AGUA','LUCHA','NORMAL','FUEGO','HIELO','BICHO','DRAGON','ELÉCTRICO','FANTASMA','HIELO','PLANTA','PSIQUICO','ROCA','TIERRA','VENENO','VOLADOR') DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `turnos` int(11) DEFAULT NULL,
  `mejora` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id_movimiento`, `nom_movimiento`, `nivel_aprendizaje`, `pp_max`, `tipo`, `potencia`, `tipo_mov`, `estado`, `turnos`, `mejora`, `num`) VALUES
(1, 'Burbuja', 1, 30, 'ataque', 40, 'AGUA', NULL, NULL, NULL, 1),
(2, 'Cascada', 37, 15, 'ataque', 80, 'AGUA', NULL, NULL, NULL, 1),
(3, 'Hidrobomba', 42, 5, 'ataque', 110, 'AGUA', NULL, NULL, NULL, 1),
(4, 'Martillazo', 35, 10, 'ataque', 100, 'AGUA', NULL, NULL, NULL, 1),
(5, 'Pistola Agua', 15, 25, 'ataque', 40, 'AGUA', NULL, NULL, NULL, 1),
(6, 'Rayo Burbuja', 25, 20, 'ataque', 65, 'AGUA', NULL, NULL, NULL, 1),
(7, 'Refugio', 28, 40, 'mejora', NULL, 'AGUA', NULL, NULL, 'sube defensa', 1),
(8, 'Surf', 0, 15, 'ataque', 100, 'AGUA', NULL, NULL, NULL, 1),
(9, 'Tenaza', 23, 15, 'ataque', 35, 'AGUA', 'apresado', 5, NULL, 1),
(10, 'Chupavidas', 1, 10, 'ataque', 80, 'BICHO', NULL, NULL, NULL, 1),
(11, 'Disparo Demora', 1, 40, 'mejora', NULL, 'BICHO', NULL, NULL, 'baja velocidad', 1),
(12, 'Doble Ataque', 20, 20, 'ataque', 25, 'BICHO', NULL, NULL, NULL, 1),
(13, 'Pin misil', 30, 20, 'ataque', 25, 'BICHO', NULL, NULL, NULL, 1),
(14, 'Furia Dragón', 25, 10, 'ataque', NULL, 'DRAGON', NULL, NULL, NULL, 1),
(15, 'Impactrueno', 1, 30, 'ataque', 40, 'ELÉCTRICO', 'paralizado', NULL, NULL, 1),
(16, 'Onda trueno', 10, 20, 'estado', NULL, 'ELÉCTRICO', 'paralizado', NULL, NULL, 1),
(17, 'Pueño Trueno', 43, 15, 'ataque', 75, 'ELÉCTRICO', NULL, NULL, NULL, 1),
(18, 'Rayo', 26, 15, 'ataque', 90, 'ELÉCTRICO', 'paralizado', NULL, NULL, 1),
(19, 'Trueno', 43, 10, 'ataque', 110, 'ELÉCTRICO', 'paralizado', NULL, NULL, 1),
(20, 'Lenguetazo', 18, 30, 'ataque', 30, 'FANTASMA', 'paralizado', NULL, NULL, 1),
(21, 'Rayo Confuso', 21, 10, 'estado', NULL, 'FANTASMA', 'confuso', NULL, NULL, 1),
(22, 'Tinieblas', 10, 15, 'ataque', NULL, '', NULL, NULL, NULL, 1),
(23, 'Ascuas', 9, 25, 'ataque', 40, 'FUEGO', NULL, NULL, NULL, 1),
(24, 'Giro Fuego', 39, 15, 'ataque', 35, 'FUEGO', 'apresado', 5, NULL, 1),
(25, 'Lanzallamas', 38, 15, 'ataque', 90, 'FUEGO', 'quemado', NULL, NULL, 1),
(26, 'Llamarada', 53, 5, 'ataque', 110, 'FUEGO', 'quemado', NULL, NULL, 1),
(27, 'Puño Fuego', 33, 15, 'ataque', 75, 'FUEGO', 'quemado', NULL, NULL, 1),
(28, 'Neblina', 20, 30, 'mejora', NULL, 'HIELO', NULL, 5, 'evita reducción de e', 1),
(30, 'Niebla', 36, 30, 'mejora', NULL, 'HIELO', NULL, NULL, 'restablece estadisti', 1),
(31, 'Puño Hielo', 38, 15, 'ataque', 75, 'HIELO', 'congelado', 2, NULL, 1),
(32, 'Rayo Aurora', 35, 20, 'ataque', 65, 'HIELO', NULL, NULL, 'bajar el ataque del ', 1),
(33, 'Rayo Hielo', 50, 10, 'ataque', 90, 'HIELO', 'congelado', 2, NULL, 1),
(34, 'Ventisca', 58, 5, 'ataque', 110, 'HIELO', 'congelado', 2, NULL, 1),
(35, 'Contraataque', 53, 20, 'ataque', NULL, 'LUCHA', NULL, NULL, NULL, 1),
(36, 'Doble patada', 12, 30, 'ataque', 30, 'LUCHA', NULL, NULL, NULL, 1),
(37, 'Golpe kárate', 15, 25, 'ataque', 50, 'LUCHA', NULL, NULL, NULL, 1),
(38, 'Patada baja', 9, 20, 'ataque', NULL, 'LUCHA', NULL, NULL, NULL, 1),
(39, 'Patada Giro', 33, 15, 'ataque', 60, 'LUCHA', 'amedrentado', NULL, NULL, 1),
(40, 'Patada Salto', 38, 10, 'ataque', 100, 'LUCHA', NULL, NULL, NULL, 1),
(41, 'Patada Salto Alta', 48, 10, 'ataque', 130, 'LUCHA', NULL, NULL, NULL, 1),
(42, 'Sísmico', 33, 20, 'ataque', NULL, 'LUCHA', NULL, NULL, NULL, 1),
(43, 'Sumisión', 46, 20, 'ataque', 80, 'LUCHA', NULL, NULL, NULL, 1),
(44, 'Afilar', 1, 30, 'mejora', NULL, 'NORMAL', NULL, NULL, 'sube ataque', 1),
(45, 'Anulación', 20, 30, 'ataque', 55, 'NORMAL', NULL, NULL, NULL, 1),
(46, 'Anulación', 14, 20, 'ataque', NULL, 'NORMAL', NULL, NULL, 'impide usar un ataqu', 1),
(47, 'Arañazo', 1, 35, 'ataque', 40, 'NORMAL', NULL, NULL, NULL, 1),
(48, 'Atadura', 15, 20, 'ataque', 15, 'NORMAL', 'apresado', 5, NULL, 1),
(49, 'Ataque Furia', 12, 20, 'ataque', 15, 'NORMAL', NULL, NULL, NULL, 1),
(50, 'Ataque Rápido', 12, 30, 'ataque', 40, 'NORMAL', NULL, NULL, NULL, 1),
(51, 'Atizar', 20, 20, 'ataque', 80, 'NORMAL', NULL, NULL, NULL, 1),
(52, 'Autodestrucción', 21, 5, 'ataque', 200, 'NORMAL', 'debilitado', NULL, NULL, 1),
(53, 'Beso Amoroso', 1, 10, 'estado', NULL, 'NORMAL', 'dormido', 5, NULL, 1),
(54, 'Bomba huevo', 31, 10, 'ataque', 100, 'NORMAL', NULL, NULL, NULL, 1),
(55, 'Bomba sónica', 21, 20, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(56, 'Bombardeo', 1, 20, 'ataque', 15, 'NORMAL', NULL, NULL, NULL, 1),
(57, 'Cabezazo', 35, 10, 'ataque', 130, 'NORMAL', NULL, NULL, NULL, 1),
(58, 'Canto', 1, 15, 'ataque', NULL, 'NORMAL', 'dormido', NULL, NULL, 1),
(59, 'Chirrido', 31, 40, 'mejora', NULL, 'NORMAL', NULL, NULL, 'baja la defensa', 1),
(60, 'Clavo cañón', 50, 15, 'ataque', 20, 'NORMAL', NULL, NULL, NULL, 1),
(61, 'Constricción', 1, 20, 'ataque', 15, 'NORMAL', 'apresado', 5, NULL, 1),
(62, 'Conversión', 1, 30, 'mejora', NULL, 'NORMAL', NULL, NULL, 'copia el tipo del op', 1),
(63, 'Cornada', 8, 25, 'ataque', 65, 'NORMAL', NULL, NULL, NULL, 1),
(64, 'Corte', 0, 30, 'ataque', 50, 'NORMAL', NULL, NULL, NULL, 1),
(65, 'Cuchillada', 30, 20, 'ataque', 70, 'NORMAL', NULL, NULL, NULL, 1),
(66, 'Danza Espada', 35, 20, 'mejora', NULL, 'NORMAL', NULL, NULL, 'sube ataque mucho', 1),
(67, 'Derribo', 30, 20, 'ataque', 90, 'NORMAL', NULL, NULL, NULL, 1),
(68, 'Desarrollo', 34, 20, 'mejora', NULL, 'NORMAL', NULL, NULL, 'sube ataque especial', 1),
(69, 'Deslumbrar', 24, 30, 'estado', NULL, 'NORMAL', 'paralizado', NULL, NULL, 1),
(70, 'Destello', 0, 20, 'mejora', NULL, 'NORMAL', NULL, NULL, 'baja precisión objet', 1),
(71, 'Destructor', 1, 35, 'ataque', 40, 'NORMAL', NULL, NULL, NULL, 1),
(72, 'Día de Pago', 17, 20, 'ataque', 40, 'NORMAL', NULL, NULL, NULL, 1),
(73, 'Doble Bofetón', 18, 10, 'ataque', 15, 'NORMAL', NULL, NULL, NULL, 1),
(74, 'Doble Equipo', 15, 15, 'mejora', NULL, 'NORMAL', NULL, NULL, 'sube la evasión', 1),
(75, 'Doble Filo', 39, 15, 'ataque', 120, 'NORMAL', NULL, NULL, NULL, 1),
(76, 'Explosión', 36, 5, 'ataque', 250, 'NORMAL', 'debilitado', NULL, NULL, 1),
(77, 'Foco Energía', 16, 30, 'mejora', NULL, 'NORMAL', NULL, NULL, 'aumenta índice de cr', 1),
(78, 'Forcejeo', 0, NULL, 'ataque', 50, 'NORMAL', NULL, NULL, NULL, 1),
(79, 'Fortaleza', 1, 30, 'mejora', NULL, 'NORMAL', NULL, NULL, 'sube defensa', 1),
(80, 'Fuerza', 0, 15, 'ataque', 80, 'NORMAL', NULL, NULL, NULL, 1),
(81, 'Furia', 22, 20, 'ataque', 20, 'NORMAL', NULL, NULL, NULL, 1),
(82, 'Golpe cabeza', 10, 15, 'ataque', 70, 'NORMAL', NULL, NULL, NULL, 1),
(83, 'Golpe cuerpo', 23, 15, 'ataque', 85, 'NORMAL', NULL, NULL, NULL, 1),
(84, 'Golpes furia', 10, 15, 'ataque', 85, 'NORMAL', NULL, NULL, NULL, 1),
(85, '043', 1, 40, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(86, 'Guillotina', 25, 5, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(87, 'Hipercolmillo', 14, 15, 'ataque', 80, 'NORMAL', NULL, NULL, NULL, 1),
(88, 'Hiperrayo', 52, 5, 'ataque', 150, 'NORMAL', NULL, NULL, NULL, 1),
(89, 'Látigo', 10, 30, 'estado', NULL, 'NORMAL', 'confuso', 2, NULL, 1),
(90, 'Malicioso', 15, 30, 'estado', NULL, 'NORMAL', 'congelado', 3, NULL, 1),
(91, 'Megapatada', 53, 5, 'ataque', 120, 'NORMAL', NULL, NULL, NULL, 1),
(92, 'Megapuño', 25, 10, 'ataque', 60, 'NORMAL', NULL, NULL, NULL, 1),
(93, 'Meteoros', 26, 20, 'ataque', 60, 'NORMAL', NULL, NULL, NULL, 1),
(94, 'Metrónomo', 31, 10, 'estado', NULL, 'NORMAL', 'toxico', 2, NULL, 1),
(95, 'Mimético', 39, 10, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(96, 'Ovocuración', 10, 5, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(97, 'Pantalla de humo', 13, 20, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(98, 'Perforador', 36, 5, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(99, 'Pisotón', 32, 20, 'ataque', 65, 'NORMAL', NULL, NULL, NULL, 1),
(100, 'Placaje', 1, 35, 'ataque', 40, 'NORMAL', NULL, NULL, NULL, 1),
(101, 'Puño cometa', 1, 15, 'ataque', 18, 'NORMAL', NULL, NULL, NULL, 1),
(102, 'Puño mareo', 25, 10, 'estado', 70, 'NORMAL', 'confuso', 2, NULL, 1),
(103, 'Recuperación', 31, 5, 'estado', NULL, 'NORMAL', 'congelado', 3, NULL, 1),
(104, 'Reducción', 24, 10, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(105, 'Remolino', 25, 10, 'ataque', 60, 'NORMAL', NULL, NULL, NULL, 1),
(106, 'Restricción', 27, 35, 'ataque', 10, 'NORMAL', NULL, NULL, NULL, 1),
(107, 'Rizo defensa', 6, 40, 'estado', NULL, 'NORMAL', 'toxico', 2, NULL, 1),
(108, 'Rugido', 21, 20, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(109, 'Salpicadura', 1, 40, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(110, 'Saña', 22, 10, 'ataque', 120, 'NORMAL', NULL, NULL, NULL, 1),
(111, 'Superdiente', 21, 20, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(112, 'Supersónico', 10, 15, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(113, 'Sustituto', 26, 10, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(114, 'Transformación', 1, 10, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(115, 'Triataque', 1, 10, 'ataque', 80, 'NORMAL', NULL, NULL, NULL, 1),
(116, 'Venganza', 3, 10, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(117, 'Viento cortante', 29, 10, 'ataque', 80, 'PSIQUICO', NULL, NULL, NULL, 1),
(118, 'Absorber', 1, 15, 'estado', NULL, 'NORMAL', 'confuso', 2, NULL, 1),
(119, 'Danza pétalo', 32, 10, 'estado', 120, 'HIELO', 'congelado', 3, NULL, 1),
(120, 'Drenadoras', 7, 10, 'ataque', NULL, 'TIERRA', NULL, NULL, NULL, 1),
(121, 'Espora', 27, 15, 'ataque', NULL, 'PSIQUICO', NULL, NULL, NULL, 1),
(122, 'Hoja afilada', 27, 25, 'ataque', 55, 'ROCA', NULL, NULL, NULL, 1),
(123, 'Látigo cepa', 13, 25, 'estado', 45, 'VENENO', 'toxico', 2, NULL, 1),
(124, 'Megaagotar', 21, 15, 'ataque', 40, 'LUCHA', NULL, NULL, NULL, 1),
(125, 'Paralizador', 14, 30, 'ataque', NULL, 'DRAGON', NULL, NULL, NULL, 1),
(126, 'Rayo solar', 48, 10, 'ataque', 120, 'FUEGO', NULL, NULL, NULL, 1),
(127, 'Somnífero', 41, 15, 'ataque', NULL, 'FANTASMA', NULL, NULL, NULL, 1),
(128, 'Agilidad', 35, 30, 'ataque', NULL, 'LUCHA', NULL, NULL, NULL, 1),
(129, 'Amnesia', 1, 20, 'ataque', NULL, 'BICHO', NULL, NULL, NULL, 1),
(130, 'Barrera', 1, 20, 'ataque', NULL, 'PSIQUICO', NULL, NULL, NULL, 1),
(131, 'Comesueños', 35, 15, 'estado', 100, 'NORMAL', 'confuso', 2, NULL, 1),
(132, 'Confusión', 12, 25, 'estado', 50, 'HIELO', 'congelado', 3, NULL, 1),
(133, 'Descanso', 29, 10, 'ataque', NULL, 'TIERRA', NULL, NULL, NULL, 1),
(134, 'Hipnosis', 1, 20, 'ataque', NULL, 'PSIQUICO', NULL, NULL, NULL, 1),
(135, 'Kinético', 1, 15, 'ataque', NULL, 'ROCA', NULL, NULL, NULL, 1),
(136, 'Meditación', 37, 40, 'ataque', NULL, 'ROCA', NULL, NULL, NULL, 1),
(137, 'Pantalla de luz', 50, 30, 'estado', NULL, 'VENENO', 'toxico', 2, NULL, 1),
(138, 'Psicoonda', 13, 15, 'ataque', NULL, 'LUCHA', NULL, NULL, NULL, 1),
(139, 'Psicorrayo', 32, 20, 'ataque', 65, 'DRAGON', NULL, NULL, NULL, 1),
(140, 'Psíquico', 1, 10, 'ataque', 90, 'NORMAL', NULL, NULL, NULL, 1),
(141, 'Reflejo', 42, 20, 'ataque', NULL, 'NORMAL', NULL, NULL, NULL, 1),
(142, 'Teletransporte', 1, 20, 'ataque', NULL, 'LUCHA', NULL, NULL, NULL, 1),
(143, 'Avalancha', 21, 10, 'ataque', 75, 'FUEGO', NULL, NULL, NULL, 1),
(144, 'Lanzarrocas', 1, 15, 'ataque', 50, 'FANTASMA', NULL, NULL, NULL, 1),
(145, 'Mordisco', 22, 25, 'ataque', 60, 'LUCHA', NULL, NULL, NULL, 1),
(146, 'Ataque arena', 5, 15, 'ataque', NULL, 'BICHO', NULL, NULL, NULL, 1),
(147, 'Excavar', 30, 10, 'ataque', 80, 'PSIQUICO', NULL, NULL, NULL, 1),
(148, 'Fisura', 49, 5, 'estado', NULL, 'NORMAL', 'confuso', 2, NULL, 1),
(149, 'Huesomerang', 43, 10, 'ataque', 50, 'TIERRA', NULL, NULL, NULL, 1),
(150, 'Terremoto', 46, 10, 'ataque', 100, 'PSIQUICO', NULL, NULL, NULL, 1),
(151, 'Ácido', 38, 30, 'ataque', 40, 'ROCA', NULL, NULL, NULL, 1),
(152, 'Tornado', 28, 35, 'ataque', 40, 'ROCA', NULL, NULL, NULL, 1),
(153, 'Vuelo', 49, 15, 'estado', 90, 'VENENO', 'toxico', 2, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento_pokemon`
--

CREATE TABLE `movimiento_pokemon` (
  `id_pokemon` int(11) NOT NULL,
  `id_movimiento` int(11) NOT NULL,
  `pp_actuales` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto`
--

CREATE TABLE `objeto` (
  `id_objeto` int(11) NOT NULL,
  `num_objeto` varchar(50) DEFAULT NULL,
  `ataque` double(3,2) DEFAULT NULL,
  `at_especial` double(3,2) DEFAULT NULL,
  `defensa` double(3,2) DEFAULT NULL,
  `def_especial` double(3,2) DEFAULT NULL,
  `velocidad` double(3,2) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `pp_mov` double(3,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `objeto`
--

INSERT INTO `objeto` (`id_objeto`, `num_objeto`, `ataque`, `at_especial`, `defensa`, `def_especial`, `velocidad`, `precio`, `pp_mov`) VALUES
(1, 'PESA', 1.20, NULL, 1.20, NULL, 0.80, 10000, 0.00),
(2, 'PLUMA', NULL, NULL, 0.80, 0.80, 1.30, 10000, 0.00),
(3, 'CHALECO', 0.85, NULL, 1.20, 1.20, 0.85, 10000, 0.00),
(4, 'BASTON', NULL, NULL, NULL, NULL, 0.85, 10000, 1.20),
(5, 'PILAS', NULL, NULL, NULL, 0.70, NULL, 10000, 1.50),
(6, 'ETER', NULL, NULL, NULL, NULL, NULL, 500, 2.00),
(7, 'ANILLO UNICO', 9.99, NULL, NULL, NULL, NULL, 15000, 0.00),
(8, 'POKEBALL', NULL, NULL, NULL, NULL, NULL, 50, 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokedex`
--

CREATE TABLE `pokedex` (
  `num_pokedex` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `IMG_Frontal` varchar(150) DEFAULT NULL,
  `IMG_Trasera` varchar(150) DEFAULT NULL,
  `SONIDO` varchar(150) DEFAULT NULL,
  `NIVEL_EVOLUCION` int(11) NOT NULL,
  `TIPO_1` varchar(20) DEFAULT NULL,
  `TIPO_2` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokedex`
--

INSERT INTO `pokedex` (`num_pokedex`, `nombre`, `IMG_Frontal`, `IMG_Trasera`, `SONIDO`, `NIVEL_EVOLUCION`, `TIPO_1`, `TIPO_2`) VALUES
(1, 'BULBASAUR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\1.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\1.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_1.ogg', 16, 'PLANTA', 'VENENO'),
(2, 'IVYSAUR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\2.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\2.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_2.ogg', 32, 'PLANTA', 'VENENO'),
(3, 'VENUSAUR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\3.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\3.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_3.ogg', 0, 'PLANTA', 'VENENO'),
(4, 'CHARMANDER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\4.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\4.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_4.ogg', 16, 'FUEGO', ''),
(5, 'CHARMELEON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\5.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\5.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_5.ogg', 36, 'FUEGO', ''),
(6, 'CHARIZARD', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\6.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\6.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_6.ogg', 0, 'FUEGO', 'VOLADOR'),
(7, 'SQUIRTLE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\7.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\7.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_7.ogg', 16, 'AGUA', ''),
(8, 'WARTORTLE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\8.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\8.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_8.ogg', 36, 'AGUA', ''),
(9, 'BLASTOISE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\9.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\9.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_9.ogg', 0, 'AGUA', ''),
(10, 'CATERPIE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\10.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\10.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_10.ogg', 7, 'BICHO', ''),
(11, 'METAPOD', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\11.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\11.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_11.ogg', 10, 'BICHO', ''),
(12, 'BUTTERFREE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\12.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\12.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_12.ogg', 0, 'BICHO', 'VOLADOR'),
(13, 'WEEDLE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\13.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\13.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_13.ogg', 7, 'BICHO', 'VENENO'),
(14, 'KAKUNA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\14.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\14.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_14.ogg', 10, 'BICHO', 'VENENO'),
(15, 'BEEDRILL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\15.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\15.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_15.ogg', 0, 'BICHO', 'VENENO'),
(16, 'PIDGEY', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\16.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\16.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_16.ogg', 18, 'NORMAL', 'VOLADOR'),
(17, 'PIDGEOTTO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\17.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\17.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_17.ogg', 36, 'NORMAL', 'VOLADOR'),
(18, 'PIDGEOT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\18.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\18.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_18.ogg', 0, 'NORMAL', 'VOLADOR'),
(19, 'RATTATA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\19.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\19.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_19.ogg', 20, 'NORMAL', ''),
(20, 'RATICATE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\20.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\20.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_20.ogg', 0, 'NORMAL', ''),
(21, 'SPEAROW', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\21.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\21.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_21.ogg', 20, 'NORMAL', 'VOLADOR'),
(22, 'FEAROW', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\22.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\22.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_22.ogg', 0, 'NORMAL', 'VOLADOR'),
(23, 'EKANS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\23.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\23.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_23.ogg', 22, 'VENENO', ''),
(24, 'ARBOK', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\24.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\24.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_24.ogg', 0, 'VENENO', ''),
(25, 'PIKACHU', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\25.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\25.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_25.ogg', 22, 'ELECTRICO', ''),
(26, 'RAICHU', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\26.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\26.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_26.ogg', 0, 'ELECTRICO', ''),
(27, 'SANDSHREW', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\27.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\27.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_27.ogg', 22, 'TIERRA', ''),
(28, 'SANDSLASH', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\28.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\28.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_28.ogg', 0, 'TIERRA', ''),
(29, 'NIDORAN♀', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\29.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\29.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_29.ogg', 16, 'VENENO', ''),
(30, 'NIDORINA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\30.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\30.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_30.ogg', 32, 'VENENO', ''),
(31, 'NIDOQUEEN', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\31.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\31.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_31.ogg', 0, 'VENENO', 'TIERRA'),
(32, 'NIDORAN♂', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\32.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\32.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_32.ogg', 16, 'VENENO', ''),
(33, 'NIDORINO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\33.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\33.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_33.ogg', 32, 'VENENO', ''),
(34, 'NIDOKING', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\34.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\34.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_34.ogg', 0, 'VENENO', 'TIERRA'),
(35, 'CLEFAIRY', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\35.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\35.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_35.ogg', 16, 'HADA', ''),
(36, 'CLEFABLE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\36.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\36.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_36.ogg', 0, 'HADA', ''),
(37, 'VULPIX', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\37.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\37.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_37.ogg', 16, 'FUEGO', ''),
(38, 'NINETALES', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\38.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\38.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_38.ogg', 0, 'FUEGO', ''),
(39, 'JIGGLYPUFF', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\39.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\39.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_39.ogg', 16, 'NORMAL', 'HADA'),
(40, 'WIGGLYTUFF', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\40.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\40.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_40.ogg', 0, 'NORMAL', 'HADA'),
(41, 'ZUBAT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\41.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\41.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_41.ogg', 22, 'VENENO', 'VOLADOR'),
(42, 'GOLBAT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\42.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\42.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_42.ogg', 0, 'VENENO', 'VOLADOR'),
(43, 'ODDISH', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\43.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\43.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_43.ogg', 16, 'PLANTA', 'VENENO'),
(44, 'GLOOM', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\44.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\44.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_44.ogg', 32, 'PLANTA', 'VENENO'),
(45, 'VILEPLUME', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\45.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\45.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_45.ogg', 0, 'PLANTA', 'VENENO'),
(46, 'PARAS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\46.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\46.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_46.ogg', 20, 'BICHO', 'PLANTA'),
(47, 'PARASECT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\47.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\47.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_47.ogg', 0, 'BICHO', 'PLANTA'),
(48, 'VENONAT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\48.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\48.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_48.ogg', 22, 'BICHO', 'VENENO'),
(49, 'VENOMOTH', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\49.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\49.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_49.ogg', 0, 'BICHO', 'VENENO'),
(50, 'DIGLETT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\50.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\50.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_50.ogg', 26, 'TIERRA', ''),
(51, 'DUGTRIO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\51.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\51.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_51.ogg', 0, 'TIERRA', ''),
(52, 'MEOWTH', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\52.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\52.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_52.ogg', 28, 'NORMAL', ''),
(53, 'PERSIAN', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\53.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\53.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_53.ogg', 0, 'NORMAL', ''),
(54, 'PSYDUCK', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\54.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\54.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_54.ogg', 33, 'AGUA', ''),
(55, 'GOLDUCK', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\55.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\55.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_55.ogg', 0, 'AGUA', ''),
(56, 'MANKEY', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\56.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\56.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_56.ogg', 28, 'LUCHA', ''),
(57, 'PRIMEAPE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\57.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\57.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_57.ogg', 0, 'LUCHA', ''),
(58, 'GROWLITHE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\58.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\58.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_58.ogg', 20, 'FUEGO', ''),
(59, 'ARCANINE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\59.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\59.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_59.ogg', 0, 'FUEGO', ''),
(60, 'POLIWAG', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\60.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\60.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_60.ogg', 25, 'AGUA', ''),
(61, 'POLIWHIRL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\61.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\61.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_61.ogg', 36, 'AGUA', ''),
(62, 'POLIWRATH', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\62.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\62.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_62.ogg', 0, 'AGUA', 'LUCHA'),
(63, 'ABRA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\63.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\63.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_63.ogg', 16, 'PSÍQUICO', ''),
(64, 'KADABRA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\64.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\64.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_64.ogg', 32, 'PSÍQUICO', ''),
(65, 'ALAKAZAM', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\65.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\65.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_65.ogg', 0, 'PSÍQUICO', ''),
(66, 'MACHOP', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\66.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\66.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_66.ogg', 28, 'LUCHA', ''),
(67, 'MACHOKE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\67.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\67.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_67.ogg', 36, 'LUCHA', ''),
(68, 'MACHAMP', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\68.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\68.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_68.ogg', 0, 'LUCHA', ''),
(69, 'BELLSPROUT', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\69.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\69.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_69.ogg', 21, 'PLANTA', 'VENENO'),
(70, 'WEEPINBELL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\70.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\70.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_70.ogg', 36, 'PLANTA', 'VENENO'),
(71, 'VICTREEBEL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\71.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\71.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_71.ogg', 0, 'PLANTA', 'VENENO'),
(72, 'TENTACOOL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\72.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\72.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_72.ogg', 30, 'AGUA', 'VENENO'),
(73, 'TENTACRUEL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\73.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\73.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_73.ogg', 0, 'AGUA', 'VENENO'),
(74, 'GEODUDE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\74.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\74.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_74.ogg', 25, 'ROCA', 'TIERRA'),
(75, 'GRAVELER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\75.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\75.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_75.ogg', 35, 'ROCA', 'TIERRA'),
(76, 'GOLEM', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\76.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\76.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_76.ogg', 0, 'ROCA', 'TIERRA'),
(77, 'PONYTA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\77.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\77.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_77.ogg', 40, 'FUEGO', ''),
(78, 'RAPIDASH', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\78.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\78.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_78.ogg', 0, 'FUEGO', ''),
(79, 'SLOWPOKE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\79.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\79.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_79.ogg', 37, 'AGUA', 'PSÍQUICO'),
(80, 'SLOWBRO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\80.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\80.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_80.ogg', 0, 'AGUA', 'PSÍQUICO'),
(81, 'MAGNEMITE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\81.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\81.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_81.ogg', 30, 'ELECTRICO', 'ACERO'),
(82, 'MAGNETON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\82.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\82.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_82.ogg', 0, 'ELECTRICO', 'ACERO'),
(83, 'FARFETCH\'D', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\83.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\83.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_83.ogg', 0, 'NORMAL', 'VOLADOR'),
(84, 'DODUO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\84.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\84.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_84.ogg', 22, 'NORMAL', 'VOLADOR'),
(85, 'DODRIO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\85.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\85.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_85.ogg', 0, 'NORMAL', 'VOLADOR'),
(86, 'SEEL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\86.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\86.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_86.ogg', 34, 'AGUA', 'HIELO'),
(87, 'DEWGONG', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\87.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\87.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_87.ogg', 0, 'AGUA', 'HIELO'),
(88, 'GRIMER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\88.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\88.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_88.ogg', 38, 'VENENO', ''),
(89, 'MUK', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\89.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\89.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_89.ogg', 0, 'VENENO', ''),
(90, 'SHELLDER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\90.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\90.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_90.ogg', 0, 'AGUA', ''),
(91, 'CLOYSTER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\91.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\91.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_91.ogg', 0, 'AGUA', 'HIELO'),
(92, 'GASTLY', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\92.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\92.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_92.ogg', 25, 'FANTASMA', 'VENENO'),
(93, 'HAUNTER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\93.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\93.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_93.ogg', 35, 'FANTASMA', 'VENENO'),
(94, 'GENGAR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\94.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\94.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_94.ogg', 0, 'FANTASMA', 'VENENO'),
(95, 'ONIX', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\95.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\95.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_95.ogg', 0, 'ROCA', 'TIERRA'),
(96, 'DROWZEE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\96.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\96.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_96.ogg', 26, 'PSÍQUICO', ''),
(97, 'HYPNO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\97.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\97.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_97.ogg', 0, 'PSÍQUICO', ''),
(98, 'KRABBY', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\98.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\98.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_98.ogg', 28, 'AGUA', ''),
(99, 'KINGLER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\99.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\99.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_99.ogg', 0, 'AGUA', ''),
(100, 'VOLTORB', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\100.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\100.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_100.ogg', 30, 'ELECTRICO', ''),
(101, 'ELECTRODE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\101.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\101.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_101.ogg', 0, 'ELECTRICO', ''),
(102, 'EXEGGCUTE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\102.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\102.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_102.ogg', 25, 'PLANTA', 'PSÍQUICO'),
(103, 'EXEGGUTOR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\103.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\103.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_103.ogg', 0, 'PLANTA', 'PSÍQUICO'),
(104, 'CUBONE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\104.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\104.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_104.ogg', 28, 'TIERRA', ''),
(105, 'MAROWAK', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\105.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\105.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_105.ogg', 0, 'TIERRA', ''),
(106, 'HITMONLEE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\106.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\106.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_106.ogg', 0, 'LUCHA', ''),
(107, 'HITMONCHAN', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\107.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\107.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_107.ogg', 0, 'LUCHA', ''),
(108, 'LICKITUNG', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\108.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\108.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_108.ogg', 0, 'NORMAL', ''),
(109, 'KOFFING', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\109.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\109.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_109.ogg', 35, 'VENENO', ''),
(110, 'WEEZING', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\110.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\110.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_110.ogg', 0, 'VENENO', ''),
(111, 'RHYHORN', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\111.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\111.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_111.ogg', 42, 'TIERRA', 'ROCA'),
(112, 'RHYDON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\112.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\112.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_112.ogg', 0, 'TIERRA', 'ROCA'),
(113, 'CHANSEY', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\113.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\113.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_113.ogg', 0, 'NORMAL', ''),
(114, 'TANGELA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\114.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\114.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_114.ogg', 0, 'PLANTA', ''),
(115, 'KANGASKHAN', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\115.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\115.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_115.ogg', 0, 'NORMAL', ''),
(116, 'HORSEA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\116.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\116.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_116.ogg', 32, 'AGUA', ''),
(117, 'SEADRA', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\117.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\117.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_117.ogg', 0, 'AGUA', ''),
(118, 'GOLDEEN', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\118.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\118.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_118.ogg', 33, 'AGUA', ''),
(119, 'SEAKING', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\119.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\119.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_119.ogg', 0, 'AGUA', ''),
(120, 'STARYU', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\120.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\120.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_120.ogg', 0, 'AGUA', ''),
(121, 'STARMIE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\121.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\121.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_121.ogg', 0, 'AGUA', 'PSÍQUICO'),
(122, 'MR. MIME', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\122.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\122.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_122.ogg', 0, 'PSÍQUICO', 'HADA'),
(123, 'SCYTHER', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\123.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\123.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_123.ogg', 0, 'BICHO', 'VOLADOR'),
(124, 'JYNX', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\124.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\124.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_124.ogg', 0, 'HIELO', 'PSÍQUICO'),
(125, 'ELECTABUZZ', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\125.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\125.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_125.ogg', 0, 'ELECTRICO', ''),
(126, 'MAGMAR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\126.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\126.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_126.ogg', 0, 'FUEGO', ''),
(127, 'PINSIR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\127.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\127.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_127.ogg', 0, 'BICHO', ''),
(128, 'TAUROS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\128.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\128.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_128.ogg', 0, 'NORMAL', ''),
(129, 'MAGIKARP', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\129.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\129.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_129.ogg', 20, 'AGUA', ''),
(130, 'GYARADOS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\130.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\130.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_130.ogg', 0, 'AGUA', 'VOLADOR'),
(131, 'LAPRAS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\131.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\131.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_131.ogg', 0, 'AGUA', 'HIELO'),
(132, 'DITTO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\132.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\132.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_132.ogg', 0, 'NORMAL', ''),
(133, 'EEVEE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\133.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\133.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_133.ogg', 16, 'NORMAL', ''),
(134, 'VAPOREON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\134.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\134.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_134.ogg', 0, 'AGUA', ''),
(135, 'JOLTEON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\135.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\135.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_135.ogg', 0, 'ELECTRICO', ''),
(136, 'FLAREON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\136.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\136.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_136.ogg', 0, 'FUEGO', ''),
(137, 'PORYGON', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\137.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\137.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_137.ogg', 0, 'NORMAL', ''),
(138, 'OMANYTE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\138.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\138.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_138.ogg', 40, 'AGUA', 'ROCA'),
(139, 'OMASTAR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\139.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\139.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_139.ogg', 0, 'AGUA', 'ROCA'),
(140, 'KABUTO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\140.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\140.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_140.ogg', 40, 'ROCA', 'AGUA'),
(141, 'KABUTOPS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\141.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\141.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_141.ogg', 0, 'ROCA', 'AGUA'),
(142, 'AERODACTYL', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\142.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\142.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_142.ogg', 0, 'ROCA', 'VOLADOR'),
(143, 'SNORLAX', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\143.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\143.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_143.ogg', 0, 'NORMAL', ''),
(144, 'ARTICUNO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\144.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\144.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_144.ogg', 0, 'HIELO', 'VOLADOR'),
(145, 'ZAPDOS', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\145.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\145.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_145.ogg', 0, 'ELECTRICO', 'VOLADOR'),
(146, 'MOLTRES', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\146.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\146.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_146.ogg', 0, 'FUEGO', 'VOLADOR'),
(147, 'DRATINI', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\147.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\147.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_147.ogg', 30, 'DRAGON', ''),
(148, 'DRAGONAIR', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\148.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\148.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_148.ogg', 55, 'DRAGON', ''),
(149, 'DRAGONITE', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\149.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\149.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_149.ogg', 0, 'DRAGON', 'VOLADOR'),
(150, 'MEWTWO', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\150.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\150.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_150.ogg', 0, 'PSÍQUICO', ''),
(151, 'MEW', 'C:\\Multimedia_pokemon\\Pokemon\\Front\\151.png', 'C:\\Multimedia_pokemon\\Pokemon\\Back\\151.png', 'C:\\Multimedia_pokemon\\pokemon sounds 1-151 legaci tipe\\cries_pokemon_legacy_151.ogg', 0, 'PSÍQUICO', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `id_pokemon` int(11) NOT NULL,
  `id_entrenador` int(11) DEFAULT NULL,
  `num_pokedex` int(11) DEFAULT NULL,
  `note` varchar(20) DEFAULT NULL,
  `vitalidad` int(11) NOT NULL,
  `ataque` int(11) NOT NULL,
  `defensa` int(11) NOT NULL,
  `atk_especial` int(11) NOT NULL,
  `def_especial` int(11) NOT NULL,
  `velocidad` int(11) NOT NULL,
  `nivel` int(11) NOT NULL,
  `fertilidad` int(11) DEFAULT 5,
  `sexo` char(1) DEFAULT NULL CHECK (`sexo` in ('h','m','y')),
  `estado` varchar(20) DEFAULT NULL,
  `equipo` int(11) DEFAULT NULL CHECK (`equipo` in (1,2,3)),
  `id_objeto` int(11) DEFAULT NULL,
  `NOMBRE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokemon`
--

INSERT INTO `pokemon` (`id_pokemon`, `id_entrenador`, `num_pokedex`, `note`, `vitalidad`, `ataque`, `defensa`, `atk_especial`, `def_especial`, `velocidad`, `nivel`, `fertilidad`, `sexo`, `estado`, `equipo`, `id_objeto`, `NOMBRE`) VALUES
(1, NULL, 1, NULL, 45, 49, 49, 65, 65, 45, 1, 5, 'H', NULL, NULL, NULL, 'BULBASAUR'),
(2, NULL, 2, NULL, 60, 62, 63, 80, 80, 60, 1, 5, 'H', NULL, NULL, NULL, 'IVYSAUR'),
(3, NULL, 3, NULL, 80, 82, 83, 100, 100, 80, 1, 5, 'H', NULL, NULL, NULL, 'VENUSAUR'),
(4, NULL, 4, NULL, 39, 52, 43, 60, 50, 65, 1, 5, 'H', NULL, NULL, NULL, 'CHARMANDER'),
(5, NULL, 5, NULL, 58, 64, 58, 80, 65, 80, 1, 5, 'H', NULL, NULL, NULL, 'CHARMELEON'),
(6, NULL, 6, NULL, 78, 84, 78, 109, 85, 100, 1, 5, 'H', NULL, NULL, NULL, 'CHARIZARD'),
(7, NULL, 7, NULL, 44, 48, 65, 50, 64, 43, 1, 5, 'H', NULL, NULL, NULL, 'SQUIRTLE'),
(8, NULL, 8, NULL, 59, 63, 80, 65, 81, 58, 1, 5, 'H', NULL, NULL, NULL, 'WARTORTLE'),
(9, NULL, 9, NULL, 79, 83, 100, 85, 105, 78, 1, 5, 'H', NULL, NULL, NULL, 'BLASTOISE'),
(10, NULL, 10, NULL, 45, 30, 35, 20, 20, 45, 1, 5, 'M', NULL, NULL, NULL, 'CATERPIE'),
(11, NULL, 11, NULL, 50, 20, 55, 25, 25, 30, 1, 5, 'M', NULL, NULL, NULL, 'METAPOD'),
(12, NULL, 12, NULL, 60, 45, 50, 90, 80, 70, 1, 5, 'M', NULL, NULL, NULL, 'BUTTERFREE'),
(13, NULL, 13, NULL, 40, 35, 30, 20, 20, 50, 1, 5, 'M', NULL, NULL, NULL, 'WEEDLE'),
(14, NULL, 14, NULL, 45, 25, 50, 25, 25, 35, 1, 5, 'M', NULL, NULL, NULL, 'KAKUNA'),
(15, NULL, 15, NULL, 65, 90, 40, 45, 80, 75, 1, 5, 'M', NULL, NULL, NULL, 'BEEDRILL'),
(16, NULL, 16, NULL, 40, 45, 40, 35, 35, 56, 1, 5, 'M', NULL, NULL, NULL, 'PIDGEY'),
(17, NULL, 17, NULL, 63, 60, 55, 50, 50, 71, 1, 5, 'M', NULL, NULL, NULL, 'PIDGEOTTO'),
(18, NULL, 18, NULL, 83, 80, 75, 70, 70, 101, 1, 5, 'M', NULL, NULL, NULL, 'PIDGEOT'),
(19, NULL, 19, NULL, 30, 56, 35, 25, 35, 72, 1, 5, 'H', NULL, NULL, NULL, 'RATTATA'),
(20, NULL, 20, NULL, 55, 81, 60, 50, 70, 97, 1, 5, 'H', NULL, NULL, NULL, 'RATICATE'),
(21, NULL, 21, NULL, 40, 60, 30, 31, 31, 70, 1, 5, 'M', NULL, NULL, NULL, 'SPEAROW'),
(22, NULL, 22, NULL, 65, 90, 65, 61, 61, 100, 1, 5, 'M', NULL, NULL, NULL, 'FEAROW'),
(23, NULL, 23, NULL, 35, 60, 44, 40, 54, 55, 1, 5, 'H', NULL, NULL, NULL, 'EKANS'),
(24, NULL, 24, NULL, 60, 95, 69, 65, 79, 80, 1, 5, 'H', NULL, NULL, NULL, 'ARBOK'),
(25, NULL, 25, NULL, 35, 55, 40, 50, 50, 90, 1, 5, 'H', NULL, NULL, NULL, 'PIKACHU'),
(26, NULL, 26, NULL, 60, 90, 55, 90, 80, 110, 1, 5, 'H', NULL, NULL, NULL, 'RAICHU'),
(27, NULL, 27, NULL, 50, 75, 85, 20, 30, 40, 1, 5, 'M', NULL, NULL, NULL, 'SANDSHREW'),
(28, NULL, 28, NULL, 75, 100, 110, 45, 55, 65, 1, 5, 'M', NULL, NULL, NULL, 'SANDSLASH'),
(29, NULL, 29, NULL, 55, 47, 52, 40, 40, 41, 1, 5, 'M', NULL, NULL, NULL, 'NIDORAN♀'),
(30, NULL, 30, NULL, 70, 60, 67, 55, 55, 56, 1, 5, 'M', NULL, NULL, NULL, 'NIDORINA'),
(31, NULL, 31, NULL, 90, 92, 87, 75, 85, 76, 1, 5, 'M', NULL, NULL, NULL, 'NIDOQUEEN'),
(32, NULL, 32, NULL, 46, 57, 40, 40, 40, 50, 1, 5, 'H', NULL, NULL, NULL, 'NIDORAN♂'),
(33, NULL, 33, NULL, 61, 72, 57, 55, 55, 65, 1, 5, 'H', NULL, NULL, NULL, 'NIDORINO'),
(34, NULL, 34, NULL, 81, 102, 77, 85, 75, 85, 1, 5, 'H', NULL, NULL, NULL, 'NIDOKING'),
(35, NULL, 35, NULL, 70, 45, 48, 60, 65, 35, 1, 5, 'M', NULL, NULL, NULL, 'CLEFAIRY'),
(36, NULL, 36, NULL, 95, 70, 73, 95, 90, 60, 1, 5, 'M', NULL, NULL, NULL, 'CLEFABLE'),
(37, NULL, 37, NULL, 38, 41, 40, 50, 65, 65, 1, 5, 'M', NULL, NULL, NULL, 'VULPIX'),
(38, NULL, 38, NULL, 73, 76, 75, 81, 100, 100, 1, 5, 'M', NULL, NULL, NULL, 'NINETALES'),
(39, NULL, 39, NULL, 115, 45, 20, 45, 25, 20, 1, 5, 'M', NULL, NULL, NULL, 'JIGGLYPUFF'),
(40, NULL, 40, NULL, 140, 70, 45, 85, 50, 45, 1, 5, 'M', NULL, NULL, NULL, 'WIGGLYTUFF'),
(41, NULL, 41, NULL, 40, 45, 35, 30, 40, 55, 1, 5, 'H', NULL, NULL, NULL, 'ZUBAT'),
(42, NULL, 42, NULL, 75, 80, 70, 65, 75, 90, 1, 5, 'H', NULL, NULL, NULL, 'GOLBAT'),
(43, NULL, 43, NULL, 45, 50, 55, 75, 65, 30, 1, 5, 'H', NULL, NULL, NULL, 'ODDISH'),
(44, NULL, 44, NULL, 60, 65, 70, 85, 75, 40, 1, 5, 'H', NULL, NULL, NULL, 'GLOOM'),
(45, NULL, 45, NULL, 75, 80, 85, 100, 90, 50, 1, 5, 'H', NULL, NULL, NULL, 'VILEPLUME'),
(46, NULL, 46, NULL, 35, 70, 55, 35, 45, 25, 1, 5, 'M', NULL, NULL, NULL, 'PARAS'),
(47, NULL, 47, NULL, 60, 95, 80, 60, 60, 30, 1, 5, 'M', NULL, NULL, NULL, 'PARASECT'),
(48, NULL, 48, NULL, 60, 55, 50, 40, 50, 45, 1, 5, 'H', NULL, NULL, NULL, 'VENONAT'),
(49, NULL, 49, NULL, 70, 65, 60, 80, 90, 90, 1, 5, 'H', NULL, NULL, NULL, 'VENOMOTH'),
(50, NULL, 50, NULL, 10, 55, 25, 35, 45, 95, 1, 5, 'M', NULL, NULL, NULL, 'DIGLETT'),
(51, NULL, 51, NULL, 35, 80, 50, 50, 70, 120, 1, 5, 'M', NULL, NULL, NULL, 'DUGTRIO'),
(52, NULL, 52, NULL, 40, 45, 35, 35, 50, 90, 1, 5, 'H', NULL, NULL, NULL, 'MEOWTH'),
(53, NULL, 53, NULL, 65, 70, 60, 50, 65, 115, 1, 5, 'H', NULL, NULL, NULL, 'PERSIAN'),
(54, NULL, 54, NULL, 50, 52, 48, 65, 50, 55, 1, 5, 'H', NULL, NULL, NULL, 'PSYDUCK'),
(55, NULL, 55, NULL, 80, 82, 78, 95, 80, 85, 1, 5, 'H', NULL, NULL, NULL, 'GOLDUCK'),
(56, NULL, 56, NULL, 40, 80, 35, 35, 45, 70, 1, 5, 'H', NULL, NULL, NULL, 'MANKEY'),
(57, NULL, 57, NULL, 65, 105, 60, 60, 70, 95, 1, 5, 'H', NULL, NULL, NULL, 'PRIMEAPE'),
(58, NULL, 58, NULL, 55, 70, 45, 70, 50, 60, 1, 5, 'H', NULL, NULL, NULL, 'GROWLITHE'),
(59, NULL, 59, NULL, 90, 110, 80, 100, 80, 95, 1, 5, 'H', NULL, NULL, NULL, 'ARCANINE'),
(60, NULL, 60, NULL, 40, 50, 40, 40, 40, 90, 1, 5, 'M', NULL, NULL, NULL, 'POLIWAG'),
(61, NULL, 61, NULL, 65, 65, 65, 50, 50, 90, 1, 5, 'M', NULL, NULL, NULL, 'POLIWHIRL'),
(62, NULL, 62, NULL, 90, 95, 95, 70, 90, 70, 1, 5, 'M', NULL, NULL, NULL, 'POLIWRATH'),
(63, NULL, 63, NULL, 25, 20, 15, 105, 55, 90, 1, 5, 'H', NULL, NULL, NULL, 'ABRA'),
(64, NULL, 64, NULL, 40, 35, 30, 120, 70, 105, 1, 5, 'H', NULL, NULL, NULL, 'KADABRA'),
(65, NULL, 65, NULL, 55, 50, 45, 135, 95, 120, 1, 5, 'H', NULL, NULL, NULL, 'ALAKAZAM'),
(66, NULL, 66, NULL, 70, 80, 50, 35, 35, 35, 1, 5, 'H', NULL, NULL, NULL, 'MACHOP'),
(67, NULL, 67, NULL, 70, 80, 50, 35, 35, 35, 1, 5, 'H', NULL, NULL, NULL, 'MACHOKE'),
(68, NULL, 68, NULL, 90, 130, 80, 65, 85, 55, 1, 5, 'H', NULL, NULL, NULL, 'MACHAMP'),
(69, NULL, 69, NULL, 50, 75, 35, 70, 30, 40, 1, 5, 'H', NULL, NULL, NULL, 'BELLSPROUT'),
(70, NULL, 70, NULL, 65, 90, 50, 85, 45, 55, 1, 5, 'H', NULL, NULL, NULL, 'WEEPINBELL'),
(71, NULL, 71, NULL, 80, 105, 65, 100, 70, 70, 1, 5, 'H', NULL, NULL, NULL, 'VICTREEBEL'),
(72, NULL, 72, NULL, 40, 40, 35, 50, 100, 70, 1, 5, 'H', NULL, NULL, NULL, 'TENTACOOL'),
(73, NULL, 73, NULL, 80, 70, 65, 80, 120, 100, 1, 5, 'H', NULL, NULL, NULL, 'TENTACRUEL'),
(74, NULL, 74, NULL, 40, 80, 100, 30, 30, 20, 1, 5, 'H', NULL, NULL, NULL, 'GEODUDE'),
(75, NULL, 75, NULL, 55, 95, 115, 45, 45, 35, 1, 5, 'H', NULL, NULL, NULL, 'GRAVELER'),
(76, NULL, 76, NULL, 80, 120, 130, 55, 65, 45, 1, 5, 'H', NULL, NULL, NULL, 'GOLEM'),
(77, NULL, 77, NULL, 50, 85, 55, 65, 65, 90, 1, 5, 'M', NULL, NULL, NULL, 'PONYTA'),
(78, NULL, 78, NULL, 65, 100, 70, 80, 80, 105, 1, 5, 'M', NULL, NULL, NULL, 'RAPIDASH'),
(79, NULL, 79, NULL, 90, 65, 65, 40, 40, 15, 1, 5, 'H', NULL, NULL, NULL, 'SLOWPOKE'),
(80, NULL, 80, NULL, 95, 75, 110, 100, 80, 30, 1, 5, 'H', NULL, NULL, NULL, 'SLOWBRO'),
(81, NULL, 81, NULL, 25, 35, 70, 95, 55, 45, 1, 5, 'Y', NULL, NULL, NULL, 'MAGNEMITE'),
(82, NULL, 82, NULL, 50, 60, 95, 120, 70, 70, 1, 5, 'Y', NULL, NULL, NULL, 'MAGNETON'),
(83, NULL, 83, NULL, 52, 90, 55, 58, 62, 60, 1, 5, 'M', NULL, NULL, NULL, 'FARFETCH\'D'),
(84, NULL, 84, NULL, 35, 85, 45, 35, 35, 75, 1, 5, 'M', NULL, NULL, NULL, 'DODUO'),
(85, NULL, 85, NULL, 60, 110, 70, 60, 60, 110, 1, 5, 'M', NULL, NULL, NULL, 'DODRIO'),
(86, NULL, 86, NULL, 65, 45, 55, 45, 70, 45, 1, 5, 'M', NULL, NULL, NULL, 'SEEL'),
(87, NULL, 87, NULL, 90, 70, 80, 70, 95, 70, 1, 5, 'M', NULL, NULL, NULL, 'DEWGONG'),
(88, NULL, 88, NULL, 80, 80, 50, 40, 50, 25, 1, 5, 'H', NULL, NULL, NULL, 'GRIMER'),
(89, NULL, 89, NULL, 105, 105, 75, 65, 100, 50, 1, 5, 'H', NULL, NULL, NULL, 'MUK'),
(90, NULL, 90, NULL, 30, 65, 100, 45, 25, 40, 1, 5, 'M', NULL, NULL, NULL, 'SHELLDER'),
(91, NULL, 91, NULL, 50, 95, 180, 85, 45, 70, 1, 5, 'M', NULL, NULL, NULL, 'CLOYSTER'),
(92, NULL, 92, NULL, 30, 35, 30, 100, 35, 80, 1, 5, 'H', NULL, NULL, NULL, 'GASTLY'),
(93, NULL, 93, NULL, 45, 50, 45, 115, 55, 95, 1, 5, 'H', NULL, NULL, NULL, 'HAUNTER'),
(94, NULL, 94, NULL, 60, 65, 60, 130, 75, 110, 1, 5, 'H', NULL, NULL, NULL, 'GENGAR'),
(95, NULL, 95, NULL, 35, 45, 160, 30, 45, 70, 1, 5, 'H', NULL, NULL, NULL, 'ONIX'),
(96, NULL, 96, NULL, 60, 48, 45, 43, 90, 42, 1, 5, 'H', NULL, NULL, NULL, 'DROWZEE'),
(97, NULL, 97, NULL, 85, 73, 70, 73, 115, 67, 1, 5, 'H', NULL, NULL, NULL, 'HYPNO'),
(98, NULL, 98, NULL, 30, 105, 90, 25, 25, 50, 1, 5, 'H', NULL, NULL, NULL, 'KRABBY'),
(99, NULL, 99, NULL, 55, 130, 115, 50, 50, 75, 1, 5, 'H', NULL, NULL, NULL, 'KINGLER'),
(100, NULL, 100, NULL, 40, 30, 50, 55, 55, 100, 1, 5, 'Y', NULL, NULL, NULL, 'VOLTORB'),
(101, NULL, 101, NULL, 60, 50, 70, 80, 80, 150, 1, 5, 'Y', NULL, NULL, NULL, 'ELECTRODE'),
(102, NULL, 102, NULL, 60, 40, 80, 60, 70, 40, 1, 5, 'H', NULL, NULL, NULL, 'EXEGGCUTE'),
(103, NULL, 103, NULL, 95, 95, 85, 125, 75, 55, 1, 5, 'H', NULL, NULL, NULL, 'EXEGGUTOR'),
(104, NULL, 104, NULL, 50, 50, 95, 40, 50, 35, 1, 5, 'H', NULL, NULL, NULL, 'CUBONE'),
(105, NULL, 105, NULL, 60, 80, 110, 50, 80, 45, 1, 5, 'H', NULL, NULL, NULL, 'MAROWAK'),
(106, NULL, 106, NULL, 50, 120, 53, 35, 110, 87, 1, 5, 'H', NULL, NULL, NULL, 'HITMONLEE'),
(107, NULL, 107, NULL, 50, 105, 79, 35, 110, 76, 1, 5, 'H', NULL, NULL, NULL, 'HITMONCHAN'),
(108, NULL, 108, NULL, 90, 55, 75, 60, 75, 30, 1, 5, 'M', NULL, NULL, NULL, 'LICKITUNG'),
(109, NULL, 109, NULL, 40, 65, 95, 60, 45, 35, 1, 5, 'M', NULL, NULL, NULL, 'KOFFING'),
(110, NULL, 110, NULL, 65, 90, 120, 85, 70, 60, 1, 5, 'M', NULL, NULL, NULL, 'WEEZING'),
(111, NULL, 111, NULL, 80, 85, 95, 30, 30, 25, 1, 5, 'H', NULL, NULL, NULL, 'RHYHORN'),
(112, NULL, 112, NULL, 105, 130, 120, 45, 45, 40, 1, 5, 'H', NULL, NULL, NULL, 'RHYDON'),
(113, NULL, 113, NULL, 250, 5, 5, 35, 105, 50, 1, 5, 'H', NULL, NULL, NULL, 'CHANSEY'),
(114, NULL, 114, NULL, 65, 55, 115, 100, 40, 60, 1, 5, 'H', NULL, NULL, NULL, 'TANGELA'),
(115, NULL, 115, NULL, 105, 95, 80, 40, 80, 90, 1, 5, 'M', NULL, NULL, NULL, 'KANGASKHAN'),
(116, NULL, 116, NULL, 30, 40, 70, 70, 25, 60, 1, 5, 'M', NULL, NULL, NULL, 'HORSEA'),
(117, NULL, 117, NULL, 55, 65, 95, 95, 45, 85, 1, 5, 'M', NULL, NULL, NULL, 'SEADRA'),
(118, NULL, 118, NULL, 45, 67, 60, 35, 50, 63, 1, 5, 'M', NULL, NULL, NULL, 'GOLDEEN'),
(119, NULL, 119, NULL, 80, 92, 65, 65, 80, 68, 1, 5, 'M', NULL, NULL, NULL, 'SEAKING'),
(120, NULL, 120, NULL, 30, 45, 55, 70, 55, 85, 1, 5, 'Y', NULL, NULL, NULL, 'STARYU'),
(121, NULL, 121, NULL, 60, 75, 85, 100, 85, 115, 1, 5, 'Y', NULL, NULL, NULL, 'STARMIE'),
(122, NULL, 122, NULL, 40, 45, 65, 100, 120, 90, 1, 5, 'M', NULL, NULL, NULL, 'MR. MIME'),
(123, NULL, 123, NULL, 70, 110, 80, 55, 80, 105, 1, 5, 'M', NULL, NULL, NULL, 'SCYTHER'),
(124, NULL, 124, NULL, 65, 50, 35, 115, 95, 95, 1, 5, 'M', NULL, NULL, NULL, 'JYNX'),
(125, NULL, 125, NULL, 65, 83, 57, 95, 85, 105, 1, 5, 'Y', NULL, NULL, NULL, 'ELECTABUZZ'),
(126, NULL, 126, NULL, 65, 95, 57, 100, 85, 93, 1, 5, 'Y', NULL, NULL, NULL, 'MAGMAR'),
(127, NULL, 127, NULL, 65, 125, 100, 55, 70, 85, 1, 5, 'M', NULL, NULL, NULL, 'PINSIR'),
(128, NULL, 128, NULL, 75, 100, 95, 40, 70, 110, 1, 5, 'M', NULL, NULL, NULL, 'TAUROS'),
(129, NULL, 129, NULL, 20, 10, 55, 15, 20, 80, 1, 5, 'M', NULL, NULL, NULL, 'MAGIKARP'),
(130, NULL, 130, NULL, 95, 125, 79, 60, 100, 81, 1, 5, 'M', NULL, NULL, NULL, 'GYARADOS'),
(131, NULL, 131, NULL, 130, 85, 80, 85, 95, 60, 1, 5, 'M', NULL, NULL, NULL, 'LAPRAS'),
(132, NULL, 132, NULL, 48, 48, 48, 48, 48, 48, 1, 5, 'M', NULL, NULL, NULL, 'DITTO'),
(133, NULL, 133, NULL, 55, 40, 35, 45, 50, 55, 1, 5, 'H', NULL, NULL, NULL, 'EEVEE'),
(134, NULL, 134, NULL, 130, 65, 60, 110, 95, 65, 1, 5, 'H', NULL, NULL, NULL, 'VAPOREON'),
(135, NULL, 135, NULL, 65, 65, 60, 110, 95, 130, 1, 5, 'H', NULL, NULL, NULL, 'JOLTEON'),
(136, NULL, 136, NULL, 65, 130, 60, 95, 110, 65, 1, 5, 'H', NULL, NULL, NULL, 'FLAREON'),
(137, NULL, 137, NULL, 65, 60, 70, 85, 75, 40, 1, 5, 'H', NULL, NULL, NULL, 'PORYGON'),
(138, NULL, 138, NULL, 35, 40, 100, 90, 55, 35, 1, 5, 'M', NULL, NULL, NULL, 'OMANYTE'),
(139, NULL, 139, NULL, 70, 60, 125, 115, 70, 55, 1, 5, 'M', NULL, NULL, NULL, 'OMASTAR'),
(140, NULL, 140, NULL, 30, 40, 45, 40, 50, 55, 1, 5, 'M', NULL, NULL, NULL, 'KABUTO'),
(141, NULL, 141, NULL, 60, 115, 105, 65, 70, 80, 1, 5, 'M', NULL, NULL, NULL, 'KABUTOPS'),
(142, NULL, 142, NULL, 80, 105, 65, 60, 75, 150, 1, 5, 'M', NULL, NULL, NULL, 'AERODACTYL'),
(143, NULL, 143, NULL, 160, 110, 65, 65, 110, 30, 1, 5, 'M', NULL, NULL, NULL, 'SNORLAX'),
(144, NULL, 144, NULL, 90, 85, 100, 95, 125, 85, 1, 5, 'Y', NULL, NULL, NULL, 'ARTICUNO'),
(145, NULL, 145, NULL, 90, 90, 85, 125, 90, 100, 1, 5, 'Y', NULL, NULL, NULL, 'ZAPDOS'),
(146, NULL, 146, NULL, 90, 100, 90, 125, 85, 90, 1, 5, 'Y', NULL, NULL, NULL, 'MOLTRES'),
(147, NULL, 147, NULL, 41, 64, 45, 50, 50, 50, 1, 5, 'M', NULL, NULL, NULL, 'DRATINI'),
(148, NULL, 148, NULL, 61, 84, 65, 70, 70, 70, 1, 5, 'M', NULL, NULL, NULL, 'DRAGONAIR'),
(149, NULL, 149, NULL, 91, 134, 95, 100, 100, 80, 1, 5, 'M', NULL, NULL, NULL, 'DRAGONITE'),
(150, NULL, 150, NULL, 106, 110, 90, 154, 90, 130, 1, 5, 'Y', NULL, NULL, NULL, 'MEWTWO'),
(151, NULL, 151, NULL, 100, 100, 100, 100, 100, 100, 1, 5, 'Y', NULL, NULL, NULL, 'MEW');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`id_entrenador`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- Indices de la tabla `mochila`
--
ALTER TABLE `mochila`
  ADD PRIMARY KEY (`id_entrenador`,`id_objeto`),
  ADD KEY `FK_MOCHILA_ID_OBJETO` (`id_objeto`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id_movimiento`);

--
-- Indices de la tabla `movimiento_pokemon`
--
ALTER TABLE `movimiento_pokemon`
  ADD PRIMARY KEY (`id_pokemon`,`id_movimiento`),
  ADD KEY `FK_ID_MOVIMIENTO` (`id_movimiento`);

--
-- Indices de la tabla `objeto`
--
ALTER TABLE `objeto`
  ADD PRIMARY KEY (`id_objeto`);

--
-- Indices de la tabla `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`num_pokedex`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id_pokemon`),
  ADD KEY `FK_ID_ENTRENADOR` (`id_entrenador`),
  ADD KEY `FK_ID_OBJETO` (`id_objeto`),
  ADD KEY `FK_NUM_POKEDEX` (`num_pokedex`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mochila`
--
ALTER TABLE `mochila`
  ADD CONSTRAINT `FK_MOCHILA_ID_ENTRENADOR` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`),
  ADD CONSTRAINT `FK_MOCHILA_ID_OBJETO` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`);

--
-- Filtros para la tabla `movimiento_pokemon`
--
ALTER TABLE `movimiento_pokemon`
  ADD CONSTRAINT `FK_ID_MOVIMIENTO` FOREIGN KEY (`id_movimiento`) REFERENCES `movimiento` (`id_movimiento`),
  ADD CONSTRAINT `FK_ID_POKEMON` FOREIGN KEY (`id_pokemon`) REFERENCES `pokemon` (`id_pokemon`);

--
-- Filtros para la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD CONSTRAINT `FK_ID_ENTRENADOR` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`),
  ADD CONSTRAINT `FK_ID_OBJETO` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`),
  ADD CONSTRAINT `FK_NUM_POKEDEX` FOREIGN KEY (`num_pokedex`) REFERENCES `pokedex` (`num_pokedex`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
