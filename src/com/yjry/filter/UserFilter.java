package com.yjry.filter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "userFilter", urlPatterns = {"/doExp"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null){
            PrintWriter out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg", "你还未登录，请登录后再试");
            jsonObject.put("flag", 0);
            out.println(jsonObject.toJSONString());
        }else{
            filterChain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {
    }
}
