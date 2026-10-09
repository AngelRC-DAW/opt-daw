package com.actividad4.actividad4.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TablaController {

    @GetMapping("/tabla")
    public String generarTabla(
            @RequestParam(name = "filas", required = false) String filasTexto,
            @RequestParam(name = "columnas", required = false) String columnasTexto) {

        int filas = 1;
        int columnas = 1;

        // Intentar pasar a número el parámetro filas
        try {
            if (filasTexto != null) {
                filas = Integer.parseInt(filasTexto);
            }
        } catch (NumberFormatException e) {
            filas = 1; // Si escriben letras, ponemos 1
        }

        // Intentar pasar a número el parámetro columnas
        try {
            if (columnasTexto != null) {
                columnas = Integer.parseInt(columnasTexto);
            }
        } catch (NumberFormatException e) {
            columnas = 1; // Si escriben letras, ponemos 1
        }

        // Limitar filas entre 1 y 20
        if (filas < 1) filas = 1;
        if (filas > 20) filas = 20;

        // Limitar columnas entre 1 y 20
        if (columnas < 1) columnas = 1;
        if (columnas > 20) columnas = 20;

        // Montar la tabla HTML
        String html = "<table border='1'><thead><tr>";

        // Encabezado
        for (int c = 1; c <= columnas; c++) {
            html += "<th>Columna " + c + "</th>";
        }
        html += "</tr></thead><tbody>";

        // Celdas de la tabla
        for (int f = 1; f <= filas; f++) {
            html += "<tr>";
            for (int c = 1; c <= columnas; c++) {
                html += "<td>Fila " + f + ", Columna " + c + "</td>";
            }
            html += "</tr>";
        }
        html += "</tbody></table>";

        return html;
    }
}