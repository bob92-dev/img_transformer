package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class FilterBlur implements IFilter {

    private int size;

    public FilterBlur(int size){
        this.size=size;
    }

    public Mat filter_function(Mat image) throws FilterException {

        try{

            //int size = this.size;

            if(this.size%2==0){
                throw new FilterException(" bad value of size ");
            }
            // attention taille impaire, obligatoirement

            // création d'une copie de l'image
            Mat result = image.clone();
            // une image, son clone, et la taille donnée plus haut.
            GaussianBlur(image, result, new Size(this.size, this.size), 0);
            // il retourne le result donc le fichier de sortie modifié
            return result;
        }catch (Exception e){
            throw new FilterException("this image isn't good ");
        }
    }

    public int getSize() {
        return this.size;
    }
}
