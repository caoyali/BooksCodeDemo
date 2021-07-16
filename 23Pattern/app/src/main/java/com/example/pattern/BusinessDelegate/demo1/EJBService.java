package com.example.pattern.BusinessDelegate.demo1;

public class EJBService implements IBusinessService{
    @Override
    public void doProcessing() {
        System.out.println("Processing task by EJBService!");
    }
}
