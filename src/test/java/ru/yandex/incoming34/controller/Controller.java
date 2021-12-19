package ru.yandex.incoming34.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.yandex.incoming34.models.Product;
import ru.yandex.incoming34.service.Service;

@Api
@RestController
@RequestMapping("/main")
public class Controller {
	
	Service service;
	
	@Autowired
	public Controller(Service service) {
		this.service = service;
	}
	
	//@ResponseBody
	@RequestMapping(path = "/show", method = RequestMethod.GET)
	public JsonNode showProducts() throws JsonProcessingException, IOException, JSONException {
		return  service.getProducts();
	}

}
