package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RouteController {
	
	@Autowired
	RouteCalculator routeCalculator; 

	@RequestMapping("/direct")
    DirectResponse direct(@RequestParam("dep_sid") int depSid,@RequestParam("arr_sid") int arrSid) {
		return routeCalculator.calculateDirectRoute(depSid, arrSid);
    }
}
