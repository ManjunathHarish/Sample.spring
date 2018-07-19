package com.properties.App;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import javax.activation.DataContentHandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
 
import java.util.Arrays;
 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(value=Datacontroller.class,secure=false)
public class AppApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private Datacontroller dataController;
		
	@Test (expected = Exception.class)
	public void getByBotIntIdTest() throws Exception {
		DataModel a=new DataModel();
		Datacontroller m=new Datacontroller();
		a.setBotIntId(1);
		a.setChannelName("hi");
		DataModel b=new DataModel();
		b.setBotIntId(2);
		b.setChannelName("bye");
		when(m.getAllRecords()).thenReturn(Arrays.asList(a,b));
		 mockMvc.perform(get("/rest/all"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
         .andExpect(jsonPath("$", hasSize(2)));

 verify(dataController, times(1)).getAllRecords();
 verifyNoMoreInteractions(dataController);
	}



}
