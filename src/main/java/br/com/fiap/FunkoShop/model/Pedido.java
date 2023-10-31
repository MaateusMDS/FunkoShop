package br.com.fiap.FunkoShop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.FunkoShop.dto.RequisicaoNovoPedido;
import jakarta.persistence.*;

@Entity(name = "Pedido")
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String urlProduto;
	private String urlImagem;
	private String urlImagem2;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Pedido() {

	}

	public Pedido(RequisicaoNovoPedido requisicao) {
		this.nomeProduto = requisicao.nomeProduto();
		this.urlProduto = requisicao.urlProduto();
		this.urlImagem = requisicao.urlImagem();
		this.descricao = requisicao.descricao();
		this.urlImagem2 = requisicao.urlImagem2();
		this.status = StatusPedido.AGUARDANDO;
	}

	public String getUrlImagem2() {
		return urlImagem2;
	}

	public void setUrlImagem2(String urlImagem2) {
		this.urlImagem2 = urlImagem2;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public Pedido setStatus(StatusPedido status) {
		this.status = status;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Pedido setUser(User user) {
		this.user = user;
		return this;
	}
}
