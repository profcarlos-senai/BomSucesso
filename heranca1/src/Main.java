public class Main {
    public static void main(String[] args) {

        Pet pet;

        pet = new Cachorro();
        pet.setNome("Juca");
        pet.falar();

        pet = new Gato();
        pet.falar();

        pet = new Papagaio();
        pet.falar();
    }
}