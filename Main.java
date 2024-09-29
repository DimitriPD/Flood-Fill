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
            String imageName = "maca.png";
            String imagePath = System.getProperty("user.dir") + File.separator + imageName;
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

            System.out.print("Posição X: ");
            int xPosition = scanner.nextInt();

            System.out.print("Posição Y: ");
            int yPosition = scanner.nextInt();

            switch (escolha) {
                case 1:
                    floodFill.floodFillPilha(xPosition, yPosition);
                    break;
                case 2:
                    floodFill.floodFillFila(xPosition, yPosition);
                    break;
                default:
                    System.out.println("Não temos essa opção");
                    return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
