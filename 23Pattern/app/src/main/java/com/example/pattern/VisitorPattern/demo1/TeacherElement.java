package com.example.pattern.VisitorPattern.demo1;

class TeacherElement implements IElement{
    private String name;
    private int score;
    private int paperCount;

    public TeacherElement(String name, int score, int paperCount) {
        this.name = name;
        this.score = score;
        this.paperCount = paperCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
        sb.append(",\n\"score\":")
                .append(score);
        sb.append(",\n\"paperCount\":")
                .append(paperCount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitTeacher(this);
    }
}
