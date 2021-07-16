package com.example.pattern.BusinessDelegate.demo1;

public class JMService implements IBusinessService{
    @Override
    public void doProcessing() {
        System.out.println("Processing task by JMService!");
    }
}
