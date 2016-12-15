package boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludos {
	
	@RequestMapping("/saludos")
	public String saludos(){
		return "mis saludos!!!";
	}

}
