package com.gerenciartarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciartarefas.entities.GerenciarTarefas;
import com.gerenciartarefas.service.GerenciarTarefasService;

@RestController
@RequestMapping("/gerenciarTarefas") 
public class GerenciarTarefasController {
    private final GerenciarTarefasService gerenciarTarefasService; 

    @Autowired
    public GerenciarTarefasController(GerenciarTarefasService gerenciarTarefasService) {
        this.gerenciarTarefasService = gerenciarTarefasService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<GerenciarTarefas> buscaGerenciarTarefasControlId(@PathVariable Long codigo) {
        GerenciarTarefas gerenciarTarefas = gerenciarTarefasService.buscaGerenciarTarefasPeloCodigo(codigo); 
        if (gerenciarTarefas != null) {
            return ResponseEntity.ok(gerenciarTarefas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<GerenciarTarefas>> buscaTodosGerenciarTarefasControl() { 
        List<GerenciarTarefas> gerenciarTarefas = gerenciarTarefasService.buscaTodosGerenciarTarefas();
        return ResponseEntity.ok(gerenciarTarefas);
    }

    @PostMapping("/")
    public ResponseEntity<GerenciarTarefas> salvaGerenciarTarefasControl(@RequestBody GerenciarTarefas gerenciarTarefas) { 
        GerenciarTarefas salvaGerenciarTarefas = gerenciarTarefasService.salvaGerenciarTarefas(gerenciarTarefas);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaGerenciarTarefas);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<GerenciarTarefas> alteraGerenciarTarefasControl(@PathVariable Long codigo, @RequestBody GerenciarTarefas gerenciarTarefas) { 
        GerenciarTarefas alteraGerenciarTarefas = gerenciarTarefasService.alterarGerenciarTarefas(codigo, gerenciarTarefas);
        if (alteraGerenciarTarefas != null) {
            return ResponseEntity.ok(gerenciarTarefas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaGerenciarTarefasControl(@PathVariable Long codigo) { 
        boolean apagar = gerenciarTarefasService.apagarGerenciarTarefas(codigo);
        if (apagar) {
            return ResponseEntity.ok().body("A Tarefa foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}