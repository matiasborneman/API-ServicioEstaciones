package bicicletas.servicioEstaciones.Services.Mappers;

import bicicletas.servicioEstaciones.Entities.Dto.EstacionDto;
import bicicletas.servicioEstaciones.Entities.Estacion;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class EstacionMapper implements Function<EstacionDto, Estacion> {
    @Override
    public Estacion apply(EstacionDto estacionDto){
        return new Estacion(
                estacionDto.getId(),
                estacionDto.getNombre(),
                estacionDto.getFechaHoraCreacion(),
                estacionDto.getLongitud(),
                estacionDto.getLatitud()
        );
    }
}
