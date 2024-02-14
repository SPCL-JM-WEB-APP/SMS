package account.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "account.demo")
public class AccountDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDemoApplication.class, args);
	}

}
