package com.xqkj.siwencat.controller.portal.register;

import com.xqkj.siwencat.basebean.ErrorResEntity;
import com.xqkj.siwencat.basebean.ResEntity;
import com.xqkj.siwencat.basebean.SuccessResEntity;
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

    public RegisterController(HttpServletRequest request) {
        this.request = request;
    }

    @PostMapping("/register/getPhoneToken")
    public ResEntity getPhoneToken(@RequestBody ReqPhoneTokenBean requestParams){
        int authCode = new RandomUtils().getRandomCode();
        request.getSession().setAttribute(Constants.SESSION_KEY,authCode+"");
        return new ResEntity(SuccessResEntity.RES_CODE, SuccessResEntity.RES_MSG,new ResPhoneTokenBean(authCode));
    }

    @PostMapping("/register/checkPhone")
    public ResEntity checkPhone(@RequestBody ReqRegisterBean requestParams){
        if (requestParams.getAuthCode().equals(request.getSession().getAttribute(Constants.SESSION_KEY))){
            request.getSession().setAttribute(Constants.PHONE_KEY,requestParams.getPhone());
            return new ResEntity(SuccessResEntity.RES_CODE, SuccessResEntity.RES_MSG,requestParams);
        }
        return new ResEntity(SuccessResEntity.RES_CODE, SuccessResEntity.RES_MSG,new ErrorResEntity());
    }

    @PostMapping("/register/psw")
    public ResEntity psw(@RequestBody ReqRegisterPswBean requestParams){
        if (requestParams.getPhone().equals(request.getSession().getAttribute(Constants.PHONE_KEY))){
            UserController userController = new UserController();
            User user = new User();
            user.setUsername(requestParams.getPhone());
            user.setPassword(requestParams.getPsw());
            user.setTel(requestParams.getPhone());
            userController.insert(user);
            return new ResEntity(SuccessResEntity.RES_CODE, SuccessResEntity.RES_MSG,requestParams);
        }
        return new ResEntity(SuccessResEntity.RES_CODE, SuccessResEntity.RES_MSG,new ErrorResEntity());
    }
}
