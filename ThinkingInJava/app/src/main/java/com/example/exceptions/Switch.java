package com.example.exceptions;

import com.example.util.print.Print;

public class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        Print.print(this);
    }

    public void off() {
        state = false;
        Print.print(this);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "state=" + state +
                '}';
    }
}
