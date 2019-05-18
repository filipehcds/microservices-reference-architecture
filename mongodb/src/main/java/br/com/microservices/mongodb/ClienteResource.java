package br.com.microservices.mongodb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClienteResource {
	
	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public ResponseEntity<String> call() {
		return callWebService();
	}
	
	@Cacheable(value = "webservice-response")
	public ResponseEntity<String> callWebService() {
		System.out.println("Calling WebService...");
		RestTemplate template = new RestTemplate();
		return template.getForEntity("https://api.calendario.com.br/?ano=2019&estado=SP&cidade=SAO_PAULO&token=ZmlsaXBlaGNkcy5zcEBnbWFpbC5jb20maGFzaD0xMzUxNzQ4Njk&json=true", String.class);
	}

//	@Autowired
//	public EmailServiceImpl emailService;
//
//	@RequestMapping(value = "/send", method = RequestMethod.GET)
//	public String createMail() {
//		emailService.sendSimpleMessage("filipehcds.sp@gmail.com", "Titulo Teste", "Oláaaa.. mensagem de teste!!!");
//		return "OK";
//	}

//	@Autowired
//	OrderQueueSender orderQueueSender;
//	
//	@RequestMapping("/")
//	public String queue() {
//		System.out.println("GET /queue");
//		System.out.println("Enviando Mensagem!!!!");
//		orderQueueSender.send("Mensagem Teste");
//		System.out.println("Mensagem Enviada!!!!");
//		return "OK";
//	}

//	@Autowired
//	ClienteRepository clienteRepository;
//
//	@RequestMapping("/")
//	public List<Cliente> listAll() {
//		System.out.println("GET /list");
//		
//		Cliente cliente1 = new Cliente();
//		cliente1.setNome("Marcos");
//		cliente1.setIdade(65);
//		cliente1.setTelefone("+5511949267291");
//		
//		System.out.println("Registros: " + clienteRepository.count());
//		clienteRepository.save(cliente1);
//		System.out.println(clienteRepository.findByNome("Filipe"));
//		Cliente cliente2 = new Cliente();
//		cliente2 = clienteRepository.findByNome("Leyne");
//		System.out.println("Cliente2 Antes -> " + cliente2);
//		System.out.println("Registros: " + clienteRepository.count());
//		cliente2.setIdade(25);
//		clienteRepository.save(cliente2);
//		System.out.println("Registros: " + clienteRepository.count());
//		System.out.println("Cliente2 Depois -> " + cliente2);
//		System.out.println("Registros: " + clienteRepository.count());
//		
////		Example<Cliente> example = Example.of(cliente2);
////		System.out.println("FindOne: " + clienteRepository.findOne(example));
//		
////		clienteRepository.delete(cliente2);
//		
//		return (List<Cliente>) clienteRepository.findAll();
//	}

}
