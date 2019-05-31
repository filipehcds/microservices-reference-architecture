package br.com.microservices.dashboardserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;

@EnableMicroservicesDashboardServer
@SpringBootApplication
public class DashboardServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardServerApplication.class, args);
	}

}
