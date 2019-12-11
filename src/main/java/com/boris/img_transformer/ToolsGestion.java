package com.boris.img_transformer;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ToolsGestion {

    private String name;
    private JavaCVHelper filterBlur;

    public void GestionFile(File filetest) throws Exception {


        if (!filetest.exists()) {
            try {
                filetest.createNewFile();
            } catch (IOException e) {
                throw new Exception("Probléme ");
            }
        }
    }

    public  Mat OpenImage ( String name) {
        // crée un objet file
        File f = new File("src/ImageRessource/" +name+ ".jpg");

        // ensuite il lit l'image
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

        return image;
    }
}