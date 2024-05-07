public class Bicho {
    private int vida;

    public Bicho(int vida){
        setVida(vida);
    }

    public Bicho(){
        this(100);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}