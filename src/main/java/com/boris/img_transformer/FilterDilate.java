package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class FilterDilate implements IFilter{

    private int size;

    public FilterDilate(int size){
        this.size=size;
    }

    public Mat filter_function(Mat image) throws FilterException {
        try {

            Mat result = image.clone();
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * this.size + 1, 2 * this.size + 1));
            dilate(image, result, element);
            return result;
        }catch (Exception e){
            throw new FilterException(" ");
        }
    }

    public int getSize() {
        return this.size;
    }
}
