/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.treinandooracledatabase.controller;

import br.com.treinandooracledatabase.payload.AlunoDto;
import br.com.treinandooracledatabase.service.AlunoService;
import java.util.List;
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

/**
 *
 * @author Pedro
 */
@RestController
@RequestMapping("/api")
public class AlunoController {
    
    private AlunoService alunoService;
    
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    
    @PostMapping
    public ResponseEntity<AlunoDto> createAluno(@RequestBody AlunoDto alunoDto) {
        return new ResponseEntity(alunoService.createAluno(alunoDto), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<AlunoDto>> getAllAlunos() {
        return ResponseEntity.ok(alunoService.getAllAlunos());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> updateAluno(@RequestBody AlunoDto alunoDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(alunoService.updateAluno(alunoDto, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.ok("Aluno excluido com sucesso!");
    }
}
