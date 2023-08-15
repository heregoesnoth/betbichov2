package br.com.ada.betbicho.service;

import br.com.ada.betbicho.dto.BichoRequestDTO;
import br.com.ada.betbicho.dto.BichoResponseDTO;
import br.com.ada.betbicho.entity.Bicho;
import br.com.ada.betbicho.repository.BichoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BichoService {

    private final BichoRepository bichoRepository;

    @Autowired
    public BichoService(BichoRepository bichoRepository) {
        this.bichoRepository = bichoRepository;
    }

    public BichoResponseDTO salvar(BichoRequestDTO bichoRequestDTO){
        Bicho bicho = new Bicho();
        String[] arr = bichoRequestDTO.getCodigo().split("\\$");
        bicho.setId(Long.valueOf(arr[0]));
        bicho.setNome(arr[1]);
        Bicho bichoSalvo = this.bichoRepository.save(bicho);
        return new BichoResponseDTO(bichoSalvo.getId(), bichoSalvo.getNome());
    }

    public BichoResponseDTO atualizar(BichoRequestDTO bichoRequestDTO, Long id){
        Bicho bicho = this.bichoRepository.findById(id).get();
        String[] arr = bichoRequestDTO.getCodigo().split("\\$");
        bicho.setNome(arr[1]);
        Bicho bichoSalvo = this.bichoRepository.save(bicho);
        return new BichoResponseDTO(bichoSalvo.getId(), bichoSalvo.getNome());
    }

    public List<Bicho> buscarTodos(){
        return this.bichoRepository.findAll();
    }

    public Bicho buscarPorId(Long id){
        return this.bichoRepository.findById(id).get();
    }

    public Bicho buscar(Long id, String nome){
        if (nome != null){
            return this.bichoRepository.findBichoByNome(nome).get();
        }
        return this.bichoRepository.findById(id).get();
    }

    public void deletar(Long id){
        this.bichoRepository.deleteById(id);
    }

}
