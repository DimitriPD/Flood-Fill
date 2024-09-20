import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FloodFill {
    private BufferedImage image;
    private Color novaCor;
    private Color corAntiga;
    private String diretorioFrames;

    public FloodFill(BufferedImage img, Color novaCor, String diretorioFrames) {
        this.image = img;
        this.novaCor = novaCor;
        this.diretorioFrames = diretorioFrames;
    }

    public void floodFillPilha(int x, int y) throws Exception {
        this.corAntiga = new Color(this.image.getRGB(x, y));
        if (!this.corAntiga.equals(this.novaCor)) {
            Stack<Pixel> pilha = new Stack<>(this.image.getWidth() * this.image.getHeight());
            pilha.push(new Pixel(x, y));

            for (int frame = 0; !pilha.isEmpty(); ++frame) {
                Pixel p = pilha.pop();
                x = p.x;
                y = p.y;
                if (this.validarPixel(x, y)) {
                    this.image.setRGB(x, y, this.novaCor.getRGB());
                    pilha.push(new Pixel(x + 1, y));
                    pilha.push(new Pixel(x - 1, y));
                    pilha.push(new Pixel(x, y + 1));
                    pilha.push(new Pixel(x, y - 1));
                }

                // Salva um frame da imagem a cada 100000 pixels processados
                if (frame % 100000 == 0) {
                    String nomeArquivo = this.diretorioFrames + "frame_" + frame + ".png";
                    this.salvarImagem(nomeArquivo);
                }
            }

            // Salva a imagem final
            this.salvarImagem(this.diretorioFrames + "imagem_final.png");
        }
    }
//Metodo para preencher com a estrutura de dados fila
    public void floodFillFila(int x, int y) throws Exception {
        this.corAntiga = new Color(this.image.getRGB(x, y));
        //Serve para verificr se a cor antiga  é diferente da cor original
        if (!this.corAntiga.equals(this.novaCor)) {
            StaticQueue fila = new StaticQueue(this.image.getWidth() * this.image.getHeight());
            fila.add(new Pixel(x, y).hashCode());

            for (int frame = 0; !fila.isEmpty(); ++frame) {
                Pixel p = new Pixel(fila.remove());
                x = p.x;
                y = p.y;
                if (this.validarPixel(x, y)) {
                    this.image.setRGB(x, y, this.novaCor.getRGB());
                    fila.add(new Pixel(x + 1, y).hashCode());
                    fila.add(new Pixel(x - 1, y).hashCode());
                    fila.add(new Pixel(x, y + 1).hashCode());
                    fila.add(new Pixel(x, y - 1).hashCode());
                }
                //Salvamento da imagem
                if (frame % 100000 == 0) {
                    String nomeArquivo = this.diretorioFrames + "frame_" + frame + ".png";
                    this.salvarImagem(nomeArquivo);
                }
            }
            //Ultima imagem (Salvamento final)
            this.salvarImagem(this.diretorioFrames + "imagem_final.png");
        }
    }


    private boolean validarPixel(int x, int y) {
        return x >= 0 && x < this.image.getWidth() && y >= 0 && y < this.image.getHeight() &&
                (new Color(this.image.getRGB(x, y))).equals(this.corAntiga);
    }


    public void salvarImagem(String caminho) throws Exception {
        File file = new File(caminho);
        ImageIO.write(this.image, "png", file);
    }
}


