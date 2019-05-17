package us.abstracta.sparring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SparringServicesApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(SparringServicesApplication.class, args);
	}

	public static void restart() {
		ApplicationArguments args = context.getBean(ApplicationArguments.class);

		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(SparringServicesApplication.class, args.getSourceArgs());
		});

		thread.setDaemon(false);
		thread.start();
	}

}
