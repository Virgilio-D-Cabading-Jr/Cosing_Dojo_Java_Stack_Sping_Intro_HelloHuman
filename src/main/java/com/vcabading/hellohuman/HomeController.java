package com.vcabading.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name, 
						@RequestParam(value="last_name", required=false) String lastName) {
		if ((name == null) && (lastName == null)) {
			return "Hello Human";
		} else if (lastName == null) {
			return "Hello " + name;
		} else if (name == null) {
			return "Hello " + lastName;
		} else {
			return "Hello " + name + " " + lastName;
		}
	}
}
