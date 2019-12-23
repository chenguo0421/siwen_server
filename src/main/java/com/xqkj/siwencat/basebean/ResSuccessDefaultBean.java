package com.xqkj.siwencat.basebean;

public class ResSuccessDefaultBean extends BaseResEntity{
    public ResSuccessDefaultBean(IStatue statue){
        setCode(statue.getCode());
        setMsg(statue.getMsg());
    }

}
