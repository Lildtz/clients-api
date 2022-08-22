package io.github.lildtz.clientsapi.model.repository;

import io.github.lildtz.clientsapi.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
