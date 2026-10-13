package com.actividad5.Actividad5;

import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}