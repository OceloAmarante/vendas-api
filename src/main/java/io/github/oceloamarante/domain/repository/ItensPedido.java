package io.github.oceloamarante.domain.repository;

import io.github.oceloamarante.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
