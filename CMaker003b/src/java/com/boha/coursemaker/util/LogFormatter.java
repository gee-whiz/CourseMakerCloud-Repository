/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author aubreyM
 */
public class LogFormatter extends Formatter{

    @Override
    public String format(LogRecord record) {
        
        StringBuilder sb = new StringBuilder();
        sb.append("### ");
        sb.append(record.getMessage()).append(" [");
        sb.append(record.getSourceClassName())
                .append(" method: " )
                .append(record.getSourceMethodName()).append("] ");
        sb.append(sdf.format(new Date(record.getMillis()))).append("\n\n");
        if (record.getThrown() != null) {
            sb.append("\n\n").append(record.getThrown().toString());
        }
        return sb.toString();
    }
   
    static final Locale loc = Locale.getDefault();
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", loc);
}
