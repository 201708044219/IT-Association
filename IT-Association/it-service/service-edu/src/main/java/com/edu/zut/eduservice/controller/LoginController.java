package com.edu.zut.eduservice.controller;

import com.edu.zut.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.eduservice.controller
 * @description: 登陆
 * @date 2021-02-18 14:22
 **/
@RestController
@RequestMapping("teachermanage/user")
@CrossOrigin
public class LoginController {

    //login
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }
    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
