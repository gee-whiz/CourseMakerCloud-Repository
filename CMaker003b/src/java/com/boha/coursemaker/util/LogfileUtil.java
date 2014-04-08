/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.servlet.AdministratorServlet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aubreyM
 */
public class LogfileUtil {

    static final Logger log = Logger.getLogger(LogfileUtil.class.getName());

    public static String getFileString() throws IOException {
        File file;
        file = new File("/Applications/NetBeans/glassfish-4.0/glassfish/domains/domain1/logs/server.log");
        if (!file.exists()) {
            file = new File("/opt/glassfish4/glassfish/domains/coursemaker-prod/logs/server.log");
        }

        log.log(Level.INFO, "Log file found: {0} size: {1}",
                new Object[]{file.getAbsolutePath(), file.length()});
        return getLatestLines(file);
    }

    /**
     * Load a text file contents as a
     * <code>String<code>.
     * This method does not perform enconding conversions
     *
     * @param file The input file
     * @return The file contents as a <code>String</code>
     * @exception IOException IO Error
     */
    public static String deserializeString(File file)
            throws IOException {
        int len;
        char[] chr = new char[4096];
        final StringBuilder buffer = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            while ((len = reader.read(chr)) > 0) {
                buffer.append(chr, 0, len);
            }
        }
        return buffer.toString();
    }

    public static String getLatestLines(File file) throws IOException {
        long s = System.currentTimeMillis();
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line + "\n");
            }
            int lastIndex = getLastIndex(list);
            for (int i = lastIndex; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogfileUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(LogfileUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long e = System.currentTimeMillis();
        log.log(Level.OFF, "Deserialized log file, elapsed: {0} seconds", AdministratorServlet.getElapsed(s, e));

        return sb.toString();
    }

    private static int getLastIndex(List<String> list) {
        int totalLines = list.size();
        if (totalLines < 100) {
            return 0;
        }
        int index = totalLines - 500;
        if (index < 0) index = 0;
        return index;
    }

    public static String lineByLine(File file) throws IOException {
        long s = System.currentTimeMillis();
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (list.isEmpty()) {
                    String text = stripExtraInfo(line);
                    if (text != null) {
                        list.add(text);
                    }
                } else {
                    String text = stripExtraInfo(line);
                    if (text != null) {
                        list.add(list.size() - 1, text);
                    }
                }
            }
            for (String string : list) {
                sb.append(string).append("\n");
            }
            return sb.toString();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogfileUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(LogfileUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long e = System.currentTimeMillis();
        log.log(Level.OFF, "Deserialized log file, elapsed: {0} seconds", AdministratorServlet.getElapsed(s, e));

        return sb.toString();
    }

    private static String stripExtraInfo(String line) {
        if (line.contains("[[")) {
            return null;
        }
        if (line.isEmpty()) {
            return null;
        }
        if (line.contains("]]")) {
            int i = line.indexOf("]]");
            if (i == -1) {
                return null;
            }
            String text = line.substring(0, i);
            if (text.contains("index:")) {
                return null;
            }
            String text2 = text;
            if (text.contains("\t")) {
                i = text.indexOf("\t");
                text2 = text.substring(i + 1);
                //log.log(Level.OFF, "text has a tab character - {0}", text);
            }
            return text2;
        }

        return null;
    }
}
