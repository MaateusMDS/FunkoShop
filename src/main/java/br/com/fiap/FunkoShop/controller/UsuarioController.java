package br.com.fiap.FunkoShop.controller;

import br.com.fiap.FunkoShop.model.Pedido;
import br.com.fiap.FunkoShop.model.StatusPedido;
import br.com.fiap.FunkoShop.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedido")
    public ModelAndView home(Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findAllByUserUsername(principal.getName());
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping("/pedido/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status, Principal principal) {
        var pedidos = pedidoRepository.findAllByUserUsernameAndStatus(principal.getName(), StatusPedido.valueOf(status.toUpperCase()));
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        mv.addObject("status", status);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;
    }
}
