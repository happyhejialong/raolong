package com.bfwk.common;



public class WkResponse<T> {
	 private static final Integer SUCCESS_CODE = 200;
	    private static final String SUCCESS_MSG = "SUCCESS";
	    private Integer code = SUCCESS_CODE;
	    private String msg = SUCCESS_MSG;
	    private Result result = new Result();
	    
	    class Result{
	    	T data;

			public T getData() {
				return data;
			}

			public void setData(T data) {
				this.data = data;
			}
	    	
	    }

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

		public Result getResult() {
			return result;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		public static Integer getSuccessCode() {
			return SUCCESS_CODE;
		}

		public static String getSuccessMsg() {
			return SUCCESS_MSG;
		}
	    
	    
}
