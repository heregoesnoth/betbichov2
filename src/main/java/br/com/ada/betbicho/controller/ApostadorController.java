package br.com.ada.betbicho.controller;

import br.com.ada.betbicho.dto.ApostadorRequestDTO;
import br.com.ada.betbicho.dto.ApostadorResponseDTO;
import br.com.ada.betbicho.entity.Apostador;
import br.com.ada.betbicho.service.ApostadorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/apostador")
public class ApostadorController {
    private final ApostadorService apostadorService;

    @Autowired
    public ApostadorController(ApostadorService apostadorService) {
        this.apostadorService = apostadorService;
    }

    @Operation(summary = "Cadastrar apostador", description = "Endpoint para cadastrar apostador")
    @PostMapping
    public ResponseEntity<ApostadorResponseDTO> cadastrar(@RequestBody @Valid ApostadorRequestDTO apostadorRequestDTO){
        return ResponseEntity.ok(this.apostadorService.salvar(apostadorRequestDTO));
    }

    @Operation(summary = "Consultor apostador", description = "Consulta apostador por id")
    @GetMapping("/{id}")
    public ResponseEntity<Apostador> buscarporId(@PathVariable Long id){
        return ResponseEntity.ok(this.apostadorService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Apostador> buscarIdOuNome(@RequestParam(required = false) String nome, @RequestParam(required = false) Long id){
        return ResponseEntity.ok(this.apostadorService.buscarIdOuNome(nome, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApostadorResponseDTO> atualizar(@RequestBody ApostadorRequestDTO apostadorRequestDTO, @PathVariable Long id){
        return ResponseEntity.ok(this.apostadorService.atualizar(apostadorRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        apostadorService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
