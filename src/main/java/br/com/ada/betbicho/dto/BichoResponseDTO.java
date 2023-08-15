package br.com.ada.betbicho.dto;

public class BichoResponseDTO {

    private String codigo;

    public BichoResponseDTO(Long id, String nome){
        this.codigo = nome + "#" + id.toString();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
