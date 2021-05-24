package com.example.pattern.VisitorPattern.demo1;

interface IVisitor {
    void visitStudent(StudentElement studentElement);
    void visitTeacher(TeacherElement teacherElement);
}
