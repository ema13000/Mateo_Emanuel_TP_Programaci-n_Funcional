package org.example.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true,  callSuper = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Categoria extends Base {
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private String nombre;
    private String descripcion;
    @ToString.Exclude
    @Builder.Default
    private Set<Producto> producto = new HashSet<>();

    public void listaProductos(Producto productos) {
        this.producto.add(productos);
    }
}
