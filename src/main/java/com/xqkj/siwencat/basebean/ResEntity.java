package com.xqkj.siwencat.basebean;


public class ResEntity extends BaseResEntity{

    private Object data = null;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResEntity(){};

    public ResEntity(IStatue statue,Object data) {
        setCode(statue.getCode());
        setMsg(statue.getMsg());
        this.data = data;
    }
}
