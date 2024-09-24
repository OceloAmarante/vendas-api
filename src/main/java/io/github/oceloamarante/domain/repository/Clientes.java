package io.github.oceloamarante.domain.repository;

import io.github.oceloamarante.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    //usando HQL
    @Query(value = " select c from Cliente c where c.nome like :nome ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    //usando SQL nativo
    //@Query(value = " select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    //List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying //Necessário usar essa annotation quando for deletar ou dar um update na tabela
    void deleteByNome(String nome);

    //List<Cliente> findByNomeLike(String nome);

    //List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos p where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
