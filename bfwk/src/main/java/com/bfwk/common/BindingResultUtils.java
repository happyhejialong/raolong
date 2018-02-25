package com.bfwk.common;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.bfwk.exception.WkException;

public class BindingResultUtils {
	/***
	 * 捕获校验异常
	 * @param result
	 * @throws WkException 
	 */
	public static  void cacheError(BindingResult result) throws WkException{
		if(result.hasErrors()){
			String errorField="";
			List<ObjectError> errors=result.getAllErrors();
			for(ObjectError error:errors){
				errorField+=error.getObjectName()+" ";
			}
			throw new WkException(errorField);
		}	
	}
}
