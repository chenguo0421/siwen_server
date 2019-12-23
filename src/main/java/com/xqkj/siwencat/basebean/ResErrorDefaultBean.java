package com.xqkj.siwencat.basebean;

public class ResErrorDefaultBean extends BaseResEntity{
    public ResErrorDefaultBean(IStatue statue){
        setCode(statue.getCode());
        setMsg(statue.getMsg());
    }
}
