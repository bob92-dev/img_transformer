package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class ImageLog {

    private File fileName;
    private Mat matImage;
    private String nameStringFile;

    public ImageLog(File nameSource, Mat image) {
        this.fileName = nameSource;
        this.matImage = image;
        this.nameStringFile = nameSource.getName();
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
}
