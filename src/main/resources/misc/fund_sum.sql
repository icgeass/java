/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - fund
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `fund_sum` */

CREATE TABLE `fund_sum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fund_code` varchar(6) COLLATE utf8mb4_bin NOT NULL COMMENT '基金代码',
  `fund_name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '基金名称',
  `buy_share` decimal(18,4) DEFAULT NULL COMMENT '期间申购（亿份）',
  `sell_share` decimal(18,4) DEFAULT NULL COMMENT '期间赎回（亿份）',
  `total_share` decimal(18,4) DEFAULT NULL COMMENT '期末总份额（亿份）',
  `stock_amount` decimal(18,4) DEFAULT NULL COMMENT '期末净资产（亿元）',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `yn` tinyint(4) DEFAULT NULL COMMENT '是否有效，1，有效，0，无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16384 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
