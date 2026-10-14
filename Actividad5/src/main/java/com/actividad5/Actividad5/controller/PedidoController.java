package com.actividad5.Actividad5.controller;
import com.actividad5.Actividad5.Pedido;
import com.actividad5.Actividad5.Producto;
import com.actividad5.Actividad5.ResumenDTO;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @PostMapping("/pedido")
    public ResumenDTO procesarPedido(@RequestBody Pedido pedido) {
        Integer totalProductos = 0;
        BigDecimal precioTotal = BigDecimal.ZERO;

        // Recorremos la lista de productos para sumar cantidades y calcular subtotales
        for (Producto p : pedido.getProductos()) {
            totalProductos += p.getCantidad();

            // Multiplicamos precioUnitario * cantidad usando BigDecimal
            BigDecimal subtotal = p.getPrecioUnitario().multiply(new BigDecimal(p.getCantidad()));
            precioTotal = precioTotal.add(subtotal);
        }

        String nombreCliente = pedido.getCliente().getNombre();

        // Devolvemos la respuesta con el resumen
        return new ResumenDTO(
                nombreCliente,
                totalProductos,
                precioTotal,
                "Pedido recibido correctamente"
        );
    }
}