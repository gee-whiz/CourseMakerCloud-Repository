/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

/**
 *
 * @author aubreymalabie
 */

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

public class FileUtility {

    private static final Logger logger = Logger.getLogger(FileUtility.class.getName());

    public static File getFile(String data) {
        Random rand = new Random(System.currentTimeMillis());
        //TODO restore after zip testing
        File dir = CourseMakerProperties.getTemporaryDir();
        File file = new File(dir, "xm" + System.currentTimeMillis() + "_" + rand.nextInt(999999999) + ".data");
        try {
            FileUtils.writeStringToFile(file, data);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return file;
    }
/*
    public static void makeThumbnails(File imageFile, File dir) {
        BufferedImage image = null;
        Image small = null;
        Image medium = null;
        Image large = null;
        try {
            image = ImageIO.read(imageFile);
            //Need small, med & large thumbnails
            large = image.getScaledInstance(THUMB_WIDTH_LARGE, THUMB_HEIGHT_LARGE, Image.SCALE_SMOOTH);
            medium = image.getScaledInstance(THUMB_WIDTH_MEDIUM, THUMB_HEIGHT_MEDIUM, Image.SCALE_SMOOTH);
            small = image.getScaledInstance(THUMB_WIDTH_SMALL, THUMB_HEIGHT_SMALL, Image.SCALE_SMOOTH);
            //image to file
            File lgDir = new File(dir, "largeThumbs");
            if (!lgDir.exists()) {
                lgDir.mkdir();
            }
            File medDir = new File(dir, "mediumThumbs");
            if (!medDir.exists()) {
                medDir.mkdir();
            }
            File smDir = new File(dir, "smallThumbs");
            if (!smDir.exists()) {
                smDir.mkdir();
            }
            File lgThumb = new File(lgDir, imageFile.getName());
            String ret = Thumbnail.createThumbnail(image,
                    lgThumb, THUMB_WIDTH_LARGE);
            logger.log(Level.INFO, "### Creating large thumbnail, ret: {0}", ret);
            
            File medThumb = new File(medDir, imageFile.getName());
            String ret2 = Thumbnail.createThumbnail(image,
                    medThumb, THUMB_WIDTH_MEDIUM);
            logger.log(Level.INFO, "### Creating med thumbnail, ret2: {0}", ret2);

            File smThumb = new File(smDir, imageFile.getName());
            String ret3 = Thumbnail.createThumbnail(image,
                    smThumb, THUMB_WIDTH_SMALL);
            logger.log(Level.INFO, "### Creating small thumbnail, ret3: {0}", ret3);


        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to create thumbnails", e);
        }
    }
    * */
   
    
}
