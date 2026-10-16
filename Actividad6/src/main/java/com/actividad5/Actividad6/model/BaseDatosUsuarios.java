package com.actividad5.Actividad6.model;
import java.util.HashMap;
import java.util.Map;

public class BaseDatosUsuarios {
    // Map en memoria compartido con los usuarios de prueba iniciales
    public static Map<String, String> usuariosBD = new HashMap<String, String>() {{
        put("ana@example.com", "246810");
        put("luis@example.com", "clave123");
    }};
}