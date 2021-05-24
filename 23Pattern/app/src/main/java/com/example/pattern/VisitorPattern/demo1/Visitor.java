package com.example.pattern.VisitorPattern.demo1;

class Visitor implements IVisitor{
    @Override
    public void visitStudent(StudentElement studentElement) {
        System.out.println("这个人是一位学生。 studentElement=" + studentElement);
    }

    @Override
    public void visitTeacher(TeacherElement teacherElement) {
        System.out.println("这个人是一位老师。 teacherElement=" + teacherElement);
    }
}
