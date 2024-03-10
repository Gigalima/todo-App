package br.com.dougProjects.todoApp.repository;

import br.com.dougProjects.todoApp.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
