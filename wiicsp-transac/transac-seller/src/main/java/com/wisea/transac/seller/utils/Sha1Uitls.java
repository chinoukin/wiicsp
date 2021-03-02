package com.wisea.transac.seller.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.util.Collections;
import java.util.List;

/**
 *
 * [sha1加密排序工具类]
 * [功能详细描述]
 *
 * @author  fwq
 * @version  [v1.0, 2017年11月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Sha1Uitls {

	public static String sign(List<String> values, String ticket) {
	    if (values == null) {
	        throw new NullPointerException("values is null");
	    }

	    values.removeAll(Collections.singleton(null));// remove null
	    values.add(ticket);


	    Collections.sort(values);

	    StringBuilder sb = new StringBuilder();
	    for (String s : values) {
	        sb.append(s);

	    }

	    return Hashing.sha1().hashString(sb, Charsets.UTF_8).toString().toUpperCase();
	}

}
