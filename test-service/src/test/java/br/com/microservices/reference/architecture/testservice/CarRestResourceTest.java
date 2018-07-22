//package br.com.microservices.reference.architecture.testservice;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import br.com.microservices.reference.architecture.testservice.resource.CarResource;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(CarResource.class)
//public class CarRestResourceTest {
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@Autowired
//	ObjectMapper jsonParser;
//
//	@Test
//	public void testGetAll() throws Exception {
//		mockMvc.perform(get("/cars")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$.[0].model", equalTo("Koenigsegg One:1"))).andExpect(jsonPath("$.[0].model", equalTo("McLaren F1")));
//	}
//
//}
