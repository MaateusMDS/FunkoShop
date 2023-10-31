package br.com.fiap.FunkoShop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Users")
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    private Boolean enabled;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public String getUser() {
        return username;
    }

    public User setUser(String user) {
        this.username = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
