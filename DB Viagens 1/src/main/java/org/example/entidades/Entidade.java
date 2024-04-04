package org.example.entidades;

// uma classe abstrata só serve como ancestral
// não dá pra criar objetos dela
public abstract class Entidade {
    protected Integer id; // com I maiúsculo pra poder ser NULL

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
