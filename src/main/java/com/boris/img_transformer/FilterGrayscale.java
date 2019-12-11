package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class FilterGrayscale implements IFilter{

    public Mat filter_function(Mat image) throws FilterException {

        try{

            Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
            cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
            return result;

        }catch (Exception e){
            throw new FilterException("the gray color isn't accepted ",e);
        }
    }
}
