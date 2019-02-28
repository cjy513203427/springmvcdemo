package org.format.demo.custom;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 谷天乐
 * @Date: 2019/2/28 10:41
 * @Description:
 */
public class ImplementedCorsFilter implements Filter{
    //允许的请求域
    private String allowedOrigins;
    //允许的请求方法
    private String allowedMethods;
    //允许的请求头
    private String allowedHeaders;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.allowedOrigins = filterConfig.getInitParameter("allowedOrigins");
        this.allowedMethods = filterConfig.getInitParameter("allowedMethods");
        this.allowedHeaders = filterConfig.getInitParameter("allowedHeaders");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse rsp = (HttpServletResponse) response;
        rsp.setHeader("Access-Control-Allow-Origin", allowedOrigins);
        rsp.setHeader("Access-Control-Allow-Methods", allowedMethods);
        rsp.setHeader("Access-Control-Allow-Headers", allowedHeaders);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}