package br.com.lobo.api.Services;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StickersService {

    public void create(String img, String name, String folder) throws IOException {

	BufferedImage image = (BufferedImage)this.downloadImage(img);
	int width = image.getWidth();
	int height = image.getHeight();
	int newHeight = height + 200;
	BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
	Graphics2D graphics = (Graphics2D)newImage.getGraphics();
	graphics.drawImage(image, 0, 0, null);
	var font = new Font(Font.SANS_SERIF, Font.BOLD, 82);
	graphics.setFont(font);
	graphics.setColor(Color.ORANGE);
	graphics.drawString("Figurinha imersao java", 150, newHeight - 100);
	File file = new File("output/" + folder + "/" + name + ".png");
	this.checkDirectory(file);
	ImageIO.write(newImage, "png", file);
    }

    private Image downloadImage(String imageLink) {

	try {
	    URL url = new URL(imageLink);
	    Image image = ImageIO.read(url);

	    return image;
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return null;
    }

    private void checkDirectory(File file) {
	if (!file.exists()) {
	    file.mkdirs();
	}
    }
}
