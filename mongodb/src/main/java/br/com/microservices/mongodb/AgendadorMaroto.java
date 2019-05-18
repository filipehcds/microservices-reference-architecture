//package br.com.microservices.mongodb;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AgendadorMaroto {
//
//	private static final String TIME_ZONE = "America/Sao_Paulo";
//	
//	@Scheduled(fixedDelay = 10000)
//	public void executarFixedDelay() {
//		System.out.println("Executou o Scheduled com delay");
//	}
//
//	@Scheduled(cron = "0 0 7,12,13,16 ? * MON,TUE,WED,THU,FRI *", zone = TIME_ZONE)
//	public void executarCron() {
//		System.out.println("Executou o Scheduled com cron");
//	}	
//
//}
