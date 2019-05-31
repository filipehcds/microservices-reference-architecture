package br.com.microservices.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mail")
public class MailResource {

	@Autowired
	public EmailServiceImpl emailService;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String createMail() {
		emailService.sendSimpleMessage("filipehcds.sp@gmail.com", "Titulo Teste", "Oláaaa.. mensagem de teste!!!");
		return "OK";
	}

}
