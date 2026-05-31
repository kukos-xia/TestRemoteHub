package com.kukos.yunpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kukos.yunpicturebackend.model.dto.user.UserQueryRequest;
import com.kukos.yunpicturebackend.model.dto.user.UserRegisterRequest;
import com.kukos.yunpicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kukos.yunpicturebackend.model.vo.LoginUserVo;
import com.kukos.yunpicturebackend.model.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author kukos
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-11-30 13:17:24
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    long userRegister(UserRegisterRequest userRegisterRequest);

    /**
     * 获取加密后的密码
     * @param password
     * @return
     */
    public String getEncryptedPassword(String password);


    /**
     *  用户登录
     * @param userAccount
     * @param userPassword
     * @param request
     * @return 脱敏后的信息
     */
    LoginUserVo userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获得脱敏后的信息封装类
     * @param user
     * @return
     */
    LoginUserVo getLoginUserVo(User user);


    /**
     * 在系统内部获取当前登录用户
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销 --删除session的用户id即可
     */
    boolean userLogout(HttpServletRequest request);


    /**
     * 获取脱敏后的单个用户信息
     * @param user
     * @return
     */
    UserVo getUserVo(User user);

    /**
     * 获取脱敏后的用户信息列表
     * @param users
     * @return
     */
    List<UserVo> getUserVoList(List<User> users);




    /**
     * 获取查询的条件
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);


    /**
     * 判断该用户是不是管理员身份
     * @param user
     * @return
     */
    boolean isAdmin(User user);
}
