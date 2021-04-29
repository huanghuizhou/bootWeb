package com.hhz.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Api(value = "demo", description = "demo详情")
@RestController
public class HhzController {


    @ApiOperation(value = "测试333", notes = "city333")
    @GetMapping(value = "test2")
    public String listAll2(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        return "123";
    }

}
