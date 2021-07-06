package com.remmy.simplepaas.exception;

import com.remmy.simplepaas.common.IStatus;
import lombok.Data;

/**
 * @author yejiaxin
 */
@Data
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;
    private Object data;

    public BaseException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseException(Integer code,String message) {
        this(code, message, null);
    }

    public BaseException(IStatus status) {
        this(status, null);
    }

    public BaseException(IStatus status, Object data) {
        this(status.getCode(), status.getMessage(), data);
    }
}
