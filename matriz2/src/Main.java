public class Main {
    public static void main(String[] args) {

        // criar um vetor usando new
        double[] valores = new double[7];

        // também dá pra criar vetores de tamanho variável
        int n = 11;
        String[] palavras = new String[n];

        // o atributo .length contém o tamanho de um vetor
        for(int i=0; i < valores.length; i++){
            valores[i] = 0;
        }

        // matrizes com mais dimensões são declaradas assim
        int[][] horarios = new int[24][7];

    }
}