package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

public class Main {


    public static void main(String[] args) {


        // vérification de l'exitance des deux dossiers !

        // dans les dossiers vérifier les images

       ToolsGestion recupeImage = new ToolsGestion();

       FilterGrayscale Story1_noir_blanc = new FilterGrayscale();

       //STORY 1

        //openImage
       Mat Imageopened = recupeImage.OpenImage("antoine");

       // filtre noir blanc

       Mat FilteredImage =Story1_noir_blanc.filterGrayscale(Imageopened);

       // image recording

        recupeImage.create_In_Directory(FilteredImage,"antoine_N_B");


    }
}

/*
        L'image est ouverte avec JavaCV (avec la classe Mat)
    L'image est convertie en N&B
    L'image est enregistrée dans un nouveau fichier



    }
}
*/