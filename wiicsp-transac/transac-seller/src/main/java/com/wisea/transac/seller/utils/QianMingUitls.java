package com.wisea.transac.seller.utils;

import java.util.List;

public class QianMingUitls {

	 public static String getqianming(List<String> list,String apiticket) throws Exception{


			String string = Sha1Uitls.sign(list, apiticket);
			return string;
	 }

}
