package com.boris.img_transformer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception, FormatException, FilterException {






        Options options = new Options();
        options.addOption("h",false, "help");
        options.addOption("i",true, "input <directory>");
        options.addOption("o","ouput -dir",false, "output <directory>");


        // story 6 : ETAPE 2 : creation du parseur
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);



        //story 6 : ETAPE 3 : récupération et traitement des résultats

        if(cmd.hasOption("h")) {
            System.out.println("This is the help option of our programm. Press i to change the input dircetory. Press o to change the out directory ");

        }
        if (cmd.hasOption("i")){
            System.out.println("this is a test command "+ cmd.getOptionValues("i"));

        }




        Options options = new Options();

        options.addOption("h", false, "help");
        options.addOption("i", true, "input <directory>");
        options.addOption("o", "ouput -dir", true, "output <directory>");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);

        System.out.println((cmd.getOptionValue("i")));



        switch (cmd.) {
            default:
                System.out.println("echec");

            case "h":

                System.out.println("This is the help option of our programm. Press i to change the input dircetory. Press o to change the out directory ");

                break;

            case "i":
                System.out.println("i");
                break;

            case "o":
                System.out.println("o");
                break;

        }

    }




        // story 6 : ETAPE 1 : CLI => creation des options
        Options options = new Options();
        options.addOption("h",false, "help");
        options.addOption("i",true, "input <directory>");
        options.addOption("o","ouput -dir",true, "output <directory>");


        // story 6 : ETAPE 2 : creation du parseur
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);

        //story 6 : ETAPE 3 : récupération et traitement des résultats

        if(cmd.hasOption("h")) {
            System.out.println("This is the help option of our programm. Press i to change the input dircetory. Press o to change the out directory ");

        }
        else {
            System.out.println("this is a test command");

        }

        if (cmd.hasOption("i")){

            // on récupére l'argument passé
            //cmd.getArgs();
            // on l'imprime pour le test
            System.out.println(Arrays.toString(cmd.getOptions()));
            System.out.println(cmd.getArgs());

            // on remplace le dossier d'input par cet argument


        }







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

        recupeImage3.create_In_Directory(FilteredDilate,"image 33_dilate");*/


//===================================================================================

        // STORY 5


        //ToolsGestion testDeDossier = new ToolsGestion();

        // ArrayList<ImageLog> value = testDeDossier.GestionFileRessource();

        // ImageFilter filtertest = new ImageFilter(31, value, 1);


        //ImageFilter filtertest1 = new ImageFilter(8,value,2);


        //ImageFilter filtertest2 = new ImageFilter(31,value,3);


    }