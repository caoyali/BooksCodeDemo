package com.example.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 纸质书 154页
 */
public class LoggingException2 {
    private static Logger logger = Logger.getLogger("LoggingException2");

    static void logException(Exception e) {
        StringWriter stringWriter = new StringWriter();
        // printWriter 构造的时候需要一个 StringWriter！这块需要了解一下
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}
