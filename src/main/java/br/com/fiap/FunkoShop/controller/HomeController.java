package br.com.fiap.FunkoShop.controller;


import java.security.Principal;
import java.util.List;

import br.com.fiap.FunkoShop.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.FunkoShop.model.Pedido;
import br.com.fiap.FunkoShop.repository.PedidoRepository;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public ModelAndView home(@PageableDefault(size = 2, sort = {"dataDaEntrega"}, direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, pageable);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
}
