package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

import java.util.ArrayList;

public class ImageFilter {

    private ImageLog image;
    private ToolsGestion filter=new ToolsGestion();
    private ArrayList<ImageLog> imageFilter = new ArrayList<>();
    private ArrayList<ImageLog> imageLogsFilter = new ArrayList<>();

    public ImageFilter( int size, ArrayList<ImageLog> imageFilter, String filter_fonction) throws Exception {

        switch (filter_fonction)
        {
            case "FilterBlur" :


                IFilter Blur = new FilterBlur(size);

                for (int i =0;i<imageFilter.size();i++){

                    Mat imagefinition = Blur.filter_function(this.filter.OpenImage(imageFilter.get(i).getNameFile()));


                    ImageLog take_image = new ImageLog(imageFilter.get(i).getName(),imagefinition);

                    this.imageFilter.add(take_image);


                }

                ToolsGestion testtools = new ToolsGestion();

                testtools.GestionFileFilter(this.imageFilter);

                break;
            default:
                throw new Exception("mauvais choix");
        }


    }
}
