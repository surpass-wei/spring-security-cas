package com.surpass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by surpass.wei@gmail.com on 2017/7/26.
 */
@Controller
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "不验证哦";
    }

    @PreAuthorize("hasAuthority('TEST')")//有TEST权限的才能访问
    @RequestMapping("/security")
    @ResponseBody
    public String security() {
        return "hello world security";
    }

    @PreAuthorize("hasAuthority('ADMIN')")//必须要有ADMIN权限的才能访问
    @RequestMapping("/authorize")
    @ResponseBody
    public String authorize() {
        return "有权限访问";
    }
}
