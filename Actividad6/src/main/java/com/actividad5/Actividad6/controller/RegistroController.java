package com.actividad5.Actividad6.controller;

import com.actividad5.Actividad6.model.BaseDatosUsuarios;
import com.actividad5.Actividad6.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@Controller
public class RegistroController {

    @GetMapping("/registro")
    @ResponseBody
    public String mostrarFormularioRegistro() {
        return "<!DOCTYPE html>" +
                "<html><head><title>Registro</title></head><body>" +
                "<h2>Formulario de Registro</h2>" +
                "<form action='/registro' method='post'>" +
                "  <label>Nombre (obligatorio):</label><br/>" +
                "  <input type='text' name='nombre' required/><br/><br/>" +
                "  <label>Apellidos:</label><br/>" +
                "  <input type='text' name='apellidos'/><br/><br/>" +
                "  <label>Correo electrónico (obligatorio):</label><br/>" +
                "  <input type='email' name='correo' required/><br/><br/>" +
                "  <label>Contraseña (opcional, si se deja vacía se genera sola):</label><br/>" +
                "  <input type='password' name='password'/><br/><br/>" +
                "  <button type='submit'>Registrarse</button>" +
                "</form>" +
                "</body></html>";
    }

    @PostMapping("/registro")
    @ResponseBody
    public String procesarRegistro(@ModelAttribute Usuario usuario) {
        // Comprobar en el servidor que el nombre y el correo no estén vacíos
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty() ||
                usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty()) {
            return "Error: El nombre y el correo electrónico son obligatorios.";
        }

        boolean passwordGenerada = false;
        String passwordFinal = usuario.getPassword();

        // Si la contraseña está vacía, generamos una aleatoria de 6 dígitos con ceros iniciales
        if (passwordFinal == null || passwordFinal.trim().isEmpty()) {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(1000000); // 0 a 999999
            passwordFinal = String.format("%06d", numeroAleatorio);
            passwordGenerada = true;
        }

        // Guardamos en el Map compartido
        BaseDatosUsuarios.usuariosBD.put(usuario.getCorreo(), passwordFinal);

        // Preparamos la respuesta en el cuerpo HTTP
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("Usuario registrado: ").append(usuario.getNombre()).append(" ").append(usuario.getApellidos()).append("<br/>");
        respuesta.append("Correo: ").append(usuario.getCorreo()).append("<br/>");

        if (passwordGenerada) {
            respuesta.append("Contraseña generada: ").append(passwordFinal).append("<br/>");
        }

        return respuesta.toString();
    }
}