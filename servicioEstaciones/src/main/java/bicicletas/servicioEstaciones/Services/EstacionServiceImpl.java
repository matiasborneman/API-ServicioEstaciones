package bicicletas.servicioEstaciones.Services;

import bicicletas.servicioEstaciones.Entities.Dto.EstacionDto;
import bicicletas.servicioEstaciones.Entities.Estacion;
import bicicletas.servicioEstaciones.Repositories.EstacionRepository;
import bicicletas.servicioEstaciones.Services.Mappers.EstacionDtoMapper;
import bicicletas.servicioEstaciones.Services.Mappers.EstacionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EstacionServiceImpl implements EstacionService{

    private final EstacionRepository estacionRepository;
    private final EstacionDtoMapper dtoMapper;
    private final EstacionMapper entityMapper;


    public EstacionServiceImpl(EstacionRepository estacionRepository,
                                    EstacionDtoMapper mapper,
                                    EstacionMapper entityMapper) {
        this.estacionRepository = estacionRepository;
        this.dtoMapper = mapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public EstacionDto add(EstacionDto entity) {
        Optional<Estacion> estacion = Stream.of(entity).map(entityMapper).findFirst();
        this.estacionRepository.save(estacion.get());
        return estacion.map(dtoMapper).orElseThrow();
    }

    @Override
    public EstacionDto update(EstacionDto entity) {
        Optional<Estacion> estacion = Stream.of(entity).map(entityMapper).findFirst();
        estacion.ifPresent(estacionRepository::save);
        return estacion.map(dtoMapper).orElseThrow();
    }

    @Override
    public EstacionDto delete(Long id) {
        EstacionDto estacion = this.getById(id);
        if (estacion != null) {
            Optional<Estacion> entity = Stream.of(estacion).map(entityMapper).findFirst();
            entity.ifPresent(estacionRepository::delete);
        }
        return estacion;
    }

    @Override
    public EstacionDto getById(Long id) {
        Optional<Estacion> estacion = this.estacionRepository.findById(id);
        return estacion.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<EstacionDto> getAll() {
        List<Estacion> estaciones = this.estacionRepository.findAll();
        return estaciones
                .stream()
                .map(dtoMapper)
                .toList();
    }

}
