package com.bfwk.common.utils;

public class LimitClauseUtils {
	public static String makeLimitClause(Integer index,Integer size){
		return "limit "+index+" , "+size;
	}
}
