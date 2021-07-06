package com.remmy.simplepaas.client.kubernetes.convert;

import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationStatus;

/**
 * @author yejiaxin
 */
public class DeploymentConverter implements Converter {
    @Override
    public ApplicationStatus status(ApplicationDefine app) {
        return null;
    }

    @Override
    public void apply(ApplicationDefine app) {

    }

    @Override
    public void delete(ApplicationDefine app) {

    }

    @Override
    public String getDeployMode() {
        return null;
    }
}
