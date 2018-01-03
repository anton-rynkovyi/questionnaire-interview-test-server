package com.qit.server.service;

public abstract class AbstractBusinessOperation<E>  {

    protected abstract E internalInvoke(E modelClass);

}
