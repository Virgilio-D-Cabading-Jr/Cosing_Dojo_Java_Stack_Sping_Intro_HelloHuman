package com.vcabading.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name, 
						@RequestParam(value="last_name", required=false) String lastName,
						@RequestParam(value="times", required=false) String stringTimes) {
		String output = "";
		if ((name == null) && (lastName == null))  {
			output = "Human";
		} else if (lastName == null) {
			output = name;
		} else if (name == null) {
			output = lastName;
		} else {
			output = name + " " + lastName;
		}
		if (stringTimes != null) {
			if (HomeController.isNumeric(stringTimes)) {
				int times = Integer.parseInt(stringTimes);
				String tempOutput = output;
				for (int i=1; i<times; i++) {
					output += " " + tempOutput;
				}
			}
		}		
		return "Hell " + output;
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
