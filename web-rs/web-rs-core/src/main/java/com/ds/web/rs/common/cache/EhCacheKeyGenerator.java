package com.ds.web.rs.common.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Sarvesh.Dubey@hotmail.com
 *
 */
@Component
public class EhCacheKeyGenerator implements KeyGenerator {
	
	@Override
	public Object generate(Object target, Method method, Object... params) {
		int key = (31 * target.getClass().hashCode()) + method.getName().hashCode();
		for (Object param : params) {
			if(null != param)
				key = key + param.hashCode();
		}
		return key;
	}

}
