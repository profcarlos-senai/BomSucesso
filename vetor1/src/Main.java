public class Main {
    public static void main(String[] args) {
        int[] coisas = new int[10]; // declara um vetor de inteiros
        String[] palavras = new String[10];
        for (int i = 0; i < coisas.length; i++) {
            System.out.println(i + " - " + coisas[i]);
        }

        // vasculhe "palavras" e coloque cada elemento
        // na variável "x" uma volta de cada vez
        for (String x: palavras) {
            System.out.println(x);
        }
    }
}