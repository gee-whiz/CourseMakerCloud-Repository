/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.servlet;

import com.boha.coursemaker.util.CourseMakerProperties;
import com.boha.coursemaker.util.PlatformUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author aubreyM
 */
@Stateless
public class HouseKeepingScheduler {

    @Schedule(minute = "*/30", hour = "*")
    public void cleanUp() {
        startDiskCleanup();
    }

    private void startDiskCleanup() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\n### ##########################################################################\n");
        sb.append("### CourseMaker Disk Cleanup STARTED: ").append(new Date()).append("\n");
        sb.append("### ##########################################################################\n\n");
        log.log(Level.INFO, sb.toString());

        int count = 0;
        File dir = CourseMakerProperties.getTemporaryDir();
        if (dir.exists()) {
            File[] files = dir.listFiles();
            log.log(Level.INFO, "### startDiskCleanup - temporary files found: {0}", files.length);
            for (File file : files) {
                long now = new Date().getTime();
                long cutOff = now - MINUTE;
                if (file.lastModified() < cutOff) {
                    boolean OK = file.delete();
                    if (OK) {
                        count++;
                    }
                }
            }
        }
        log.log(Level.INFO, "### CourseMaker HouseKeeping cleaned up {0} temporary files", count);
        try {
            if (count > 10) {
                platformUtil.addErrorStore(133, 
                    "CourseMaker temporary files cleaned up: " + count, "HouseKeeper");
            }
        } catch (Exception e) {

        }
    }
    @EJB
    PlatformUtil platformUtil;

    static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private final static int MINUTE = 1000 * 60;
    static final Logger log = Logger.getLogger(HouseKeepingScheduler.class.getName());
}
