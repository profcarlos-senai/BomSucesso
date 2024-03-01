public class Hotel {
    private String[] quartos; // um quarto ocupado têm o nome do hóspede dentro dele
    private int ocupados; // conta quantos quartos estão ocupados

    // Criar uma classe Hotel que quando é inicializada eu passo o numero de quartos.
    public Hotel(int tamanho){  // método CONSTRUTOR que cria um novo objeto dessa classe
        this.quartos = new String[tamanho];
        this.ocupados = 0;
    }

    // Quero um método que diga quantos quartos vagos têm
    public int getVagos(){
        return quartos.length - ocupados; // .length = comprimento do vetor
    }

    // Quero um método para registrar um cliente no hotel que retorne o número do quarto.
       // Se o hotel está lotado retorna -1.
    public int registrar(String nome){
        if(ocupados == quartos.length) return -1; // sinaliza que entupiu e não cadastrou

        quartos[ocupados] = nome; // registra o hóspede
        ocupados++; // aumenta o ocupados
        return ocupados-1; // retorna o número do quarto;
    }

    //Quero um método que imprima a lista de hóspedes e os quartos em que estão hospedados.
    public void listar(){
        for(int i=0; i<ocupados; i++){
            System.out.printf("Quarto %d - Hóspede %s\n", i, quartos[i]);
        }
    }
}

// pra testar, não precisa digitar, só crie um hotel e chame os métodos nele pra ir adicionando
// hóspedes e depois chame o método de imprimir
