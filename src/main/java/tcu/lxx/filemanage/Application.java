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
@ComponentScan
@EnableAutoConfiguration
@MapperScan("tcu.lxx.filemanage.mapper")
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }
}
