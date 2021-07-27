import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

public class ImageConverter {

    public static void main(String[] args) {
        ImageConverter imageConverter = new ImageConverter();
        imageConverter.selectAndConvert();
    }

    public void selectAndConvert() {
        BatchInversions inversion = new BatchInversions();
        BatchGrayscale grayscale = new BatchGrayscale();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = grayscale.makeGray(inImage);
            ImageResource inverted = inversion.makeInversion(inImage);

            saveImage(gray, grayscale.getProcessedFilename(inImage.getFileName()));
            saveImage(inverted, inversion.getProcessedFilename(inImage.getFileName()));
        }
    }

    private void saveImage(ImageResource image, String fileName) {
        image.setFileName(fileName);
        image.save();
        image.draw();
    }
}
