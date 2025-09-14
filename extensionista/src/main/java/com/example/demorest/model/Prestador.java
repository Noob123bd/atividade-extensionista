package com.example.demorest.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;      // Nome do prestador
    private String telefone;  // Contato
    private String servico;   // Tipo de serviço (jardinagem, faxina, carpintaria)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getServico() { return servico; }
    public void setServico(String servico) { this.servico = servico; }

    @Override
    public String toString() {
        return "Prestador [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", servico=" + servico + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, telefone, servico);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prestador other = (Prestador) obj;
        return Objects.equals(id, other.id) &&
               Objects.equals(nome, other.nome) &&
               Objects.equals(telefone, other.telefone) &&
               Objects.equals(servico, other.servico);
    }
}
