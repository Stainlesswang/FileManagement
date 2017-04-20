package tcu.lxx.filemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by stanwang on 2017/4/8.
 */
@SpringBootApplication
@ComponentScan//启动自动扫描
@EnableAutoConfiguration
@MapperScan("tcu.lxx.filemanage.mapper")//设置Mybatis扫描的包名称，下边的接口就是对应的增删改查方法
public class Application {

    //程序入口，Spring Boot启动入口
    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }
}
