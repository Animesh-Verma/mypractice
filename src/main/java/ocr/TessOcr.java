package ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TessOcr {
    public static void main(String[] args) throws TesseractException, IOException, URISyntaxException {
//        met();
        TessOcr tessOcr = new TessOcr();
        tessOcr.met4();

//        File f
//                = new File(
//                "resources/img2.jpg");
//
//        BufferedImage ipimage = ImageIO.read(f);
//
//        // getting RGB content of the whole image file
//        double d
//                = ipimage
//                .getRGB(ipimage.getTileWidth() / 2,
//                        ipimage.getTileHeight() / 2);
//
//        // comparing the values
//        // and setting new scaling values
//        // that are later on used by RescaleOP
//        if (d >= -1.4211511E7 && d < -7254228) {
//            processImg(ipimage, 3f, -10f);
//        }
//        else if (d >= -7254228 && d < -2171170) {
//            processImg(ipimage, 1.455f, -47f);
//        }
//        else if (d >= -2171170 && d < -1907998) {
//            processImg(ipimage, 1.35f, -10f);
//        }
//        else if (d >= -1907998 && d < -257) {
//            processImg(ipimage, 1.19f, 0.5f);
//        }
//        else if (d >= -257 && d < -1) {
//            processImg(ipimage, 1f, 0.5f);
//        }
//        else if (d >= -1 && d < 2) {
//            processImg(ipimage, 1f, 0.35f);
//        }
    }




    public static void met() throws TesseractException, IOException {
        File image = new File("resources/outputimg.jpg");
        if(image.exists()){
            System.out.println("Exist");
        }
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("D:/OcrJava/Tess4J/tessdata");
        tesseract.setLanguage("eng");
//        tesseract.setPageSegMode(1);
//        tesseract.setOcrEngineMode(1);
        String result = tesseract.doOCR(image);
        System.out.println(result);
    }

    public static void
    processImg(BufferedImage ipimage,
               float scaleFactor,
               float offset)
            throws IOException, TesseractException
    {
        // Making an empty image buffer
        // to store image later
        // ipimage is an image buffer
        // of input image
        BufferedImage opimage
                = new BufferedImage(1050,
                1024,
                ipimage.getType());

        // creating a 2D platform
        // on the buffer image
        // for drawing the new image
        Graphics2D graphic
                = opimage.createGraphics();

        // drawing new image starting from 0 0
        // of size 1050 x 1024 (zoomed images)
        // null is the ImageObserver class object
        graphic.drawImage(ipimage, 0, 0,
                1050, 1024, null);
        graphic.dispose();

        // rescale OP object
        // for gray scaling images
        RescaleOp rescale
                = new RescaleOp(scaleFactor, offset, null);

        // performing scaling
        // and writing on a .png file
        BufferedImage fopimage
                = rescale.filter(opimage, null);
        ImageIO
                .write(fopimage,
                        "jpg",
                        new File("resources/outputimg.png"));

        // Instantiating the Tesseract class
        // which is used to perform OCR
        Tesseract it = new Tesseract();

        it.setDatapath("D:/OcrJava/Tess4J/tessdata");

        // doing OCR on the image
        // and storing result in string str
        String str = it.doOCR(fopimage);
        System.out.println(str);
    }

    private void met4() throws TesseractException, URISyntaxException, IOException {
        File tmpFolder = LoadLibs.extractTessResources("win32-x86-64");
        System.setProperty("java.library.path", tmpFolder.getPath());
        File imagefile = new File("resources/outputimg.jpg");

        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setOcrEngineMode(1);

        Path dataDirectory = Paths.get(ClassLoader.getSystemResource("data").toURI());
        System.out.println(dataDirectory.getFileName());
        tesseract.setDatapath(dataDirectory.toString());

        BufferedImage image = ImageIO.read(imagefile);
        String result = tesseract.doOCR(image);
        System.out.println(result);

//        File image = new File("resources/img2.jpg");
//        Tesseract tesseract = new Tesseract();
//        tesseract.setDatapath("D:/OcrJava/Tess4J/tessdata");
//        tesseract.setLanguage("eng");
//        tesseract.setPageSegMode(1);
//        tesseract.setOcrEngineMode(1);
//        String result = tesseract.doOCR(image);
//        System.out.println(result);
    }

}
