package pizza;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Util {
    public static BufferedImage generateBufferedImage(String path) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        return image;
    }
}
