import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
  
    public void cria(InputStream inputStream, String nomeArquivo)  throws Exception{
      
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

       int largura =  imagemOriginal.getWidth();
       int altura = imagemOriginal.getHeight();
       int novaAltura = altura + 200;

       BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

       Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
       graphics.drawImage(imagemOriginal, 0, 0, null);

       Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
       graphics.setFont(font);
       graphics.setColor(Color.YELLOW);

      String textoFigurinha = "TOPZERA";
      int larguraTexto = graphics.getFontMetrics().stringWidth(textoFigurinha);
      int horizontal = (largura/2) - (larguraTexto/2);
      int vertical = novaAltura - 100;

       graphics.drawString(textoFigurinha, horizontal, vertical);

       File figurinha = new File(nomeArquivo);
       figurinha.getParentFile().mkdirs();

       ImageIO.write(novaImagem, "png", figurinha);
    }
}
