package wechat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import wechat.thread.WechatGetAccessTokenThread;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
		new WechatGetAccessTokenThread().start();
	}

}
