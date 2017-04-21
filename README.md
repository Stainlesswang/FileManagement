# FileManagement
李晓旭毕设档案管理系统，采用Spring boot 集成Mybatis，spring security H-ui前端框架，thymeleaf模板
项目为Maven项目，建议使用Idea为开发工具，数据库表为主目录下的 my.sql 文件，
导入到自己的Mysql中修改src/mian/resources/application.properties 为自己的端口，数据库名，用户名和密码。
运行/java 目录下的启动类Application即可启动项目


## Spring Boot 教程一：搭建Spring Boot 成功返回JSON串
## Spring Boot是什么？

还恍惚记得当初写Spring的时候要配置好多xml（在当时还是相对先进的模式），虽然实现了松耦合，但这些xml却又成为了项目甩不掉的负担 -- 随着项目越做越大，这些xml的可读性和可维护性极差。后来受.Net平台中Annotation的启发，Java世界中也引入了元数据的修饰符，Spring也可以使用这种方式进行配置。到了近些年，随着Ruby on Rails的兴起而流行开的 `Convention over configuration` 理念开始深入人心。那什么是 `Convention over configuration` 呢？简单来说就是牺牲一部分的自由度来减少配置的复杂度，打个比方就是如果你如果遵从我定义的一系列规则（打个比方，文件目录结构必须是blablabla的样子，文件命名必须是nahnahnah 的样子），那么你要配置的东西就非常简单甚至可以零配置。既然已经做到这个地步了，各种脚手架项目就纷纷涌现了，目的只有一个：让你更专注在代码的编写，而不是浪费在各种配置上。这两年前端也有类似趋势，各种前端框架的官方CLI纷纷登场：create-react-app，angular-cli，vue-cli等等。

那么Spring Boot就是Spring框架的脚手架了，它可以帮你快速搭建、发布一个Spring应用。官网列出了Spring Boot的几个主要目标

 - 提供一种快速和广泛适用的Spring开发体验
 - 开箱即用却又可以适应各种变化
 - 提供一系列开发中常用的“非功能性”的特性（比如嵌入式服务器、安全、度量、自检及外部配置等）
 - 不生成任何代码，不需要xml配置
