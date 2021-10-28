package com.study.common;

import com.study.sys.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tony on 2021/10/28.
 */
public class SessionContext {
	private static final String HEADER_USER_ID = "user_id";
	private static final String HEADER_USER_TOKEN = "user_token";

	private static IUserService userProfileService;

	@Autowired
	public void setUserProfileService(IUserService userProfileService){
		SessionContext.userProfileService = userProfileService;
	}

	public static String getUserId(){
		return getHeader(HEADER_USER_ID);
	}

	public static String getUserToken(){
		return getHeader(HEADER_USER_TOKEN);
	}

	public static String getHeader(String key){
		HttpServletRequest request = getRequest();
		return request.getHeader(key).trim();
	}

	/**
	 * 获取订单
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
	}
}
