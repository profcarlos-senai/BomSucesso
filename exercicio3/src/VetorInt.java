public class VetorInt {
    private int[] vetor;
    private int n;

    public VetorInt(int tamanho){
        vetor = new int[tamanho];
        n = 0;
    }

    public void add(int valor){
        if(n<vetor.length){
            vetor[n] = valor;
            n++;
        }
    }

    public int getTotal(){
        int total = 0;
        for(int i=0; i<n; i++){
            total += vetor[i];
        }
        return total;
    }

    public double getMedia(){
        double total = getTotal();
        return total/n;
    }
}
