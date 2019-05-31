package br.com.microservices.scheduleservice;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	private static final String TIME_ZONE = "America/Sao_Paulo";

	@Scheduled(fixedDelay = 10000)
	public void executarFixedDelay() {
		System.out.println("Executou o Scheduled com delay");
	}

	@Scheduled(cron = "* * * * * *", zone = TIME_ZONE)
	public void executarCron() {
		System.out.println("Executou o Scheduled com cron a CADA SEGUNDO");
	}

}
