package com.mall.util;
import java.util.UUID;

public class RandomId {
	  public static String getRandomNumbers() {
		   String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		   return uuid;
	    }
	

}
