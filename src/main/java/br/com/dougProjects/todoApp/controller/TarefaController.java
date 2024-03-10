package br.com.dougProjects.todoApp.controller;

import br.com.dougProjects.todoApp.domain.Tarefa;
import br.com.dougProjects.todoApp.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tarefas", tarefaRepository.findAll());
        return "index";
    }
    @GetMapping("/{id}")
    public String getId(Model model, @PathVariable Long id) {
        Tarefa t = tarefaRepository.getReferenceById(id);
        model.addAttribute("tarefa", t);
        t.addQtd();
        tarefaRepository.save(t);
        return "tarefa";
    }
    @GetMapping("/edita/{id}")
    public String getTaskEditId(Model model, @PathVariable Long id) {
        Tarefa t = tarefaRepository.getReferenceById(id);
        model.addAttribute("tarefa", t);
        tarefaRepository.save(t);
        return "edit";
    }
    @PostMapping("/")
    public String addTask(@RequestParam String nome, @RequestParam String descricao) {
        tarefaRepository.save(new Tarefa(nome, descricao));
        return "redirect:/";
    }
    @PostMapping("/edita/{id}")
    public String editTask(@PathVariable Long id, @RequestParam String nome, @RequestParam String descricao) {
        Tarefa tarefa = tarefaRepository.getReferenceById(id);
        tarefa.setNome(nome);
        tarefa.setDescricao(descricao);
        tarefa.setQtdvisualizado(0);
        tarefa.setQtdRealizacoes(0);
        tarefaRepository.save(tarefa);
        return "redirect:/";
    }
    @PostMapping("/realiza/{id}")
    public String addRealiza(@PathVariable Long id) {
        Tarefa tarefa = tarefaRepository.getReferenceById(id);
        tarefa.addRealizacoes();
        tarefaRepository.save(tarefa);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        Tarefa tarefa = tarefaRepository.getReferenceById(id);
        tarefaRepository.delete(tarefa);
        return "redirect:/";
    }
}
