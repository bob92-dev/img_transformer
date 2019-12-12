package com.boris.img_transformer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.bytedeco.opencv.opencv_core.Mat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception,FormatException,FilterException {



        // path initalization
        String path_input = null;
        String path_output = null;


        // story #6 : Step 1 => CLI => creation of the options
        Options options = new Options();
        options.addOption("h",false, "help");
        options.addOption("i","input -dir",true, "input <directory>");
        options.addOption("o","ouput -dir",true, "output <directory>");


        // story #6 : Step 2 : introduction of our parser
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);

        //story #6 : Step 3 : dealing with results

        if(cmd.hasOption("h")) {
            System.out.println("This is the help option of our programm" +
                    "Enter -i to change the input directory. " +
                    "Enter -o to change the output directory ");
        }

        if (cmd.hasOption("i")){

            path_input = cmd.getOptionValue("i");

        }

        if (cmd.hasOption("o")){
            path_output = cmd.getOptionValue("o");
        }

        ToolsGestion testDeDossier = new ToolsGestion();

        ArrayList<ImageLog> value = testDeDossier.GestionFileRessource(path_input);

/*
        String imageTest = value.get(0).getNameStringFile();

        System.out.println(imageTest);

       ToolsGestion recupeImage = new ToolsGestion();

       IFilter Story1_noir_blanc = new FilterGrayscale();

        System.out.println(value);



       //STORY 1

        //openImage
       Mat Imageopened = recupeImage.OpenImage(imageTest,path_input);

       // filtre noir blanc


       Mat FilteredImage =Story1_noir_blanc.filter_function(Imageopened);

        // image recording

        recupeImage.create_In_Directory(FilteredImage,imageTest, path_output);

        // STORY 2

        ToolsGestion recupeImage2 = new ToolsGestion();

        IFilter Story_2_Blur = new FilterBlur(31);

        //openImage

        Mat Imageopened2 = recupeImage2.OpenImage(imageTest, path_input);

        // filtre noir blanc

        Mat FilteredBlur =Story_2_Blur.filter_function(Imageopened2);

        // image recording

        recupeImage2.create_In_Directory(FilteredBlur,imageTest, path_output);


        // STORY 3

        ToolsGestion recupeImage3 = new ToolsGestion();

        IFilter Story_3 = new FilterDilate(8);

        //openImage

        Mat Imageopened3 = recupeImage2.OpenImage(imageTest,path_input);

        // filtre dilate

        Mat FilteredDilate =Story_3.filter_function(Imageopened3);

        // image recording

        recupeImage3.create_In_Directory(FilteredDilate,imageTest,path_output);
*/


//===================================================================================

        // STORY 5


        //ImageFilter filtertest = new ImageFilter(31,value,1,path_output);


        //ImageFilter filtertest1 = new ImageFilter(8,value,2, path_output);


        //ImageFilter filtertest2 = new ImageFilter(31,value,3, path_output);

        ImageFilter filtertest2 = new ImageFilter(31,value,4, path_output);


    }
}