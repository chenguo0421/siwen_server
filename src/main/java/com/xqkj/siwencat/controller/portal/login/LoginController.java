package com.xqkj.siwencat.controller.portal.login;

import com.xqkj.siwencat.basebean.IStatue;
import com.xqkj.siwencat.basebean.ResEntity;
import com.xqkj.siwencat.basebean.ResErrorDefaultBean;
import com.xqkj.siwencat.controller.database.UserController;
import com.xqkj.siwencat.models.database.User;
import com.xqkj.siwencat.models.portal.login.LoginUserBean;
import com.xqkj.siwencat.models.portal.login.ReqLoginBean;
import com.xqkj.siwencat.models.portal.login.ResLoginBean;
import com.xqkj.siwencat.utils.Constants;
import com.xqkj.siwencat.utils.RandomUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    private final HttpServletRequest request;

    private final UserController userController;
    private RandomUtils util;
    public LoginController(HttpServletRequest request, UserController userController) {
        this.request = request;
        this.userController = userController;
        util = new RandomUtils();
    }

    @PostMapping("/login")
    public ResEntity getPhoneToken(@RequestBody ReqLoginBean requestParams){
        if (!StringUtils.isEmpty(requestParams.getUserName()) && !StringUtils.isEmpty(requestParams.getPsw())){
            User user = userController.selectByUserName(requestParams.getUserName());
            if (user != null && user.getPassword().equals(requestParams.getPsw())) {
                LoginUserBean bean = new LoginUserBean();
                bean.setUserName(user.getUsername());
                bean.setPsw(user.getPassword());
                String salt = util.getRandomCode()+"";
                bean.setSalt(salt);
                String token = util.getMD5(salt);
                bean.setToken(token);
                request.getSession().setAttribute(Constants.LOGIN_USER_KEY,bean);
                return new ResEntity(IStatue.SUCCESS,new ResLoginBean(user.getUsername(),token,salt));
            }
        }
        return new ResEntity(IStatue.PARAMS_ERROR,new ResErrorDefaultBean(IStatue.PARAMS_ERROR));
    }
}
