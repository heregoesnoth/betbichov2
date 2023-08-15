package br.com.ada.betbicho.mapper;

import br.com.ada.betbicho.dto.ApostadorRequestDTO;
import br.com.ada.betbicho.entity.Apostador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApostadorMapper {

    ApostadorRequestDTO apostadorParaApostadorRequestDTO(Apostador apostador);
}
