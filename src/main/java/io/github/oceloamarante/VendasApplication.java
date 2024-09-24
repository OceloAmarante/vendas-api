package io.github.oceloamarante;

import io.github.oceloamarante.domain.entity.Cliente;
import io.github.oceloamarante.domain.entity.Pedido;
import io.github.oceloamarante.domain.repository.Clientes;
import io.github.oceloamarante.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ){
        return args -> {
            System.out.println("Salvando clientes:");
            clientes.save(new Cliente("João"));
            //clientes.save(new Cliente("Maria"));

            Cliente maria = new Cliente("Maria");
            clientes.save(maria);

            Pedido p = new Pedido();
            p.setCliente(maria);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(maria.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(maria).forEach(System.out::println);

//            List<Cliente> result = clientes.encontrarPorNome("João");
//            result.forEach(System.out::println);

//            boolean existe = clientes.existsByNome("João");
//            System.out.println("Existe um cliente com o nome João? " + existe);

//            List<Cliente> todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Atualizando clientes:");
//            todosClientes.forEach(c -> {
//                c.setNome(c.getNome() + " atualizado.");
//                clientes.save(c);
//            });
//
//            todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Buscando clientes:");
//            clientes.findByNomeLike("Mar").forEach(System.out::println);
//
//            System.out.println("excluindo clientes");
//            clientes.findAll().forEach(c -> {
//                clientes.delete(c);
//            });
//
//            todosClientes = clientes.findAll();
//            if(todosClientes.isEmpty()){
//                System.out.println("Nenhum cliente encontrado.");
//            }else{
//                todosClientes.forEach(System.out::println);
//            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}