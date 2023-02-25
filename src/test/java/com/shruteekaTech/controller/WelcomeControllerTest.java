
package com.shruteekaTech.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shruteekaTech.service.WelcomeService;

@WebMvcTest(value = WelcomeController.class)
class WelcomeControllerTest {

	@MockBean
	private WelcomeService welcomeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void welcomeMsgTest() throws Exception {
		
		// take service method with when & thenReturn
		when(welcomeService.welcomeMethod()).thenReturn("welcome method return executed");
		 
		//get url(put controller url) from MockMvcRequestBuilders
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		
		ResultActions perform = mockMvc.perform(requestBuilder);
		
		MvcResult mvcResult = perform.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();
		
		assertEquals(200, status);
		
	}
	
	@Test
	public void greetMsgTest() throws Exception {
		when(welcomeService.greet()).thenReturn("greet method return executed");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		
	}
	
	@Test
	public void news() throws Exception {
		when(welcomeService.newsMethod()).thenReturn("news method return executed");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/tazaNews");
		ResultActions perform = mockMvc.perform(builder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	

}
