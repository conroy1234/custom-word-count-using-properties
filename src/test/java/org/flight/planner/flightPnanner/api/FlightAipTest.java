package org.flight.planner.flightPnanner.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.validation.constraints.NotEmpty;

import org.flight.planner.flightPnanner.model.Flight;
import org.flight.planner.flightPnanner.service.FlightService;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsNot;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.internal.filter.ValueNode.JsonNode;

import net.minidev.json.parser.JSONParser;

@Import(MyTestConfiguration.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FlightService.class)
@SpringBootTest
public class FlightAipTest {

	@Autowired
	WebApplicationContext webContext;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}

	String expected = "{\r\n" + "    \"departureTime\": \"09:00\",\r\n" + "    \"destination\": \"Tobago\",\r\n"
			+ "    \"destinationAirportIATA\": \"TAB\",\r\n" + "    \"flightNo\": \"VS097\",\r\n"
			+ "    \"sunday\": \"15:15\",\r\n" + "    \"monday\": \" \",\r\n" + "    \"tuesday\": \" \",\r\n"
			+ "    \"wednesday\": \" \",\r\n" + "    \"thursday\": \" \",\r\n" + "    \"friday\": \" \",\r\n"
			+ "    \"saturday\": \".\"\r\n" + "}";
	
	


	@MockBean(name = "flightRepository")
	private FlightService flightService;

	@Test
	public void whenRequestFlightTiming() throws Exception {

		Mockito.when(flightService.findDepertureTime(Mockito.anyString())).thenReturn(checkFlight());
		RequestBuilder request = MockMvcRequestBuilders.get("/flights/planner/find-by-departure-/09:00")
				.accept("application/json");
		MvcResult result = mockMvc.perform(request).andReturn();
		System.out.println(result.getResponse());

		String jsonString = expected;

		ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.JsonNode actualObj = mapper.readTree(jsonString);		
		assertThat(actualObj, is(notNullValue()));
		assertThat(flightService.findDepertureTime("/flights/planner/find-by-departure-/09:00"), is(notNullValue()));				

	}

	
	private Flight checkFlight() {
		Flight flight = new Flight();
		flight.setDepartureTime("09:00");
		flight.setDestination("Tobago");
		flight.setDestinationAirportIATA("TAB");
		flight.setFlightNo("VS097");
		flight.setSunday("15:15");
		flight.setMonday("");
		flight.setTuesday("");
		flight.setWednesday("");
		flight.setThursday("");
		flight.setFriday("");
		flight.setSaturday("");
		return flight;
	}

}
