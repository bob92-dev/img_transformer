package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class ImageLog {

    private File name;
    private Mat image;
    private String nameFile;

    public ImageLog(File nameSource, Mat image) {
        this.name = nameSource;
        this.image = image;
        this.nameFile = nameSource.getName();
    }

    public Mat getImage() {
        return this.image;
    }

    public File getName() {
        return this.name;
    }

    public String getNameFile() {
        return nameFile;
    }
}
