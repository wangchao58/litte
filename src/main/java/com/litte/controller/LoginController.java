package com.litte.controller;

import com.litte.entity.jurisdiction.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/portal/index")
    public String indexPortal() {
        return "html/portal/index";
    }

    @RequestMapping(value="/session/loginSession")
    @ResponseBody
    public TUser loginSession(HttpServletRequest request) {

        TUser user = (TUser) request.getSession().getAttribute("user");

        return user;
    }



}
