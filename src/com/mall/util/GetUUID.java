/**
 * 
 */
package com.mall.util;

import java.util.UUID;

/**
 * 获取UUID
 * @author chen
 *
 * 2017年9月19日
 */
public class GetUUID {
	public String getUUID(){
		String uuid=UUID.randomUUID().toString();
		uuid=uuid.replace("-","");
		uuid=uuid.substring(3, 13);
		return uuid;
	}
}
