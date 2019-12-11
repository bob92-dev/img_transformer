package com.boris.img_transformer;

import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ToolsGestion {

    private String name;
    private JavaCVHelper filterBlur;

    public void GestionFile(File filetest) throws Exception {


        if (!filetest.exists()) {
            try {
                filetest.createNewFile();
            } catch (IOException e) {
                throw new Exception("Probléme ");
            }
        }
    }

    /**
     * this function open file and create name for him
     * @param name name of file Mat
     * @return
     */
    public Mat OpenImage(String name) {
        // open file in src/ImageRessource/+ name + ".jpg
        File f = new File("src/ImageRessource/" + name + ".jpg");
        // give Absolute Path
        Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
        return image;
    }



    public void create_In_Directory(Mat image,String name_file) {
        //enregistrer l'image
        // creation d'une nouvelle direction pour la destination du fichier
        File outputDir = new File("src/ImageFiltered");

        // dans la nouveau dossier, il enregistre le fichioer de sortie( apres application du filtre)
        // en deuxiéme argument le nom du nouveau fichier


        File outputFile = new File(outputDir, name_file+".jpg");

        //ensuite il écrit le chemin absolu, et l'image

        opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

    }
}