package lzq.boot.test.service;
/**
 * RPC调用接口
 * @author linzhiqiang
 *
 */

import lzq.boot.test.entity.ResultInfo;

public interface RPCInterface {
	/**
	 * 通过Dubbo实现远程RPC调用接口信息
	 * @return
	 */
	public ResultInfo getRPCInfo();
}
