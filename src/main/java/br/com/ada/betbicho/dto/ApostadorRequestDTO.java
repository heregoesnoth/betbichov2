package br.com.ada.betbicho.dto;

import br.com.ada.betbicho.entity.Apostador;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ApostadorRequestDTO {
    public ApostadorRequestDTO() {
    }

    public ApostadorRequestDTO(Apostador apostador) {
        this.setNome(apostador.getNome());
        this.setCpf(apostador.getCpf());
        this.setIdade(apostador.getIdade());
        this.setEmail(apostador.getEmail());
        this.setEndereco(apostador.getEndereco());
    }

    public static Apostador toEntity(ApostadorRequestDTO apostadorRequestDTO) {
        Apostador apostador = new Apostador();
        apostador.setNome(apostadorRequestDTO.getNome());
        apostador.setCpf(apostadorRequestDTO.getCpf());
        apostador.setIdade(apostadorRequestDTO.getIdade());
        apostador.setEmail(apostadorRequestDTO.getEmail());
        apostador.setEndereco(apostadorRequestDTO.getEndereco());
        return apostador;
    }

    public static Apostador toEntity(ApostadorRequestDTO apostadorRequestDTO, Long id) {
        Apostador apostador = new Apostador();
        apostador.setId(id);
        apostador.setNome(apostadorRequestDTO.getNome());
        apostador.setCpf(apostadorRequestDTO.getCpf());
        apostador.setIdade(apostadorRequestDTO.getIdade());
        apostador.setEmail(apostadorRequestDTO.getEmail());
        apostador.setEndereco(apostadorRequestDTO.getEndereco());
        return apostador;
    }


    @NotBlank
    private String nome;

    @NotNull(message = "Idade não pode ser nulo")
    private Integer idade;

    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "CPF com formato inválido (XXX.XXX.XXX-XX)")
    private String cpf;

    @Email(message = "Email deve ser válido")
    private String email;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
