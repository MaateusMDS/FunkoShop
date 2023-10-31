package br.com.fiap.FunkoShop.repository;

import br.com.fiap.FunkoShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
