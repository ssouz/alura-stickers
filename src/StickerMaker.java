import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerMaker {

    void cria(InputStream inputStream, String fileName) throws Exception {

        // leitura imagem
        // InputStream inputStream = new FileInputStream(new
        // File("entrada/filme2.jpg"));
        BufferedImage originalImage = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparencia

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 300;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 250);
        graphics.setColor(Color.red);
        graphics.setFont(fonte);
        // escrever a frase na nova imagem
        graphics.drawString("Bão", 100, newHeight - 100);

        // escrever nova imagem em arquivo
        ImageIO.write(newImage, "png", new File(fileName));
    }

}
