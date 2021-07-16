package com.example.pattern.BusinessDelegate.demo1;

public class BusinessDelegate {
    private BusinessLookupFactory businessLookup = new BusinessLookupFactory();
    private IBusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = businessLookup.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
