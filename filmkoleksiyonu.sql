-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 09 Eki 2021, 20:18:47
-- Sunucu sürümü: 10.4.16-MariaDB
-- PHP Sürümü: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `filmkoleksiyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `film`
--

CREATE TABLE `film` (
  `film_id` bigint(20) NOT NULL,
  `film_aciklama` varchar(255) DEFAULT NULL,
  `film_adi` varchar(255) DEFAULT NULL,
  `film_dili` varchar(255) DEFAULT NULL,
  `film_kategori` varchar(255) DEFAULT NULL,
  `film_medya` varchar(255) DEFAULT NULL,
  `film_oyuncu` varchar(255) DEFAULT NULL,
  `film_yili` varchar(255) DEFAULT NULL,
  `film_yonetmen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `film`
--

INSERT INTO `film` (`film_id`, `film_aciklama`, `film_adi`, `film_dili`, `film_kategori`, `film_medya`, `film_oyuncu`, `film_yili`, `film_yonetmen`) VALUES
(1, '1997 yılı Amerikan yapımı epik, felaket, ve romantizm temalı sinema filmi. RMS Titanic\'in batışı üzerine kurgulanan filmin başrollerini, geminin felaketle sonuçlanan ilk seyahati sırasında birbirine âşık olan farklı toplumsal sınıflara mensup iki genci ca', 'Titanic', 'İngilizce', 'Romantizm', 'https://upload.wikimedia.org/wikipedia/tr/b/b3/Titanik_film.jpg', 'Leonardo DiCaprio\r\nKate Winslet', '1997', 'James Cameron'),
(2, 'The Platform, dikey şekilde konumlandırılmış bir hapishanede geçiyor. Her hücrede iki mahkumun kaldığı hapishanede, yemek günde sadece bir kere üst kattan aşağıya doğru gönderilmektedir. Üst kattaki mahkumlar yiyeceğe ulaşmak için çabalarken, alt katta bu', 'The Platform', 'İspanyolca', 'Bilim Kurgu - Gerilim', 'https://www.cumhuriyet.com.tr/Archive/2020/4/12/1732619/kapak_063029.jpg', 'Iván Massagué', '2019', 'Galder Gaztelu-Urrutia'),
(3, 'Film, Jane Austen’in beş kız kardeş, Jane, Elizabeth, Mary, Kitty ve Lydia Bennet’i anlatan romanından uyarlanmıştır. Hikaye George dönemi İngilteresi’nde geçer. Ailenin yaşamı, genç ve zengin bir adam olan Bay Bingley’in ve onun en yakın arkadaşı Bay Dar', 'Aşk ve Gurur', 'İngilizce', 'Romantik', 'https://upload.wikimedia.org/wikipedia/tr/0/03/A%C5%9Fk_ve_Gurur_%282005%29_-_film_afi%C5%9Fi.jpg', 'Keira Knightley', '2005', 'Joe Wright'),
(4, 'Gelecekte başarısızlığa uğrayan bir deney büyük bir felaketle sonuçlanır ve yeryüzündeki yaşamı büyük ölçüde bitiren bir küresel ısınma olur. Dünyanın çevresinde kesintisiz bir güçle dönen bir tren hayatta kalan insanların son sığınağı olacaktır. Fakat gü', 'Snowpiercer-Kar Küreyici', 'İngilizce', 'Bilim Kurgu', 'https://upload.wikimedia.org/wikipedia/tr/6/65/Snowpiercer_film_posteri.jpg', 'Chris Evans', '2013', 'Bong Joon-Ho');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE `kullanici` (
  `id` bigint(20) NOT NULL,
  `adi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sifre` varchar(255) DEFAULT NULL,
  `soyadi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`id`, `adi`, `email`, `sifre`, `soyadi`) VALUES
(1, 'İlknur', 'ilknurravsar@gmail.com', '$2a$10$htxapRjkTaEptRNJOjJbjO7Ps5EWsL9.8qkoe4ubMBU4nXNVV7yWi', 'Avşar'),
(2, 'Halil', 'halil@gmail.com', '$2a$10$rJx46S2cSqVwy.CkfYmjFuocb3sR.M4pxrslfxvNE5nhZyQDOg.OO', 'Avşar'),
(3, 'Esma', 'esma@gmail.com', '$2a$10$PBeOrbk3Rn2rzmPURjuR/.nRs7oL3mV3XzILTanBPnAPZQOlY.D2u', 'Çoğal');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici_rol`
--

CREATE TABLE `kullanici_rol` (
  `kullanici_id` bigint(20) NOT NULL,
  `rol_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kullanici_rol`
--

INSERT INTO `kullanici_rol` (`kullanici_id`, `rol_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `rol`
--

CREATE TABLE `rol` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `rol`
--

INSERT INTO `rol` (`id`, `name`) VALUES
(1, 'ROL_KULLANICI'),
(2, 'ROL_KULLANICI'),
(3, 'ROL_KULLANICI');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`film_id`);

--
-- Tablo için indeksler `kullanici`
--
ALTER TABLE `kullanici`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK8abg1rqkae5ngnp3d5lxrb4bn` (`email`);

--
-- Tablo için indeksler `kullanici_rol`
--
ALTER TABLE `kullanici_rol`
  ADD KEY `FKsnjgjwg9i4y91oc64dkvvqwpw` (`rol_id`),
  ADD KEY `FKa2awupv1t8ex35uoye9424ntw` (`kullanici_id`);

--
-- Tablo için indeksler `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `film`
--
ALTER TABLE `film`
  MODIFY `film_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `kullanici`
--
ALTER TABLE `kullanici`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `rol`
--
ALTER TABLE `rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `kullanici_rol`
--
ALTER TABLE `kullanici_rol`
  ADD CONSTRAINT `FKa2awupv1t8ex35uoye9424ntw` FOREIGN KEY (`kullanici_id`) REFERENCES `kullanici` (`id`),
  ADD CONSTRAINT `FKsnjgjwg9i4y91oc64dkvvqwpw` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
