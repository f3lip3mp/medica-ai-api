package com.medicaai.medicaai.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentosController {
    @GetMapping
    public String listarMedicamentos() {
        return "Lista de Medicamentos!";
    }
}
