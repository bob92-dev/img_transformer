package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class FilterBlur {

    public Mat filterBlur(Mat image) {
        // attention taille impaire, obligatoirement
        int size = 31;
        // création d'une copie de l'image
        Mat result = image.clone();
        // une image, son clone, et la taille donnée plus haut.
        GaussianBlur(image, result, new Size(size, size), 0);
        // il retourne le result donc le fichier de sortie modifié
        return result;
    }
}
