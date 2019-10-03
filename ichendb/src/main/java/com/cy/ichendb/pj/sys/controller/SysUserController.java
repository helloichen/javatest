package com.cy.ichendb.pj.sys.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.ichendb.pj.common.vo.JsonResult;
import com.cy.ichendb.pj.common.vo.PageObject;
import com.cy.ichendb.pj.sys.entity.SysUser;
import com.cy.ichendb.pj.sys.service.SysUserService;
import com.cy.ichendb.pj.sys.vo.SysUserDeptVo;

@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
        PageObject<SysUserDeptVo> pageObject = sysUserService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(@Valid SysUser entity, Integer[] roleIds) {
        sysUserService.saveObject(entity, roleIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id) {
        Map<String, Object> map = sysUserService.findObjectById(id);
        return new JsonResult(map);
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysUser entity, Integer[] roleIds) {
        sysUserService.updateObject(entity, roleIds);
        return new JsonResult("update ok");
    }

    @RequestMapping("doValidById")
    public JsonResult doValidById(Integer id, Integer valid) {
        sysUserService.validById(id, valid, "admin");// "admin"用户将来是登陆用户
        return new JsonResult("update ok");
    }

    @RequestMapping("doLogin")
    public JsonResult doLogin(String username, String password) {
        //1.获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //2.通过subject提交用户信息,交给shiro框架进行认证操作
        //2.1对用户进行封装
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //2.2对用户信息进行身份认证
        subject.login(token);
        //分析:
        //1)token会传给shiro的SecurityManager
        //2)SecurityManager将token传递给认证管理器
        //3)认证管理器会将token传递给realm
        return new JsonResult("login ok");
    }
}
