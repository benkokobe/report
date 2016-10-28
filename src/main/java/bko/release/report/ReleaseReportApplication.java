package bko.release.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ReleaseReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReleaseReportApplication.class, args);
	}
}
