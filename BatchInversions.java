import edu.duke.ImageResource;
import edu.duke.Pixel;

public class BatchInversions {
    private final static String addInverted = "inverted-";
    private final static int maxIntensity = 255;

    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(maxIntensity - inPixel.getRed());
            pixel.setGreen(maxIntensity - inPixel.getGreen());
            pixel.setBlue(maxIntensity - inPixel.getBlue());
        }
        return outImage;
    }

    public String getProcessedFilename(String baseName) {
        return addInverted + baseName;
    }
}

