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
     * this fonction check discovery and add to
     * @param filterImage this list of picture output
     * @throws FormatException check format
     * @throws FilterException check filter possibility
     * @throws CreateException check if create file
     */

    public void GestionFileFilter(ArrayList<ImageLog> filterImage) throws FormatException, FilterException, CreateException {

        //this absolute path
        File fileDosFilt = new File("src/ImageFiltered");

        // check existance of discovery

        if(!fileDosFilt.exists()){
                // create discovery
                fileDosFilt.mkdirs();

                // add picture in discovery

            for(int i =0;i<filterImage.size();i++){

                ToolsGestion stoked = new ToolsGestion();

                stoked.create_In_Directory(filterImage.get(i).getMatImage(),filterImage.get(i).getNameStringFile());

            }

        }else{

            // add picture in discovery
            for(int i =0;i<filterImage.size();i++){

                ToolsGestion stoked = new ToolsGestion();

                stoked.create_In_Directory(filterImage.get(i).getMatImage(),filterImage.get(i).getNameStringFile());

            }
        }
    }

    /**
     * this fonction check discovery ( exist or not exist that is the question )
     * @return
     * @throws FormatException check format
     * @throws FilterException check filter possibility
     * @throws CreateException check if create file
     */

    public ArrayList<ImageLog> GestionFileRessource() throws FormatException, FilterException, CreateException {


        //this absolute path

        ArrayList<ImageLog> Imagelog =new  ArrayList<>();

    // check existance of discovery
        File fileDosRec = new File("src/ImageRessource");

        if (!fileDosRec.exists()) {

            // create discovery
                fileDosRec.mkdirs();

                return Imagelog ;
        }else{
            if(fileDosRec.length()== 0){
                System.out.println("faux");

            }else{

                // take all file in discovery and
                File[] ListeDoc = fileDosRec.listFiles();

                // change elements in discovery of ImageLog
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
    public Mat OpenImage(String name) throws FormatException {
        try{
            // open file in src/ImageRessource/+ name + ".jpg
            File f = new File("src/ImageRessource/" + name + ".jpg");

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
    public void create_In_Directory(Mat image,String name_file) throws FormatException {

        //enregistrer l'image
        // creation d'une nouvelle direction pour la destination du fichier
        File outputDir = new File("src/ImageFiltered");

        try{
            // dans la nouveau dossier, il enregistre le fichioer de sortie( apres application du filtre)
            // en deuxiéme argument le nom du nouveau fichier

            File outputFile = new File(outputDir, name_file+".jpg");

            //ensuite il écrit le chemin absolu, et l'image

            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

        }catch (Exception e ){
            throw new FormatException(" ");
        }

    }
}