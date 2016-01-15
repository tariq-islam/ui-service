package AngularBoot;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class EndpointsRestController {

	@RequestMapping(value = "/endpoints/wine", method = POST)
	public String createWine(final @RequestBody String wineParams) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(
				wineParams.toString(), headers);
		restTemplate.exchange("http://wine:8080/wine", HttpMethod.POST, entity,
				String.class);
		return wineParams;
	}

	@RequestMapping(value = "/endpoints/food", method = POST)
	public String createFood(final @RequestBody String foodParams) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(
				foodParams.toString(), headers);
		restTemplate.exchange("http://food:8080/food", HttpMethod.POST, entity,
				String.class);
		return foodParams;
	}

	@RequestMapping(value = "/endpoints/wine", method = GET)
	public String getWines() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(
				"http://wine:8080/wine", String.class);
		String wines = responseEntity.getBody();
		return wines;

	}

	@RequestMapping(value = "/endpoints/food", method = GET)
	public String getFood() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(
				"http://food:8080/food", String.class);
		String food = responseEntity.getBody();
		return food;

	}

}
