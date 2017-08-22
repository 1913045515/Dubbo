package lzq.boot.test.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/BootTest")
public class TestController {
	@RequestMapping("test1")
	@ResponseBody
	public String test(){
		return "test1";
	}
}
