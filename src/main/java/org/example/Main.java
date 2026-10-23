package org.example;

import Enum.Estado;
import Enum.FormaPago;
import Enum.Rol;
import org.example.Entity.Categoria;
import org.example.Entity.Pedido;
import org.example.Entity.Producto;
import org.example.Entity.Usuario;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        //Usuarios creados
        Usuario usuario1 = Usuario.builder().nombre("Roberto").apellido("Perez").mail("perezroberto1@gmail.com").celular("261287980").contrasena("PerezRoberto").rol(Rol.USUARIO).build();
        Usuario usuario2 = Usuario.builder().nombre("Juan").apellido("Martinez").mail("juanmaritnez2@gmail.com").celular("261777888").contrasena("JuanMartinez2").rol(Rol.USUARIO).build();

        //Lista de usuarios
        Set<Usuario> usuarios = new HashSet<>();

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        //Productos creados
        Producto teclado = Producto.builder().nombre("Teclado").descripcion("Teclado").precio(40.0).stock(9).imagen("foto teclado").disponible(true).build();
        Producto video = Producto.builder().nombre("Video").descripcion("Video").precio(15.0).stock(10).imagen("Foto video").disponible(true).build();
        Producto notebook = Producto.builder().nombre("Notebook").descripcion("Computador").precio(70.0).stock(5).imagen("Foto computador").disponible(true).build();
        Producto mouse = Producto.builder().nombre("Mouse").descripcion("Mouse").precio(80.0).stock(2).imagen("Foto mouse").disponible(true).build();
        Producto auriculares = Producto.builder().nombre("Auriculares").descripcion("Auriculares").precio(25.0).stock(0).imagen("Foto auriculares").disponible(false).build();
        Producto placaVideo = Producto.builder().nombre("PlacaVideo").descripcion("PlacaVideo").precio(100.0).stock(7).imagen("Foto placaVideo").disponible(true).build();
        Producto remera = Producto.builder().nombre("Remera").descripcion("Remera").precio(17.0).stock(5).imagen("Foto remera").disponible(true).build();
        Producto zapatillas = Producto.builder().nombre("Zapatillas").descripcion("Calzado").precio(100.0).stock(25).imagen("Foto zapatillas").disponible(true).build();
        Producto detergente = Producto.builder().nombre("Detergente").descripcion("Para limpiar").precio(5.0).stock(100).imagen("Foto para limpiar").disponible(true).build();
        Producto esponja = Producto.builder().nombre("Esponja").descripcion("Para la casa").precio(7.0).stock(200).imagen("Foto para la casa").disponible(true).build();

        //Entity.Producto repetido
        //Producto notebookrepetida = new Producto("Notebook", "Computador", 70.0, 5, "Foto computador", true);
        Producto notebookrepetida = Producto.builder().nombre("Notebook").descripcion("Computador").precio(70.0).stock(5).imagen("Foto computador").disponible(true).build();

        //Lista de productos
        Set<Producto> productos = new HashSet<>();
        productos.add(notebook);
        productos.add(teclado);
        productos.add(video);
        productos.add(mouse);
        productos.add(auriculares);
        productos.add(placaVideo);
        productos.add(remera);
        productos.add(zapatillas);
        productos.add(detergente);
        productos.add(esponja);


        //Categorias creadas
        //Categoria electronica = new Categoria("Electronica", "Productos con electricidad");
        //Categoria ropa = new Categoria("Ropa", "Productos con ropas");
        //Categoria limpieza = new Categoria("Limpieza", "Productos para limpieza");
        Categoria electronica = Categoria.builder().nombre("Electronica").descripcion("Productos de electricidad").build();
        Categoria ropa = Categoria.builder().nombre("Ropa").descripcion("Productos de ropas").build();
        Categoria limpieza = Categoria.builder().nombre("Limpieza").descripcion("Productos para limpieza").build();

        //Productos guardados en las categorias
        electronica.listaProductos(notebook);
        electronica.listaProductos(teclado);
        electronica.listaProductos(video);
        electronica.listaProductos(mouse);
        electronica.listaProductos(auriculares);
        electronica.listaProductos(placaVideo);
        ropa.listaProductos(remera);
        ropa.listaProductos(zapatillas);
        limpieza.listaProductos(detergente);
        limpieza.listaProductos(esponja);


        //Pedidos creados con sus detalles
        Pedido pedido1 = Pedido.builder().fecha(LocalDate.now()).estado(Estado.CONFIRMADO).total(24.5).formapago(FormaPago.EFECTIVO).usuario(usuario1).build();

        pedido1.addDetallePedido(3, notebook);
        pedido1.addDetallePedido(2, teclado);

        Pedido pedido2 = Pedido.builder().fecha(LocalDate.now()).estado(Estado.PENDIENTE).total(56.8).formapago(FormaPago.TARJETA).usuario(usuario1).build();

        pedido2.addDetallePedido(2, placaVideo);
        pedido2.addDetallePedido(3, video);


        //Pedido pedido3 = new Pedido(LocalDate.now(), Estado.CANCELADO, 9.6, FormaPago.TRANSFERENCIA, usuario2);
        Pedido pedido3 = Pedido.builder().fecha(LocalDate.now()).estado(Estado.CANCELADO).total(9.6).formapago(FormaPago.TRANSFERENCIA).usuario(usuario2).build();

        pedido3.addDetallePedido(3, zapatillas);
        pedido3.addDetallePedido(3, remera);

        //Agrego los pedidos al usuario
        usuario1.addPedido(pedido1);
        usuario1.addPedido(pedido2);
        usuario2.addPedido(pedido3);

        //Muestra por consola los productos disponibles
        System.out.println("Mostrar por consola los productos disponibles");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        //Mostrar por consola la cantidad de items que tiene un pedido
        System.out.println("Cantidad de items para el pedido 1");
        System.out.println(pedido1.getDetallepedidos().stream().map(detallePedido -> detallePedido.getCantidad()).reduce(0, (acumulador, cantidad) -> acumulador + cantidad));

        //Productos que tengan menos de 5 como valor en stock
        System.out.println("Productos con stock menor a 5");
        productos.stream().filter(producto -> producto.getStock() < 5).forEach(producto -> System.out.println(producto));
    }
}
