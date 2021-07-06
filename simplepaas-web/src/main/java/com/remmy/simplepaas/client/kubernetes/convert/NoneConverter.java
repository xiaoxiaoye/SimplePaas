package com.remmy.simplepaas.client.kubernetes.convert;

import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationStatus;
import com.remmy.simplepaas.dto.DeployMode;
import com.remmy.simplepaas.common.Status;
import com.remmy.simplepaas.exception.DeployConvertException;
import org.springframework.stereotype.Component;

@Component
public class NoneConverter implements Converter{
    @Override
    public ApplicationStatus status(ApplicationDefine app) {
        throw new DeployConvertException(Status.CONVERT_NOT_SUPPORT);
    }

    @Override
    public void apply(ApplicationDefine app) {
        throw new DeployConvertException(Status.CONVERT_NOT_SUPPORT);
    }

    @Override
    public void delete(ApplicationDefine app) {
        throw new DeployConvertException(Status.CONVERT_NOT_SUPPORT);
    }

    @Override
    public String getDeployMode() {
        return DeployMode.NONE.getMode();
    }
}
