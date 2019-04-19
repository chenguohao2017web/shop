package net.shop.result;

public class JsonResult {
	private Integer code;
	private String msg;
	private Object data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public JsonResult(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//成功返回
	public static JsonResult success(Object data) {
		return new JsonResult(0,"成功",data);
	}


	
}