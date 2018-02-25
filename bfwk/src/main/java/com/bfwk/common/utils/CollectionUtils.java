package com.bfwk.common.utils;

import java.util.Collection;
import java.util.List;

import org.springframework.util.ObjectUtils;

public class CollectionUtils {
	public static <T> T getFirst(List<T> col){
		return (ObjectUtils.isEmpty(col) || col.size()==0)?null:col.get(0);
	}
}
