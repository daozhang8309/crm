package com.powernode.crm.settings.web.controller;

import com.powernode.crm.commons.contants.Contants;
import com.powernode.crm.commons.domain.ReturnObject;
import com.powernode.crm.commons.utils.DateUtils;
import com.powernode.crm.settings.domain.User;
import com.powernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin(){
        return "settings/qx/user/login";
    }

    @RequestMapping("/settings/qx/user/login.do")
    @ResponseBody()
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //封装参数
        Map<String,Object> map = new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User user = userService.queryUserByLoginAndPwd(map);
        ReturnObject returnObject = new ReturnObject();
        //根据返回信息，生成响应信息
        if (user == null) {
            //登录失败，账号或密码错误
            returnObject.setCode("0");
            returnObject.setMessage("账号或密码错误");
        }else {//账号密码正确，但是需要进一步验证其他信息
            String nowStr = DateUtils.formateDateTime(new Date());
            if (nowStr.compareTo(user.getExpireTime()) >0 ){//判断账号是否过期，比较数据库中的字段与现在的时间比较
                //大于0，意味着现在的时间靠后，已经过期
                //登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号已过期");
            }else if ("0".equals(user.getLockState())){//判断账号是否锁定
                //等于0，意味着账号锁定，登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号锁定");
            }else if (!user.getAllowIps().contains(request.getRemoteAddr())){//客户端ip是否受限
                //在数据库中的ip不包括请求传来的ip，登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("ip受限");
            }else {
                //登录成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                //把响应的对象存储在session中
                session.setAttribute(Contants.SESSION_USER,user);

                //记住密码，往浏览器上写入cookie
                if ("true".equals(isRemPwd)){
                    Cookie cookieAct = new Cookie("loginAct", user.getLoginAct());
                    cookieAct.setMaxAge(60*60*24*10);
                    response.addCookie(cookieAct);

                    Cookie cookiePwd = new Cookie("loginPwd", user.getLoginPwd());
                    cookiePwd.setMaxAge(60*60*24*10);
                    response.addCookie(cookiePwd);

                }else {//生命周期为0，自动删除
                    Cookie cookieAct = new Cookie("loginAct", "1");
                    cookieAct.setMaxAge(0);
                    response.addCookie(cookieAct);

                    Cookie cookiePwd = new Cookie("loginPwd", "1");
                    cookiePwd.setMaxAge(0);
                    response.addCookie(cookiePwd);
                }
            }
        }
        return returnObject;
    }

    @RequestMapping("/settings/qx/user/logout.do")
    public String logout(HttpServletResponse response,HttpSession session){
        //删除cookie和session
        Cookie cookieAct = new Cookie("loginAct", "1");
        cookieAct.setMaxAge(0);
        response.addCookie(cookieAct);

        Cookie cookiePwd = new Cookie("loginPwd", "1");
        cookiePwd.setMaxAge(0);
        response.addCookie(cookiePwd);

        session.invalidate();

        //跳转登录页面,要显示登录页面的地址，使用重定向
        return "redirect:/";

    }
}
