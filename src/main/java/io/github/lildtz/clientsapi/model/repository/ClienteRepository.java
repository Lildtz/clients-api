package io.github.lildtz.clientsapi.model.repository;

import io.github.lildtz.clientsapi.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
