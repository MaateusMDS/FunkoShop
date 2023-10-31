package br.com.fiap.FunkoShop.repository;

import br.com.fiap.FunkoShop.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.FunkoShop.model.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Cacheable("pedidos")
    Page<Pedido> findByStatus(StatusPedido status, Pageable pageable);
    List<Pedido> findAllByUserUsername(String username);
    List<Pedido> findAllByUserUsernameAndStatus(String username, StatusPedido status);
}
