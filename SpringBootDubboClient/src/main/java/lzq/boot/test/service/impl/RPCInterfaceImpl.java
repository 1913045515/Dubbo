package lzq.boot.test.service.impl;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Reference;
import lzq.boot.test.entity.ResultInfo;
import lzq.boot.test.service.RPCInterface;
/**
 * RPC调用业务逻辑处理
 * @author linzhiqiang
 */
@Component
public class RPCInterfaceImpl implements RPCInterface {
    @Reference(version = "1.0.0")
    RPCInterface rpcInterface;//调用远程接口的实现类
    
	@Override
	public ResultInfo getRPCInfo() {
		ResultInfo resultInfo=rpcInterface.getRPCInfo();
		return resultInfo;
	}

}
