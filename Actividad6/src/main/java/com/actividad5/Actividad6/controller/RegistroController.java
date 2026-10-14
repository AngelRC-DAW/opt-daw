package com.actividad5.Actividad6.controller;


import com.actividad5.Actividad6.model.Registro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Random;

@Controller
public class RegistroController {

    @GetMapping("/registro")
    public String mostrarFormulario(){
        return "formulario";
    }
    @PostMapping("/registro")
    public String procesarFormulario(@ModelAttribute Registro registro){
        if (registro.getContrasenia() == null || registro.getContrasenia().isBlank()) {
            registro.setContrasenia(String.format("%06d", new Random().nextInt(1_000_000)));
        }

        return "";
    }
}
