package cn.itsource.xigou.controller;

import cn.itsource.xigou.utils.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    /**
     * 因为前端使用vue，所以使用axios发送ajax请求
     * axios发送post请求，参数以json体的形式发送
     * @param params
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录接口")
    public AjaxResult login(@RequestBody Map<String, Object> params) {

        String username = (String) params.get("username");
        String password = (String) params.get("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            //登录成功
            return AjaxResult.me();
        } else {
            //登录失败
            return AjaxResult.me().setSuccess(false).setMessage("用户名或密码错误!");
        }
    }
}
