-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.23-0ubuntu0.16.04.1 - (Ubuntu)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para card
DROP DATABASE IF EXISTS `card`;
CREATE DATABASE IF NOT EXISTS `card` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `card`;


-- Copiando estrutura para tabela card.cartao
DROP TABLE IF EXISTS `cartao`;
CREATE TABLE IF NOT EXISTS `cartao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `dia_fechamento` int(11) DEFAULT NULL,
  `dia_pagamento` int(11) DEFAULT NULL,
  `limite` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela card.cartao: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cartao` DISABLE KEYS */;
REPLACE INTO `cartao` (`id`, `nome`, `dia_fechamento`, `dia_pagamento`, `limite`) VALUES
	(1, 'NuBank', 5, 12, 10.00);
/*!40000 ALTER TABLE `cartao` ENABLE KEYS */;


-- Copiando estrutura para tabela card.categoria
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `ativo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela card.categoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


-- Copiando estrutura para tabela card.conta
DROP TABLE IF EXISTS `conta`;
CREATE TABLE IF NOT EXISTS `conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `saldo` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela card.conta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;


-- Copiando estrutura para tabela card.pagamento
DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE IF NOT EXISTS `pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vencimento` date DEFAULT NULL,
  `valor` double(10,2) DEFAULT NULL,
  `numero_parcela` int(11) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_tipo_pagamento` int(11) DEFAULT NULL,
  `id_cartao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pagamento_usuario` (`id_usuario`),
  KEY `FK_pagamento_categoria` (`id_categoria`),
  KEY `FK_pagamento_conta` (`id_conta`),
  KEY `FK_pagamento_tipo_pagamento` (`id_tipo_pagamento`),
  KEY `FK_pagamento_cartao` (`id_cartao`),
  CONSTRAINT `FK_pagamento_cartao` FOREIGN KEY (`id_cartao`) REFERENCES `cartao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pagamento_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pagamento_conta` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pagamento_tipo_pagamento` FOREIGN KEY (`id_tipo_pagamento`) REFERENCES `tipo_pagamento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pagamento_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela card.pagamento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;


-- Copiando estrutura para tabela card.tipo_pagamento
DROP TABLE IF EXISTS `tipo_pagamento`;
CREATE TABLE IF NOT EXISTS `tipo_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela card.tipo_pagamento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_pagamento` ENABLE KEYS */;


-- Copiando estrutura para tabela card.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela card.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
REPLACE INTO `usuario` (`id`, `nome`, `cpf`, `nascimento`) VALUES
	(1, 'Caboco Mamado', '06871346333', '2000-09-06');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
