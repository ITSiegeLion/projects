package com.ssm.store.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	
	/**
	 * 判断验证码输入是否正确
	 * @param reqeust
	 * @return
	 */
	public static boolean checkKaptcha(HttpServletRequest request) {
		String realVal = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String submitVal = HttpServletRequestUtil.getString(request, "kaptcha");
		if(submitVal==null || !realVal.equals(submitVal)) {
			return false;
		}
		return true;
	}
}
