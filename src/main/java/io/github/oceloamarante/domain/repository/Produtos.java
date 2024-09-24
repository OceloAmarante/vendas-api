package io.github.oceloamarante.domain.repository;

import io.github.oceloamarante.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
