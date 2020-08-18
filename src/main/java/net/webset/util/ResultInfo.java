package net.webset.util;

public class ResultInfo<T> {
	
	private Integer status;
    private String message;
    private T response;
    
	public ResultInfo(Integer i, String string, T response) {
		this.status = i;
		this.message = string;
		this.response = response;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
}
