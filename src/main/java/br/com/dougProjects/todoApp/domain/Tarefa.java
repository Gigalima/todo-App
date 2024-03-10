package br.com.dougProjects.todoApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tarefa extends AbstractPersistable<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nome;
    private String descricao;
    private int qtdvisualizado;
    private int qtdRealizacoes;

    public Tarefa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdvisualizado = 0;
        this.qtdRealizacoes = 0;
    }

    public void addQtd() {
        this.qtdvisualizado += 1;
    }
    public void addRealizacoes() {
        this.qtdRealizacoes += 1;
    }

}
