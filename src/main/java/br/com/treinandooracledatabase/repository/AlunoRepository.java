/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.treinandooracledatabase.repository;

import br.com.treinandooracledatabase.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pedro
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
