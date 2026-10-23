package org.example.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal;
    private Producto producto;
}
