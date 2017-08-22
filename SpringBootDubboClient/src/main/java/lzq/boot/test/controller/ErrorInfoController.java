package lzq.boot.test.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//@RequestMapping("/error")
public class ErrorInfoController {
	@RequestMapping("/errorTest")
	public String errorTest(){
		return "errorpage/404";
	}
	
	@RequestMapping("/errorNginxTest")
	public String errorNginxTest(){
		return "404";
	}
}
