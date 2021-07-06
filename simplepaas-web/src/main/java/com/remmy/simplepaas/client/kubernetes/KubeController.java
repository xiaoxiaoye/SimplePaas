package com.remmy.simplepaas.client.kubernetes;

import com.remmy.simplepaas.client.kubernetes.convert.Converter;
import com.remmy.simplepaas.dto.DeployMode;
import com.remmy.simplepaas.model.ApplicationDefine;
import com.remmy.simplepaas.model.ApplicationStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yejiaxin
 */
@Component
public class KubeController implements Converter {

    private final Map<String, Converter> converters = new HashMap<>();

    public KubeController(List<Converter> converters) {
        for (Converter converter:  converters){
            this.converters.put(converter.getDeployMode(), converter);
        }
    }

    private Converter getConverter(String deployMode) {
        if (this.converters.containsKey(deployMode)) {
            return converters.get(deployMode);
        }
        return converters.get(DeployMode.NONE.getMode());
    }

    @Override
    public ApplicationStatus status(ApplicationDefine app) throws Exception{
        return getConverter(app.getDeployMode()).status(app);
    }

    @Override
    public void apply(ApplicationDefine app) throws Exception{
        getConverter(app.getDeployMode()).apply(app);
    }

    @Override
    public void delete(ApplicationDefine app) throws Exception {
        getConverter(app.getDeployMode()).delete(app);
    }

    @Override
    public String getDeployMode() {
        return null;
    }
}
