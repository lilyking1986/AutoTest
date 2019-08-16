package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value="/getCookies",method= RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "gong xi ni huo de cookies";
    }
    @RequestMapping(value="/get/with/cookies")
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getWithParam(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "cookie is null !";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "cookie is suucess!!";
            }
        }
        return "cookie is not right !!";
    }
    @RequestMapping(value="/get/param",method=RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public Map<String,Integer> getShopList(@RequestParam Integer start,
    @RequestParam Integer end){
        Map<String,Integer> list = new HashMap<>();
        list.put("xiezi",400);
        list.put("juzi",100);
        list.put("cehnshan",200);
        list.put("pingguo",300);
        return list;
    }
    @RequestMapping(value="/get/param/{start}/{end}",method=RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public Map<String,Integer> getList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> list = new HashMap<>();
        list.put("xiezi",400);
        list.put("juzi",100);
        list.put("cehnshan",200);
        list.put("pingguo",300);
        return list;
    }
}
