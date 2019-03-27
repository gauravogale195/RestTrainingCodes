package com.acc.companyBasicNew;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class DepartmentConverterProvider implements ParamConverterProvider{
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.equals(Department.class)){
            return (ParamConverter<T>) new DepartmentParamConverter();
        }
        return null;
    }
}