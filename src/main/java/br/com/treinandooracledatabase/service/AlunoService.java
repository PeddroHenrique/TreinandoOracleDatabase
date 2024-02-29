/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.treinandooracledatabase.service;

import br.com.treinandooracledatabase.payload.AlunoDto;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface AlunoService {
    
    AlunoDto createAluno(AlunoDto alunoDto);
    List<AlunoDto> getAllAlunos();
    AlunoDto updateAluno(AlunoDto alunoDto, Long id);
    void deleteAluno(Long id);
}
