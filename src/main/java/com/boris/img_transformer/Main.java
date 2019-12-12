package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

import java.util.ArrayList;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws Exception,FormatException,FilterException {



       ToolsGestion recupeImage = new ToolsGestion();

       IFilter Story1_noir_blanc = new FilterGrayscale();

       //STORY 1

        //openImage
       Mat Imageopened = recupeImage.OpenImage("antoine");

       // filtre noir blanc


       Mat FilteredImage =Story1_noir_blanc.filter_function(Imageopened);

        // image recording

        recupeImage.create_In_Directory(FilteredImage,"antoine_N_B");

        // STORY 2

        ToolsGestion recupeImage2 = new ToolsGestion();

        IFilter Story_2_Blur = new FilterBlur(31);

        //openImage

        Mat Imageopened2 = recupeImage2.OpenImage("ted");

        // filtre noir blanc

        Mat FilteredBlur =Story_2_Blur.filter_function(Imageopened2);

        // image recording

        recupeImage2.create_In_Directory(FilteredBlur,"ted_Blur");


        // STORY 3

        ToolsGestion recupeImage3 = new ToolsGestion();

        IFilter Story_3 = new FilterDilate(8);

        //openImage

        Mat Imageopened3 = recupeImage2.OpenImage("image 33");

        // filtre dilate

        Mat FilteredDilate =Story_3.filter_function(Imageopened3);

        // image recording

        recupeImage3.create_In_Directory(FilteredDilate,"image 33_dilate");

        ToolsGestion testDeDossier = new ToolsGestion();

        ArrayList<ImageLog> value = testDeDossier.GestionFileRessource();

        ImageFilter filtertest = new ImageFilter(31,value,"FilterBlur");



    }
}

/*
        L'image est ouverte avec JavaCV (avec la classe Mat)
    L'image est convertie en N&B
    L'image est enregistrée dans un nouveau fichier



    }
}
*/