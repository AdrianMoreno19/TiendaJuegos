-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2025 a las 23:32:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendavideojuegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consolas`
--

CREATE TABLE `consolas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cpu_potencia` varchar(50) DEFAULT NULL,
  `gpu_potencia` varchar(50) DEFAULT NULL,
  `compania` varchar(50) DEFAULT NULL,
  `precio` varchar(50) NOT NULL,
  `unidades_disponibles` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `consolas`
--

INSERT INTO `consolas` (`id`, `nombre`, `cpu_potencia`, `gpu_potencia`, `compania`, `precio`, `unidades_disponibles`) VALUES
(1, 'Xbox One', '1.75 GHz', '853 MHz', 'Microsoft', '299.99', '49'),
(2, 'Xbox Series X', '3.8 GHz', '1.825 GHz', 'Microsoft', '499.99', '30'),
(3, 'Xbox Series S', '3.6 GHz', '1.565 GHz', 'Microsoft', '299.99', '20'),
(4, 'Nintendo Switch', '1.02 GHz', '768 MHz', 'Nintendo', '299.99', '38'),
(6, 'PS4', '123', '123', 'Sony', '123', '123'),
(7, 'PS5 con CD', '900 GHz', '853 MHz', 'Sony', '340', '200'),
(8, 'PS5 sin CD', '3.5 GHz', '2.23 GHz', 'Sony', '399.99', '10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE `juegos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `consola` varchar(50) DEFAULT NULL,
  `compania_desarrolladora` varchar(50) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `puntuacion_metacritic` decimal(3,1) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `unidades_disponibles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`id`, `nombre`, `consola`, `compania_desarrolladora`, `genero`, `puntuacion_metacritic`, `precio`, `unidades_disponibles`) VALUES
(1, 'FIFA 22', 'PS5 con CD', 'EA Sports', 'Deportes', 85.0, 69.99, 50),
(2, 'FIFA 22', 'PS4', 'EA Sports', 'Deportes', 85.0, 59.99, 40),
(3, 'The Legend of Zelda: Breath of the Wild', 'Nintendo Switch', 'Nintendo', 'Aventura', 97.0, 59.99, 20),
(4, 'The Legend of Zelda: Breath of the Wild', 'Nintendo Switch Lite', 'Nintendo', 'Aventura', 97.0, 59.99, 20),
(5, 'Halo Infinite', 'Xbox Series X', '343 Industries', 'Acción', 87.0, 59.99, 29),
(6, 'Halo Infinite', 'Xbox One', '343 Industries', 'Acción', 87.0, 49.99, 20),
(7, 'Spider-Man: Miles Morales', 'PS5 con CD', 'Insomniac Games', 'Aventura', 85.0, 49.99, 29),
(8, 'Spider-Man: Miles Morales', 'PS4', 'Insomniac Games', 'Aventura', 85.0, 39.99, 24),
(9, 'Animal Crossing: New Horizons', 'Nintendo Switch', 'Nintendo', 'Simulación', 91.0, 59.99, 35),
(10, 'Animal Crossing: New Horizons', 'Nintendo Switch Lite', 'Nintendo', 'Simulación', 91.0, 59.99, 35),
(11, 'Forza Horizon 5', 'Xbox Series X', 'Playground Games', 'Carreras', 92.0, 59.99, 15),
(12, 'Forza Horizon 5', 'Xbox One', 'Playground Games', 'Carreras', 92.0, 49.99, 10),
(13, 'Super Mario Odyssey', 'Nintendo Switch', 'Nintendo', 'Aventura', 97.0, 59.99, 18),
(14, 'Super Mario Odyssey', 'Nintendo Switch Lite', 'Nintendo', 'Aventura', 97.0, 59.99, 18),
(15, 'Horizon Forbidden West', 'PS5 con CD', 'Guerrilla Games', 'Aventura', 88.0, 69.99, 22),
(16, 'Horizon Forbidden West', 'PS4', 'Guerrilla Games', 'Aventura', 88.0, 59.99, 20),
(17, 'Gears 5', 'Xbox One', 'The Coalition', 'Acción', 82.0, 39.99, 12),
(18, 'Gears 5', 'Xbox Series X', 'The Coalition', 'Acción', 82.0, 49.99, 15),
(19, 'Mario Kart 8 Deluxe', 'Nintendo Switch', 'Nintendo', 'Carreras', 92.0, 59.99, 30),
(20, 'Mario Kart 8 Deluxe', 'Nintendo Switch Lite', 'Nintendo', 'Carreras', 92.0, 59.99, 30),
(21, 'Elden Ring', 'PS5 con CD', 'FromSoftware', 'RPG', 96.0, 59.99, 40),
(22, 'Elden Ring', 'PS4', 'FromSoftware', 'RPG', 96.0, 49.99, 35),
(23, 'Starfield', 'Xbox Series X', 'Bethesda', 'RPG', 88.0, 69.99, 20),
(24, 'Starfield', 'Xbox One', 'Bethesda', 'RPG', 88.0, 59.99, 15),
(25, 'Splatoon 3', 'Nintendo Switch', 'Nintendo', 'Acción', 83.0, 59.99, 25),
(26, 'Splatoon 3', 'Nintendo Switch Lite', 'Nintendo', 'Acción', 83.0, 59.99, 25),
(27, 'Call of Duty: Modern Warfare II', 'PS5 con CD', 'Infinity Ward', 'Disparos', 84.0, 69.99, 18),
(28, 'Call of Duty: Modern Warfare II', 'PS4', 'Infinity Ward', 'Disparos', 84.0, 59.99, 15),
(29, 'Sea of Thieves', 'Xbox Series X', 'Rare', 'Aventura', 87.0, 49.99, 20),
(30, 'Sea of Thieves', 'Xbox One', 'Rare', 'Aventura', 87.0, 39.99, 18),
(31, 'Fire Emblem: Three Houses', 'Nintendo Switch', 'Nintendo', 'Estrategia', 89.0, 59.99, 12),
(32, 'Fire Emblem: Three Houses', 'Nintendo Switch Lite', 'Nintendo', 'Estrategia', 89.0, 59.99, 12),
(33, 'The Last of Us Part II', 'PS4', 'Naughty Dog', 'Aventura', 93.0, 59.99, 15),
(34, 'God of War Ragnarök', 'PS5 con CD', 'Santa Monica Studio', 'Aventura', 94.0, 69.99, 25),
(35, 'Pokemon Scarlet', 'Nintendo Switch', 'Game Freak', 'RPG', 77.0, 59.99, 18),
(36, 'Pokemon Scarlet', 'Nintendo Switch Lite', 'Game Freak', 'RPG', 77.0, 59.99, 18),
(37, 'Assassin’s Creed Valhalla', 'PS5 con CD', 'Ubisoft', 'Aventura', 82.0, 49.99, 20),
(38, 'Assassin’s Creed Valhalla', 'PS4', 'Ubisoft', 'Aventura', 82.0, 39.99, 18),
(39, 'Crash Bandicoot 4', 'Xbox Series X', 'Toys for Bob', 'Plataformas', 85.0, 39.99, 10),
(40, 'Crash Bandicoot 4', 'Xbox One', 'Toys for Bob', 'Plataformas', 85.0, 29.99, 12),
(41, 'Metroid Dread', 'Nintendo Switch', 'MercurySteam', 'Acción', 88.0, 59.99, 10),
(42, 'Metroid Dread', 'Nintendo Switch Lite', 'MercurySteam', 'Acción', 88.0, 59.99, 10),
(43, 'NBA 2K23', 'PS5 con CD', 'Visual Concepts', 'Deportes', 80.0, 69.99, 12),
(44, 'NBA 2K23', 'PS4', 'Visual Concepts', 'Deportes', 80.0, 59.99, 10),
(45, 'Cuphead', 'Xbox One', 'Studio MDHR', 'Plataformas', 86.0, 29.99, 8),
(46, 'Cuphead', 'Xbox Series X', 'Studio MDHR', 'Plataformas', 86.0, 29.99, 8),
(47, 'Kirby and the Forgotten Land', 'Nintendo Switch', 'Nintendo', 'Plataformas', 85.0, 59.99, 20),
(48, 'Kirby and the Forgotten Land', 'Nintendo Switch Lite', 'Nintendo', 'Plataformas', 85.0, 59.99, 20),
(49, 'FIFA 22', 'PS5 sin CD', 'EA Sports', 'Deportes', 85.0, 69.99, 50),
(50, 'Halo Infinite', 'PS5 sin CD', '343 Industries', 'Acción', 87.0, 59.99, 30),
(51, 'Spider-Man: Miles Morales', 'PS5 sin CD', 'Insomniac Games', 'Aventura', 85.0, 49.99, 30),
(52, 'Horizon Forbidden West', 'PS5 sin CD', 'Guerrilla Games', 'Aventura', 88.0, 69.99, 22),
(53, 'Elden Ring', 'PS5 sin CD', 'FromSoftware', 'RPG', 96.0, 59.99, 40),
(54, 'Call of Duty: Modern Warfare II', 'PS5 sin CD', 'Infinity Ward', 'Disparos', 84.0, 69.99, 18),
(56, 'Assassin’s Creed Valhalla', 'PS5 sin CD', 'Ubisoft', 'Aventura', 82.0, 49.99, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegosconsolas`
--

