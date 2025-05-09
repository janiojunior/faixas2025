package br.unitins.tp1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {
    ADM(1, "Adm"), 
    USER(2, "User");

    private final int ID;
    private final String NOME;

    Perfil(int id, String nome) {
        this.ID = id;
        this.NOME = nome;
    }

    public int getId() {
        return ID;
    }

    public String getNome() {
        return NOME;
    }

     public static Perfil valueOf(Integer id) {
        if (id == null)
            return null;
        for (Perfil r : Perfil.values()) {
            if (r.getId() == id)
                return r;
        }
        return null;
     }

}
