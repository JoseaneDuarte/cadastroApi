package com.cadastro.cadastroapi.controller;

import com.cadastro.cadastroapi.model.Pessoa;
import com.cadastro.cadastroapi.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaViewController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public String listarPessoas(Model model) {
        List<Pessoa> lista = pessoaRepository.findAll();
        model.addAttribute("pessoas", lista);
        return "lista-pessoas";
    }

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "novo-pessoa";
    }

    @PostMapping
    public String salvarPessoa(@Valid @ModelAttribute Pessoa pessoa, BindingResult result) {
        if (result.hasErrors()) {
            return "novo-pessoa"; // redireciona de volta pro formulário se houver erro
        }

        pessoaRepository.save(pessoa);
        return "redirect:/pessoas";
    }
}