CREATE TABLE `juegosconsolas` (
  `id` int(11) NOT NULL,
  `juego_id` int(11) NOT NULL,
  `consola_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `juegosconsolas`
--

INSERT INTO `juegosconsolas` (`id`, `juego_id`, `consola_id`) VALUES
(76, 1, 7),
(77, 2, 6),
(78, 3, 4),
(80, 4, 2),
(81, 4, 1),
(82, 5, 7),
(83, 6, 6),
(84, 7, 4),
(86, 8, 2),
(87, 8, 1),
(88, 9, 4),
(90, 10, 7),
(91, 11, 6),
(92, 12, 1),
(93, 13, 2),
(94, 14, 4),
(96, 16, 7),
(97, 17, 6),
(98, 18, 2),
(99, 19, 1),
(100, 20, 4),
(102, 22, 7),
(103, 23, 6),
(104, 24, 2),
(105, 25, 1),
(106, 26, 4),
(108, 28, 6),
(109, 29, 7),
(110, 30, 4),
(112, 32, 7),
(113, 33, 6),
(114, 34, 2),
(115, 35, 1),
(116, 36, 4),
(118, 38, 7),
(119, 39, 6),
(120, 40, 1),
(121, 41, 2),
(122, 42, 4),
(124, 49, 8),
(125, 50, 8),
(126, 51, 8),
(127, 52, 8),
(128, 53, 8),
(129, 54, 8),
(131, 56, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `esAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `esAdmin`) VALUES
(1, 'Adri', '1234', 1),
(2, 'Alex', '1234', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consolas`
--
ALTER TABLE `consolas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `juegosconsolas`
--
ALTER TABLE `juegosconsolas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `juego_id` (`juego_id`),
  ADD KEY `consola_id` (`consola_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consolas`
--
ALTER TABLE `consolas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `juegos`
--
ALTER TABLE `juegos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `juegosconsolas`
--
ALTER TABLE `juegosconsolas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `juegosconsolas`
--
ALTER TABLE `juegosconsolas`
  ADD CONSTRAINT `juegosconsolas_ibfk_1` FOREIGN KEY (`juego_id`) REFERENCES `juegos` (`id`),
  ADD CONSTRAINT `juegosconsolas_ibfk_2` FOREIGN KEY (`consola_id`) REFERENCES `consolas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
