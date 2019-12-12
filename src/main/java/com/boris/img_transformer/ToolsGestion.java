package com.boris.img_transformer;

import javafx.scene.AmbientLight;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToolsGestion {

    /**
     * this fonction check directory and add to
     * @param filterImage this list of picture output
     * @throws FormatException check format
     * @throws FilterException check filter possibility
     * @throws CreateException check if create file
     */

    public void GestionFileFilter(ArrayList<ImageLog> filterImage, String path_output) throws FormatException, FilterException, CreateException {

        //this absolute path
        File fileDosFilt = new File("src/"+ path_output);

        // check the existence of the final discovery

        if(!fileDosFilt.exists()){
                // create directory
                fileDosFilt.mkdirs();

                // add picture in directory
                // Puts every picture of the arraylist in our new directory

            for(int i =0;i<filterImage.size();i++){

                ToolsGestion stoked = new ToolsGestion();

                stoked.create_In_Directory(filterImage.get(i).getMatImage(),filterImage.get(i).getNameStringFile(),path_output);

            }

        }else{

            // add picture in directory
            for(int i =0;i<filterImage.size();i++){

                ToolsGestion stoked = new ToolsGestion();

                stoked.create_In_Directory(filterImage.get(i).getMatImage(),filterImage.get(i).getNameStringFile(), path_output);

            }
        }
    }

    /**
     * this fonction check directory ( exist or not exist that is the question )
     * @return
     * @throws FormatException check format
     * @throws FilterException check filter possibility
     * @throws CreateException check if create file
     */

    public ArrayList<ImageLog> GestionFileRessource(String path_input) throws FormatException, FilterException, CreateException {


        //this absolute path

        ArrayList<ImageLog> Imagelog =new  ArrayList<>();

    // check existence of discovery
       // File fileDosRec = new File("src/"+path_input+"/");
        File fileDosRec = new File("src/ImageRessource/");

        if (!fileDosRec.exists()) {

            // create discovery
                fileDosRec.mkdirs();

                return Imagelog ;
        }else{
            if(fileDosRec.length()== 0){
                System.out.println("faux");

            }else{

                // take all file in directory band
                File[] ListeDoc = fileDosRec.listFiles();

                // change elements in directory of ImageLog
                for(int i=0;i<ListeDoc.length;i++){

                    Mat image = opencv_imgcodecs.imread(ListeDoc[i].getAbsolutePath());

                    ImageLog log =new ImageLog(ListeDoc[i],image,null);

                    Imagelog.add(log);

                }
            }
        }
        return Imagelog;
    }


    /**
     * this function open file and create name for him
     * @param name name of file Mat
     * @return
     */
    public Mat OpenImage(String name, String path_input) throws FormatException {
        try{
            // open file in src/ImageRessource/+ name + ".jpg
            File f = new File("src/" + path_input +"/"+ name);

            if(!f.exists()){
                throw new FormatException(" this image isn'it exist :"+f.getAbsolutePath());
            }
            // give Absolute Path
            Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

            return image;

        }catch (FormatException e){
            throw new FormatException("your problems is :" +e.getCause());
        }
    }

    /**
     * this function move file between discovery
     * @param image this file Mat
     * @param name_file name of file
     * @throws FormatException
     */
    public void create_In_Directory(Mat image,String name_file, String path_output) throws FormatException {


        // create a new path for the file destination
        File outputDir = new File("src/"+path_output+"/");

        try{
            // dans la nouveau dossier, il enregistre le fichioer de sortie( apres application du filtre)
            // en deuxiéme argument le nom du nouveau fichier

            File outputFile = new File(outputDir, name_file);

            //ensuite il écrit le chemin absolu, et l'image

            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

        }catch (Exception e ){
            throw new FormatException("This is a format exception. Try later !"+" = "+ image +" name "+name_file);
        }

    }
}