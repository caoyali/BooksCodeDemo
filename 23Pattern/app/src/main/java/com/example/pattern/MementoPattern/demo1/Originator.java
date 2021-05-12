package com.example.pattern.MementoPattern.demo1;

class Originator {
    private StringBuilder mStr;

    public Originator() {
        this.mStr = new StringBuilder();
    }

    public void append(String s) {
        mStr.append(s);
    }

    public Memento takeMemento(){
        Memento memento = new Memento();
        memento.mStr = new StringBuilder(this.mStr.toString());
        return memento;
    }

    public void restore(Memento memento) {
        this.mStr = memento.mStr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"mStr\":")
                .append(mStr);
        sb.append('}');
        return sb.toString();
    }
}
