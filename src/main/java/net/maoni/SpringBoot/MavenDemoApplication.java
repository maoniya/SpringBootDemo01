package net.maoni.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication     //标记此类为springboot 应用
@ServletComponentScan		// 标记过滤器
@EnableScheduling			// 开启定时任务
@EnableAsync				//开启异步任务
public class MavenDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MavenDemoApplication.class, args);
	}
}
