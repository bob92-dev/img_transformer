package com.boris.img_transformer;

import org.bytedeco.opencv.opencv_core.Mat;

public interface IFilter {

    public Mat filter_function(Mat image) throws Exception;

}
