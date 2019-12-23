package com.xqkj.siwencat.controller.portal.register;

import com.xqkj.siwencat.basebean.IStatue;
import com.xqkj.siwencat.basebean.ResEntity;
import com.xqkj.siwencat.basebean.ResErrorDefaultBean;
import com.xqkj.siwencat.controller.database.UserController;
import com.xqkj.siwencat.models.database.User;
import com.xqkj.siwencat.models.portal.register.*;
import com.xqkj.siwencat.utils.Constants;
import com.xqkj.siwencat.utils.RandomUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {

    private final HttpServletRequest request;

    private final UserController userController;
    private RandomUtils util;

    public RegisterController(HttpServletRequest request, UserController userController) {
        this.request = request;
        this.userController = userController;
        util = new RandomUtils();
    }

    @PostMapping("/register/getPhoneToken")
    public ResEntity getPhoneToken(@RequestBody ReqPhoneTokenBean requestParams){
        int authCode = util.getRandomCode();
        request.getSession().setAttribute(Constants.AUTH_KEY,authCode+"");
        request.getSession().setAttribute(Constants.IMEI_KEY,requestParams.getImei());
        request.getSession().setAttribute(Constants.PHONE_KEY,requestParams.getPhone());
        return new ResEntity(IStatue.SUCCESS,new ResPhoneTokenBean(authCode));
    }

    @PostMapping("/register/checkPhone")
    public ResEntity checkPhone(@RequestBody ReqRegisterBean requestParams){
        if (requestParams.getPhone().equals(request.getSession().getAttribute(Constants.PHONE_KEY))
                &&requestParams.getAuthCode().equals(request.getSession().getAttribute(Constants.AUTH_KEY))
                && requestParams.getImei().equals(request.getSession().getAttribute(Constants.IMEI_KEY))) {
            String random8 = util.getRandomCode_8()+"";
            String md5 = util.getMD5(random8);
            request.getSession().setAttribute(Constants.PSW_MODIFY_KEY, random8);
            return new ResEntity(IStatue.SUCCESS, new ResCheckPhoneBean(md5));
        }
        return new ResEntity(IStatue.PARAMS_ERROR,new ResErrorDefaultBean(IStatue.PARAMS_ERROR_AUTH_CODE));
    }

    @PostMapping("/register/psw")
    public ResEntity psw(@RequestBody ReqRegisterPswBean requestParams){
        if (requestParams.getPhone().equals(request.getSession().getAttribute(Constants.PHONE_KEY))
                && requestParams.getImei().equals(request.getSession().getAttribute(Constants.IMEI_KEY))
                && requestParams.getRandomKey().equals(util.getMD5(request.getSession().getAttribute(Constants.PSW_MODIFY_KEY).toString()))
        ) {
            try {
                User user = new User();
                user.setUsername(requestParams.getPhone());
                user.setPassword(requestParams.getPsw());
                user.setTel(requestParams.getPhone());
                user.setSex("unknow");
                userController.insert(user);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResEntity(IStatue.DATABASE_ERROR, new ResErrorDefaultBean(IStatue.DATABASE_ERROR));
            }
            return new ResEntity(IStatue.SUCCESS, new ResRegisterBean(requestParams.getPhone()));
        }
        return new ResEntity(IStatue.PARAMS_ERROR,new ResErrorDefaultBean(IStatue.PARAMS_ERROR));
    }
}
