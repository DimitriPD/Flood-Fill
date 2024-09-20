
public class Pixel {
    public int x;
    public int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pixel(int hash) {
        this.x = hash >> 16;
        this.y = hash & 0xFFFF;
    }

    //override porque vem da classe Objeto
    @Override
    //Combinar as cordenadas como numero interiro, compactar elas
    public int hashCode() {
        return (x << 16) | (y & 0xFFFF);
    }
}
