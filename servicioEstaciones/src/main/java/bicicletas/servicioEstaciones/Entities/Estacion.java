package bicicletas.servicioEstaciones.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDateTime;

@Entity(name = "Estacion")
@Data
@Table(name="ESTACIONES")
@AllArgsConstructor
@NoArgsConstructor
public class Estacion {

    @Schema(description = "Identificador de la estacion", example = "1", required = true)
    @Id
    @GeneratedValue(generator = "ESTACIONES")
    @TableGenerator(name = "ESTACIONES", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private long id;

    @Schema(description = "Nombre de la Estacion", example = "UTN")
    @Column(name = "nombre")
    private String nombre;

    @Schema(description = "Fecha y hora de creacion", example = "2018-09-12T21:22:30")
    @Column(name = "fecha_hora_creacion")
    private LocalDateTime fechaHoraCreacion;

    @Schema(description = "Longitud", example = "-64.19409112111947")
    @Column(name = "longitud")
    private double longitud;

    @Schema(description = "Latitud", example = "-31.442961123175007")
    @Column(name = "latitud")
    private double latitud;
}
