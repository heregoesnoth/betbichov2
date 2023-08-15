package br.com.ada.betbicho.dto;

import br.com.ada.betbicho.entity.Apostador;

public class ApostadorResponseDTO {

    private Long id;
    private String nome;

    public ApostadorResponseDTO(Apostador apostador) {
        this.id = apostador.getId();
        this.nome = apostador.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
