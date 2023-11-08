package bicicletas.servicioEstaciones.Services.Mappers;

import bicicletas.servicioEstaciones.Entities.Dto.EstacionDto;
import bicicletas.servicioEstaciones.Entities.Estacion;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class EstacionDtoMapper implements Function<Estacion, EstacionDto> {
    @Override
    public EstacionDto apply(Estacion estacion){
        return new EstacionDto(
                estacion.getId(),
                estacion.getNombre(),
                estacion.getFechaHoraCreacion(),
                estacion.getLongitud(),
                estacion.getLatitud()
        );
    }
}
