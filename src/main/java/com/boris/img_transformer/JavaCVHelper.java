package com.boris.img_transformer;

import jdk.internal.org.jline.terminal.Size;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;



import java.io.File;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class JavaCVHelper {

    public void exempleBlurFile() {

        // appliquer un filtre
        File f = new File("imgs/test.jpg");
        // ensuite il lit l'image
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        // il lui applique le filtre
        image = filterBlur(image);


        //enregistrer l'image
            // creation d'une nouvelle direction pour la destination du fichier
        File outputDir = new File("output");
        // dans la nouveau dossier, il enregistre le fichioer de sortie( apres application du filtre)
        // en deuxiéme argument le nom du nouveau fichier
        File outputFile = new File(outputDir, "result.jpg");
        //ensuite il écrit le chemin absolu, et l'image
        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
    }


    // ca c'ets un flou
    public Mat filterBlur(Mat image) {
        // attention taille impaire, obligatoirement
        int size = 3;
        // création d'une copie de l'image
        Mat result = image.clone();
        // une image, son clone, et la taille donnée plus haut.
        GaussianBlur(image, result, new Size(size, size), 0);
        // il retourne le result donc le fichier de sortie modifié
        return result;
    }

    public Mat filterDilate(Mat image) {
        int size = 8;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        return result;
    }

    public Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}

