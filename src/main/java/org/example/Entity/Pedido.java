package org.example.Entity;


import Interface.Calculable;
import Enum.FormaPago;
import Enum.Estado;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formapago;
    @Setter(AccessLevel.NONE)
    private Usuario usuario;
    @ToString.Exclude
    @Builder.Default
    private Set<DetallePedido> detallepedidos = new HashSet<>();

    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido detallepedido = new DetallePedido();

        detallepedido.setCantidad(cantidad);
        detallepedido.setProducto(producto);
        detallepedido.setSubtotal(cantidad * producto.getPrecio());
        this.detallepedidos.add(detallepedido);

        calcularTotal();
    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto) {
        for  (DetallePedido detallepedido : detallepedidos) {
            if (detallepedido.getProducto().equals(producto)) {
                return detallepedido;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detallepedido = findeDetallePedidoByProducto(producto);

        if  (detallepedido != null) {
            detallepedidos.remove(detallepedido);
        }

        calcularTotal();
    }

    @Override
    public void calcularTotal() {
        this.total = detallepedidos.stream().map(detalle -> detalle.getSubtotal()).reduce(0.0, (acumulador, subtotal) -> acumulador + subtotal);
    }
}
