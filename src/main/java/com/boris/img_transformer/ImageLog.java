package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class allow us to reach all the caracteristics (filename etc.) of a picture.
 */



public class ImageLog {

    private File fileName;
    private Mat matImage;
    private String nameStringFile;
    private String filterValuethis = " No filter ";

    public ImageLog(File nameSource, Mat image,String filterValuethis) {
        this.fileName = nameSource;
        this.matImage = image;
        this.nameStringFile = nameSource.getName();
        this.filterValuethis = filterValuethis;
    }

    public File getFileName() {
        return fileName;
    }

    public Mat getMatImage() {
        return matImage;
    }

    public String getNameStringFile() {
        return nameStringFile;
    }

    public String getFilterValuethis() {
        return filterValuethis;
    }
}
