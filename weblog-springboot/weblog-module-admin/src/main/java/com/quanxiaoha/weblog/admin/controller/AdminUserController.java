package com.quanxiaoha.weblog.admin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.quanxiaoha.weblog.admin.model.vo.user.QueryUserDetailRspVO;
import com.quanxiaoha.weblog.admin.model.vo.user.UpdateAdminPasswordReqVO;
import com.quanxiaoha.weblog.admin.service.AdminBlogSettingService;
import com.quanxiaoha.weblog.admin.service.AdminUserService;
import com.quanxiaoha.weblog.common.Response;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lcq
 * @url: www.lingcq.online
 * @date: 2023-04-19 16:06
 * @description: TODO
 **/
@Api(tags = "admin用户模块")
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminBlogSettingService blogSettingService;
    @Autowired
    private AdminUserService userService;

    @PostMapping("/password/update")
    @ApiOperationLog(description = "修改用户密码")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response updateAdminPassword(@RequestBody @Validated UpdateAdminPasswordReqVO updateAdminPasswordReqVO) {
        return userService.updateAdminPassword(updateAdminPasswordReqVO);
    }

    @PostMapping("/detail")
    @ApiOperationLog(description = "获取登录用户信息")
    public Response<QueryUserDetailRspVO> queryAdminDetail() {
        return blogSettingService.queryNicknameAndAvatar();
    }

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("/login")
    public Response<String> doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return Response.success("登录成功");
        }
        return Response.fail("登录失败");
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @RequestMapping("/logout")
    public String logout() {
        StpUtil.logout();
        return "登出成功";
    }

}
