package com.boris.img_transformer;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ToolsGestion {


    public void GestionFile() throws FormatException, FilterException, CreateException {

        File fileDosRec = new File("src/ImageRessource");
        File fileDosFilt = new File("src/ImageFiltered");

        if (!fileDosRec.exists()) {
            try {

                fileDosRec.createNewFile();

            } catch (CreateException e) {
                throw new CreateException(" Probléme création dossier ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!fileDosFilt.exists()){
            try {

                fileDosFilt.createNewFile();

            } catch (CreateException e) {
                throw new CreateException(" Probléme création dossier ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
            throw new FormatException("");
        }

    }
}