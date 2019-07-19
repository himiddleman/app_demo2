package com.allinpay.controller;

import com.alibaba.fastjson.JSON;
import com.allinpay.core.common.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/app2")
@Slf4j
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping({"/", "index"})
    public String index(HttpServletRequest request, HttpSession session, String ticket,
                        HttpServletResponse response) {
        String service = URLEncoder.encode("http://dev.allinpay.cn:8020/app2");
        String SSO_URL = "http://dev.allinpay.cn:8000/sso/loginpage";
        //success表示已登录
        String status = (String) session.getAttribute("status");
        if ("success".equals(status)) {
            return "index";
        }
        if (StringUtils.isBlank(ticket)) {
            //没有登录或登录失效 跳转登录页
            return "redirect:" + SSO_URL + "?service=" + service;
        } else {
            //调用sso服务判断ticked是否有效，有效则将登录状态置为有效
            Map map = new HashMap<>();
            map.put("ticket", ticket);
            map.put("service", service);
            ResponseData responseData = JSON.parseObject(restTemplate.getForObject("http://dev.allinpay.cn:8000/sso/validate?ticket={ticket}&service={service}", String.class,
                    map), ResponseData.class);

            if ("00000".equals(responseData.getCode())) {
                session.setAttribute("status", "success");
                //cookie
                Cookie cookie = new Cookie("name", "TG");
                cookie.setPath("/app2");
                response.addCookie(cookie);
                return "index";
            } else {
                return "redirect:" + SSO_URL + "?service=" + service;
            }
        }
    }
}
