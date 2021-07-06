package com.remmy.simplepaas.exception;

import com.remmy.simplepaas.common.IStatus;

/**
 * 部署转换异常
 * @author yejiaxin
 */
public class DeployConvertException extends BaseException{
    public DeployConvertException(IStatus status) {
        super(status);
    }
}
