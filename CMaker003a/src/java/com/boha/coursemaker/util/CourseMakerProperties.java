/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aubrey Malabie
 */
public class CourseMakerProperties {

    public static File getTemporaryDir() {
        getProperties();
        File d = new File(props.getProperty("tempDir"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getImageDir() {
        getProperties();
        File d = new File(props.getProperty("images"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    private static void getProperties() {
        if (props != null) {
            return;
        }
        props = new Properties();
        try {
            File f;
            f = new File("/workspaces/properties/coursemaker.properties");
            if (!f.exists()) {
                f = new File("/opt/properties/coursemaker.properties");
            }
            if (!f.exists()) {
                logger.log(Level.SEVERE, "coursemaker Properties File not found");
            } else {
                logger.log(Level.INFO, "coursemaker Properties: {0}", f.getAbsolutePath());
                props.load(new FileInputStream(f));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Properties file coursemaker.properties not found or corrupted");
        }

    }
    private static final Logger logger = Logger.getLogger(CourseMakerProperties.class.getName());
    private static Properties props;
}
