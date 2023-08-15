package br.com.ada.betbicho.service;

import br.com.ada.betbicho.dto.ApostadorRequestDTO;
import br.com.ada.betbicho.dto.ApostadorResponseDTO;
import br.com.ada.betbicho.entity.Apostador;
import br.com.ada.betbicho.exception.ApostadorNaoEncontradoException;
import br.com.ada.betbicho.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApostadorService {

    private final ApostadorRepository apostadorRepository;

    @Autowired
    public ApostadorService(ApostadorRepository apostadorRepository) {
        this.apostadorRepository = apostadorRepository;
    }

    public ApostadorResponseDTO salvar(ApostadorRequestDTO apostadorRequestDTO) {
        Apostador apostador = ApostadorRequestDTO.toEntity(apostadorRequestDTO);
        return new ApostadorResponseDTO(apostador);
    }

    public Apostador buscarPorId(Long id) {
        Optional<Apostador> apostadorOptional = apostadorRepository.findById(id);
        if (apostadorOptional.isEmpty()) {
            throw new ApostadorNaoEncontradoException("Apostador não encontrado");
        }
        return apostadorOptional.get();
    }

    public ApostadorResponseDTO atualizar(ApostadorRequestDTO apostadorRequestDTO, Long id) {
        Optional<Apostador> apostadorOptional = this.apostadorRepository.findById(id);
        if (apostadorOptional.isEmpty()) {
            throw new ApostadorNaoEncontradoException("Apostador não encontrado");
        }
        Apostador apostador = ApostadorRequestDTO.toEntity(apostadorRequestDTO, apostadorOptional.get().getId());
        apostador = this.apostadorRepository.save(apostador);
        return new ApostadorResponseDTO(apostador);
    }

    public void deletar(Long id) {
        this.apostadorRepository.deleteById(id);
    }

    public Apostador buscarIdOuNome(String nome, Long id) {
        if (nome != null) {
            Optional<Apostador> byNome = this.apostadorRepository.findByNome(nome);
            if (byNome.isEmpty()) {
                throw new ApostadorNaoEncontradoException("Apostador não encontrado com o nome " + nome);
            }
            return byNome.get();
        }
        Optional<Apostador> byId = this.apostadorRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ApostadorNaoEncontradoException("Apostador não encontrado com o id " + id);
        }
        return byId.get();
    }
}
