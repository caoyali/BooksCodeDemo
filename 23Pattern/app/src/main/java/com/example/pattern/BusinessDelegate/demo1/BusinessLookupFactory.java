package com.example.pattern.BusinessDelegate.demo1;

public class BusinessLookupFactory {
    //其实这个是一个工厂
    public IBusinessService getBusinessService(String type) {
        if ("EJB".equals(type)) {
            return new EJBService();
        } else {
            return new JMService();
        }
    }

}
