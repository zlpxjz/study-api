package com.study;

import com.fasterapp.base.utils.StringUtil;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(StringUtil.isNullOrBlank(MDC.get("UUID"))) {
            String uuid = request.getHeader("log_trace_id");
            if (StringUtil.isNullOrBlank(uuid)) {
                uuid = StringUtil.getUUID();
            }
            MDC.put("UUID", uuid);
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        try {
            super.afterCompletion(request, response, handler, ex);
        }finally{
            MDC.clear();
        }
    }
}
