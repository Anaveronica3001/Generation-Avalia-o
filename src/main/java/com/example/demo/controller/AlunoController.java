package com.example.demo.controller;


import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Operation(summary = "Listar Alunos", description = "Mostra a lista de todos os alunos cadastrados")
    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @Operation(summary = "Consultar Aluno por ID", description = "Mostra um aluno pelo ID")
    @GetMapping("/{id}")
    public Optional<Aluno> encontrarAluno(@PathVariable Long id) {
        return alunoService.encontrarAlunoPorId(id);
    }

    @Operation(summary = "Realizar o cadastro de um aluno", description = "Realiza o cadastro de um novo aluno")
    @PostMapping
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
        return alunoService.adicionarAluno(aluno);
    }

    @Operation(summary = "Atualizar alunos cadastrados", description = "Atualiza o registro de um aluno pelo id")
    @PutMapping("/{id}")
    public Aluno editarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.editarAluno(id, aluno);
    }

    @Operation(summary = "Deletar Alunos Cadastrados", description = "Deleta um aluno pelo id")
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
