package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/",description ="this is psot method")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ApiOperation(value="deng lu jie kou,cheng gong huo qu cookies xinxi",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value="userName",required=true) String  name ,
                        @RequestParam(value="password",required=true) String pwd){
        if (name.equals("zhangsan") && pwd.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登陆成功了!";
        }
        return "用户名或者是密码错误！";
    }
    @RequestMapping(value="/getUserList",method=RequestMethod.POST)
    @ApiOperation(value="deng lu jie kou,cheng gong huo qu cookies",httpMethod="POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user;

        Cookie[] cookies = request.getCookies();
        for(Cookie c:cookies){
            if (c.getName().equals("login") && c.getValue().equals("true")
            && u.getUserName().equals("zhangsan") && u.getPasssword().equals("123456")){
                user = new User();
                user.setName("list");
                user.setAge("20");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }


}

