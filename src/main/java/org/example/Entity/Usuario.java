package org.example.Entity;

import Enum.Rol;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    @ToString.Exclude
    private String contrasena;
    private Rol rol;
    @ToString.Exclude
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    public void addPedido(Pedido pedido) {this.pedidos.add(pedido);};
}
