package com.boris.img_transformer;

import javafx.css.FontFace;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Point;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.Core;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class FilterTeam implements IFilter{

    private int size;

    public FilterTeam(){
        this.size=size;
    }

    public Mat filter_function(Mat image) throws FilterException {
        try {

            Mat result = image.clone();
            opencv_imgproc opencv_imgproc = new opencv_imgproc();
            opencv_imgproc.putText(result,"Les BG",new Point( 0, 500),FONT_HERSHEY_COMPLEX,1, Scalar.GREEN);
            return result;
        }catch (Exception e){
            throw new FilterException(" ");
        }
    }

    public int getSize() {
        return this.size;
    }
}

