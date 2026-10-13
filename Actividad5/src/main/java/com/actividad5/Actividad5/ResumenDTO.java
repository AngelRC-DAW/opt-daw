package com.actividad5.Actividad5;

import java.math.BigDecimal;

public class ResumenDTO {
    private String cliente;
    private int totalProductos;
    private BigDecimal precioTotal;
    private String mensaje;

    public ResumenDTO(String cliente, int totalProductos, BigDecimal precioTotal, String mensaje) {
        this.cliente = cliente;
        this.totalProductos = totalProductos;
        this.precioTotal = precioTotal;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getCliente() {
        return cliente;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public String getMensaje() {
        return mensaje;
    }
}
