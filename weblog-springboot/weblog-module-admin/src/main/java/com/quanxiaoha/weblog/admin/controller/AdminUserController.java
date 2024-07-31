package com.quanxiaoha.weblog.admin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanxiaoha.weblog.admin.model.vo.user.QueryUserDetailRspVO;
import com.quanxiaoha.weblog.admin.model.vo.user.UpdateAdminPasswordReqVO;
import com.quanxiaoha.weblog.admin.service.AdminBlogSettingService;
import com.quanxiaoha.weblog.admin.service.AdminUserService;
import com.quanxiaoha.weblog.common.Response;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import com.quanxiaoha.weblog.common.domain.dos.UserDO;
import com.quanxiaoha.weblog.common.utils.PasswordEncoder;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

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

    @Resource
    private AdminBlogSettingService blogSettingService;
    @Resource
    private AdminUserService userService;
    @Resource
    PasswordEncoder passwordEncoder;

    @PostMapping("/password/update")
    @ApiOperationLog(description = "修改用户密码")
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
    public Response<String> doLogin(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(request.getInputStream());
        String username = jsonNode.get("username").textValue();
        String password = jsonNode.get("password").textValue();
        Optional<UserDO> user = userService.lambdaQuery().eq(UserDO::getUsername, username).oneOpt();
        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            StpUtil.login("admin_" + user.get().getId());
            return Response.success(StpUtil.getSession().getTokenSignList().get(0).getValue());
        }
        return Response.fail("login fail, username or password error");
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
