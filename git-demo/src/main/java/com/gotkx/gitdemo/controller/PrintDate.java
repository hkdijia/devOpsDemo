package com.gotkx.gitdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PrintDate {


    @RequestMapping("/printDate")
    @ResponseBody
    public String printPort() {
        return "当前访问时间：" + new Date();
    }

}
