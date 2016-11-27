package objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Voidk on 25/10/2016.
 */

public class Recipes implements Serializable {
    private String Nome;
    private List<String> ingredientes;
    private List<String> passos;

    public Recipes(String nome, List<String> ingredientes, List<String> passos) {
        Nome = nome;
        this.ingredientes = ingredientes;
        this.passos = passos;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getPassos() {
        return passos;
    }

    public void setPassos(List<String> passos) {
        this.passos = passos;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
