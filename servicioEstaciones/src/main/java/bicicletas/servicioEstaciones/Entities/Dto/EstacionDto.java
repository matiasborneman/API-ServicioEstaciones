package bicicletas.servicioEstaciones.Entities.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionDto {
    @Schema(description = "Identificador de la estacion", example = "1", required = true)
    private long id;
    @Schema(description = "Nombre de la Estacion", example = "UTN")
    private String nombre;
    @Schema(description = "Fecha y hora de creacion", example = "2018-09-12T21:22:30")
    private LocalDateTime fechaHoraCreacion;
    @Schema(description = "Longitud", example = "-64.19409112111947")
    private double longitud;
    @Schema(description = "Latitud", example = "-31.442961123175007")
    private double latitud;
}
