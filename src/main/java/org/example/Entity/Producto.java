package org.example.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Producto extends Base {
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private String imagen;
    private Boolean disponible;
}
