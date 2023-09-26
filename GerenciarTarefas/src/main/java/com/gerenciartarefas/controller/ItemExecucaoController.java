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

import com.gerenciartarefas.entities.ItemExecucao;
import com.gerenciartarefas.service.ItemExecucaoService;

@RestController
@RequestMapping("/itemExecucao")
public class ItemExecucaoController {
    private final ItemExecucaoService itemExecucaoService;

    @Autowired
    public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
        this.itemExecucaoService = itemExecucaoService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemExecucao> buscaItemExecucaoControlId(@PathVariable Long codigo) {
        ItemExecucao itemExecucao = itemExecucaoService.buscaItemExecucaoPeloCodigo(codigo);
        if (itemExecucao != null) {
            return ResponseEntity.ok(itemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ItemExecucao>> buscaTodosItemExecucaoControl() {
        List<ItemExecucao> itemExecucao = itemExecucaoService.buscaTodosItemExecucao();
        return ResponseEntity.ok(itemExecucao);
    }

    @PostMapping("/")
    public ResponseEntity<ItemExecucao> salvaItemExecucaoControl(@RequestBody ItemExecucao itemExecucao) {
        ItemExecucao salvaItemExecucao = itemExecucaoService.salvaItemExecucao(itemExecucao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemExecucao);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ItemExecucao> alteraItemExecucaoControl(@PathVariable Long codigo, @RequestBody ItemExecucao itemExecucao) {
        ItemExecucao alteraItemExecucao = itemExecucaoService.alterarItemExecucao(codigo, itemExecucao);
        if (alteraItemExecucao != null) {
            return ResponseEntity.ok(itemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaItemExecucaoControl(@PathVariable Long codigo) {
        boolean apagar = itemExecucaoService.apagarItemExecucao(codigo);
        if (apagar) {
            return ResponseEntity.ok().body("O Item foi excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
