package com.actividad5.Actividad6.controller;
import com.actividad5.Actividad6.model.BaseDatosUsuarios;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    @ResponseBody
    public String mostrarFormularioLogin() {
        return "<!DOCTYPE html>" +
                "<html><head><title>Login</title></head><body>" +
                "<h2>Iniciar Sesión</h2>" +
                "<form action='/login' method='post'>" +
                "  <label>Correo electrónico (Usuario):</label><br/>" +
                "  <input type='email' name='correo' required/><br/><br/>" +
                "  <label>Contraseña:</label><br/>" +
                "  <input type='password' name='password' required/><br/><br/>" +
                "  <button type='submit'>Entrar</button>" +
                "</form>" +
                "</body></html>";
    }

    @PostMapping("/login")
    @ResponseBody
    public String procesarLogin(@RequestParam("correo") String correo, @RequestParam("password") String password) {
        // Comprobar si el usuario existe en el Map compartido
        if (!BaseDatosUsuarios.usuariosBD.containsKey(correo)) {
            return "Usuario inexistente.";
        }

        // Comprobar si la contraseña coincide
        String passwordAlmacenada = BaseDatosUsuarios.usuariosBD.get(correo);
        if (passwordAlmacenada.equals(password)) {
            return "Inicio de sesión correcto.";
        } else {
            return "Contraseña incorrecta.";
        }
    }
}