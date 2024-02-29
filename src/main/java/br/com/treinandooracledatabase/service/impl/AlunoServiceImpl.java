/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.treinandooracledatabase.service.impl;

import br.com.treinandooracledatabase.model.Aluno;
import br.com.treinandooracledatabase.payload.AlunoDto;
import br.com.treinandooracledatabase.repository.AlunoRepository;
import br.com.treinandooracledatabase.service.AlunoService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class AlunoServiceImpl implements AlunoService{
    
    private ModelMapper model;
    private AlunoRepository alunoRepository;

    public AlunoServiceImpl(ModelMapper model, AlunoRepository alunoRepository) {
        this.model = model;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AlunoDto createAluno(AlunoDto alunoDto) {
        Aluno aluno = model.map(alunoDto, Aluno.class);
        
        aluno = alunoRepository.save(aluno);
        
        return model.map(aluno, AlunoDto.class);
        
    }

    @Override
    public List<AlunoDto> getAllAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        
        return alunos.stream().map(aluno -> model.map(aluno, AlunoDto.class)).collect(Collectors.toList());
    }

    @Override
    public AlunoDto updateAluno(AlunoDto alunoDto, Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        
        aluno.setNome(alunoDto.getNome());
        aluno.setSobrenome(alunoDto.getSobrenome());
        aluno.setIdade(alunoDto.getIdade());
        aluno.setNomeResponsavel(alunoDto.getNomeResponsavel());
        alunoRepository.save(aluno);
        
        return model.map(aluno, AlunoDto.class);
    }

    @Override
    public void deleteAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        alunoRepository.delete(aluno);
    }
    
}
