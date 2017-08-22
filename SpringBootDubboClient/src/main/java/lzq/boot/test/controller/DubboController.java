package lzq.boot.test.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lzq.boot.test.entity.ResultInfo;
import lzq.boot.test.service.RPCInterface;
/**
 * Dubbo测试
 * @author linzhiqiang
 *
 */
@Controller
public class DubboController {
	@Autowired
	private RPCInterface rpcInterface;
	@RequestMapping("/dubbo")
	@ResponseBody
	public String errorNginxTest(){
		ResultInfo resultInfo=rpcInterface.getRPCInfo();
		return "result:"+resultInfo.getResultInfo();
	}
}
