package br.com.fiap.FunkoShop.dto;

	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.Size;

	public record RequisicaoNovoPedido(
			
			@NotBlank(message = "O nome não pode ser nulo")
			@Size(min = 5, max = 250, message = "O nome do produto deve ter entre 5 e 250 caracteres.")
			String nomeProduto,
			@NotBlank(message = "O url não pode ser nulo")
			String urlProduto,
			@NotBlank(message = "A imagem não pode ser nulo")
			String urlImagem,
			@NotBlank(message = "A imagem não pode ser nulo")
			String urlImagem2,
			String descricao
			
			) {

	}



