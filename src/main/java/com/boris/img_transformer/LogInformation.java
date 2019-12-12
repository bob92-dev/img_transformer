package com.boris.img_transformer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LogInformation {

    public void checkLog(ImageLog fileImageLOG) throws IOException {

        String namePicture = fileImageLOG.getNameStringFile();

        String filterOfThis = fileImageLOG.getFilterValuethis();

        File outLOG = new File("src/ImageLogFilter.log");

        if(!outLOG.exists()){

            outLOG.createNewFile();

            FileWriter writefile = new FileWriter(outLOG,true);

            writefile.write("\n");

            writefile.write("this name of picture is : "+ namePicture +" and use the filter  : "+filterOfThis);

            writefile.close();


        }else{

            FileWriter writefile = new FileWriter(outLOG,true);


            writefile.write("\n");

            writefile.write("the name of  picture is : "+namePicture+" and use the filter : "+filterOfThis);

            writefile.close();

        }
    }







}
