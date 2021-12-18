package ru.yandex.incoming34.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("/main")
public class Controller {
	
	@ResponseBody
	@RequestMapping(path = "/show", method = RequestMethod.GET)
	public String showProducts() {
		return "Product";
	}

}
