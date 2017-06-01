package com.linxinhun.mo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class MoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoApplication.class, args);
	}

	@RequestMapping("/")
    public String getIndex(){
	    return "index";
    }
}
