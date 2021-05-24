package com.example.pattern.VisitorPattern.demo1;

class StudentElement implements IElement{
    private String name;
    private int grade;
    private int paperCount;

    public StudentElement(String name, int grade, int paperCount) {
        this.name = name;
        this.grade = grade;
        this.paperCount = paperCount;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\n\"grade\":")
                .append(grade);
        sb.append(",\n\"paperCount\":")
                .append(paperCount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitStudent(this);
    }
}
