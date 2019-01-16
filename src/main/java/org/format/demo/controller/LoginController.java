package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/16 14:41
 * @Description:
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    //@RequestMapping(value = {"/", ""})
    @RequestMapping(value = {"login"})
    @ResponseBody
    public String login() {
        return "login";
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam String username, HttpServletRequest req) {
        req.getSession().setAttribute("loginUser", username);
        return "redirect:/";
    }

    @RequestMapping("/out")
    public String out(HttpServletRequest req) {
        req.getSession().removeAttribute("loginUser");
        return "redirect:/login/login";
    }

}