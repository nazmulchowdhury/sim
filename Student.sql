SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `sms`
--

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE IF NOT EXISTS `Student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `roll` varchar(6) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `cgpa` varchar(4) DEFAULT NULL,
  `blood_group` varchar(3) DEFAULT NULL,
  `nid` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `nid` (`nid`),
  UNIQUE KEY `roll` (`roll`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;
