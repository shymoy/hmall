package com.hmall.common.interceptors;

import cn.hutool.core.util.StrUtil;
import com.ctc.wstx.util.StringUtil;
import com.hmall.common.utils.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.desktop.PreferencesHandler;

/**
 * ClassName: UserInfoInterceptor
 * Package:com.hmall.common.interceptors
 * Description:
 *
 * @Author: shymoy
 * @Create: 2025/10/5 -15:46
 * @Version: v1.0
 */
public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取用户登录信息
        String userId = request.getHeader("user-info");
        // 2. 判断是否获取了用户， 如果有， 存入ThreadLocal
        if (StrUtil.isNotBlank(userId)) {
            UserContext.setUser(Long.valueOf(userId));
        }
        // 3. 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清理用户
        UserContext.removeUser();
    }
}
