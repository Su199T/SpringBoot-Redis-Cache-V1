package com.javabootpro.appComponent.controllerResult;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一 Controller 返回的数据格式
 *
 * @author: Coder-Lcm
 * @date: 2020/8/12 17:33
 */
@Data
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = 2L;

    /**
     * 返回的信息(主要出错的时候使用)
     */
    private String msg;

    /**
     * 接口返回码, 0表示成功
     * 0   : 成功
     * >0 : 表示已知的异常(例如提示错误等, 需要调用地方单独处理)
     * <0 : 表示未知的异常(不需要单独处理, 调用方统一处理)
     */
    private Integer code;

    /**
     * 返回的数据
     */
    private T data;

    ResultDTO() {
        super();
    }

    public ResultDTO(String msg, RESULT_STATUS_CODE code) {
        super();
        this.msg = msg;
        this.code = code.getValue();
    }


    public ResultDTO(Throwable e, RESULT_STATUS_CODE code) {
        super();
        this.msg = e.toString();
        this.code = code.getValue();
    }

    public ResultDTO(String s, int i) {
        super();
        this.msg = s;
        this.code = i;
    }
}
