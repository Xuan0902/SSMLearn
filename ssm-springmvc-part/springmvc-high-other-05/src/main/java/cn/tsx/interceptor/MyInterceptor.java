package cn.tsx.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description: 拦截器
 **/

public class MyInterceptor implements HandlerInterceptor {
    // 执行handler之前！调用的拦截方法！！
    // 编码格式设置，登录保护，权限处理

    /**
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  handler就是我们要调用的方法
     * @return true 放行 false 拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandle");
        return true;
    }

    /**
     * 当handler方法执行完毕后，触发的方法，没有拦截机制了
     * 此方法只有preHandler返回true的时候才会执行
     * eg:对敏感词汇处理 对结果处理
     *
     * @param request      请求对象
     * @param response     响应对象
     * @param handler      handler方法
     * @param modelAndView 视图和共享域数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
