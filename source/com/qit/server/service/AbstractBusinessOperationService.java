package com.qit.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class AbstractBusinessOperationService {

    private final Logger logger = LoggerFactory.getLogger(AbstractBusinessOperationService.class);

    private Map<String, ? extends AbstractBusinessOperation> businessOperationMap;

    protected <T> T execute(String boId, Class<T> modelClass) {
        logger.trace("Execute BO {}", boId, modelClass);

        T model = null;

        for (Map.Entry<String, ? extends AbstractBusinessOperation> businessOperation : getBusinessOperationMap().entrySet()) {
            if (boId.equals(businessOperation.getKey())) {
                AbstractBusinessOperation abstractBusinessOperation = businessOperation.getValue();
                 model = (T) abstractBusinessOperation.internalInvoke(modelClass);
            }
        }

        if(model == null) {
            throw new IllegalStateException("Cannon find '" + boId + "' BO");
        }

        return model;
    }


    public Map<String, ? extends AbstractBusinessOperation> getBusinessOperationMap() {
        return businessOperationMap;
    }

    public void setBusinessOperationMap(Map<String, ? extends AbstractBusinessOperation> businessOperationMap) {
        this.businessOperationMap = businessOperationMap;
    }
}
