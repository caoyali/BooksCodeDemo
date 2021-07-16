package com.example.pattern.BusinessDelegate.demo1;

public class BusinessDelegateDemo {
    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JM");
        client.doTask();
    }
}
