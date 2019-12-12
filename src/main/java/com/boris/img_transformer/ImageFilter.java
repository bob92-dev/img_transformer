package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

import java.util.ArrayList;

public class ImageFilter {

    private ToolsGestion filter=new ToolsGestion();

    public ImageFilter( int size, ArrayList<ImageLog> imageFilter, int filter_fonction) throws Exception {


        ToolsGestion testtools = new ToolsGestion();

        IFilter Blur = new FilterBlur(size);

        IFilter Dilate = new FilterDilate(size);

        IFilter Grayscale = new FilterGrayscale();

        LogInformation valuefilterforpicture = new LogInformation();

        ArrayList<ImageLog> value_filter = new ArrayList<>();


        switch (filter_fonction)
        {
            case 1 :
                for (int i =0;i<imageFilter.size();i++) {
                    Mat test = Grayscale.filter_function(imageFilter.get(i).getMatImage());
                    ImageLog finish =new ImageLog(imageFilter.get(i).getFileName(),test,"Grayscale");
                    valuefilterforpicture.checkLog(finish);
                    value_filter.add(finish);
                }

                testtools.GestionFileFilter(value_filter);
                break;

            case 2 :

                for (int i =0;i<imageFilter.size();i++) {
                    Mat test = Dilate.filter_function(imageFilter.get(i).getMatImage());
                    ImageLog finish =new ImageLog(imageFilter.get(i).getFileName(),test,"Dilate");
                    valuefilterforpicture.checkLog(finish);
                    value_filter.add(finish);
                }
                testtools.GestionFileFilter(value_filter);
                break;

            case 3 :

                for (int i =0;i<imageFilter.size();i++){

                    Mat test = Blur.filter_function(imageFilter.get(i).getMatImage());
                    ImageLog finish =new ImageLog(imageFilter.get(i).getFileName(),test,"Blur");
                    valuefilterforpicture.checkLog(finish);
                    value_filter.add(finish);

                }
                testtools.GestionFileFilter(value_filter);
                break;

            default:
                throw new Exception("mauvais choix");
        }


    }
}
