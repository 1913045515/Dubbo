package lzq.boot.test.entity;
import java.io.Serializable;
/**
 * 返回结果实体类
 * @author linzhiqiang
 *
 */
public class ResultInfo implements Serializable{
    private static final long serialVersionUID = -1L;
	private String resultInfo;
	
	public ResultInfo(String resultInfo) {
		super();
		this.resultInfo = resultInfo;
	}

	public ResultInfo() {
		super();
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	};
	
}
