package com.example.pattern.VisitorPattern.demo1;

interface IElement {
    void accept(IVisitor visitor);
}
