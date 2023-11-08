package bicicletas.servicioEstaciones.Controllers;


import bicicletas.servicioEstaciones.Entities.Dto.EstacionDto;
import bicicletas.servicioEstaciones.Entities.Estacion;
import bicicletas.servicioEstaciones.Services.EstacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Estaciones", description = "Catalogo de Estaciones")
@RequestMapping("/estacion")
public class EstacionController {
    private EstacionService estacionService;

    public EstacionController(EstacionService estacionService) {
        this.estacionService = estacionService;
    }

    @GetMapping
    @Operation(summary = "Obtiene el listado de Estaciones")
    public ResponseEntity<List<EstacionDto>> getAll() {
        List<EstacionDto> values = this.estacionService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    @Operation(summary = "Registra una nueva estacion")
    /*@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra la estacion", content = @Content(schema = @Schema(implementation = Estacion.class)))
    })**/
    public ResponseEntity<EstacionDto> add(@RequestBody EstacionDto estacionDto) {
        EstacionDto estacion =  this.estacionService.add(estacionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estacion);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una Estacion determinada")
    /*@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe la Estacion", content = @Content(schema = @Schema(implementation = Estacion.class))),
            @ApiResponse(responseCode = "404", description = "La estacion no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })**/
    public ResponseEntity<EstacionDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.estacionService.getById(id));
    }
}
