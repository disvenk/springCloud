package com.zuul.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr.Yangxiufeng on 2017/12/25.
 * Time:15:39
 * ProjectName:Mirco-Service-Skeleton
 */
@Component
public class PreRequestFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(PreRequestFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }//pre表示在所有请求前拦截

    @Override
    public int filterOrder() {
        return 0;//当有多个过滤器时，int值来定义过滤器的执行顺序，数值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }//是否需要过滤

    //编写过滤器业务逻辑代码
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if(token!=null && !"".equals(token)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("request is not allow");
            ctx.setResponseStatusCode(401);
            return null;
        }

       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LOG.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }
}
