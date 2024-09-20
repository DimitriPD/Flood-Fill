import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String imagePath = "C:\\Users\\Dimitri\\Desktop\\Flood_Fill\\maca.png";
            File file = new File(imagePath);
            if (!file.exists()) {
                System.out.println("Arquivo de imagem não encontrado: " + file.getAbsolutePath());
                return;
            }

            BufferedImage image = ImageIO.read(file);
            String diretorioFrames = imagePath;
            Color novaCor = new Color(255, 0, 0);
            FloodFill floodFill = new FloodFill(image, novaCor, diretorioFrames);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha sua estutura e veja a magica acontecer:");
            System.out.println("1 - Pilha");
            System.out.println("2 - Fila");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    floodFill.floodFillPilha(10, 10);
                    break;
                case 2:
                    floodFill.floodFillFila(10, 10);
                    break;
                default:
                    System.out.println("Não temos essa opção");
                    return;
            }

            // floodFill.mostrarAnimacao(diretorioFrames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
