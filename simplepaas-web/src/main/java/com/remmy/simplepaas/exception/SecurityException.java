package com.remmy.simplepaas.exception;


import com.remmy.simplepaas.common.Status;

/**
 * @author yejiaxin
 */
public class SecurityException extends BaseException{
    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public SecurityException(Status status) {
        this(status.getCode(), status.getMessage(), null);
    }
}
