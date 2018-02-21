package com.cardapiodigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cardapiodigital.model.Pizza;
import com.cardapiodigital.repository.CardapioRepository;

@Controller
@RequestMapping("/cardapio")
public class CardapioController {

	@Autowired
	CardapioRepository repository;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("cardapioListar");
		modelAndView.addObject("pizzas", repository.findAll());
		modelAndView.addObject(new Pizza());

		return modelAndView;
	}

	@PostMapping
	public String salvar(Pizza pizza) {

		this.repository.save(pizza);

		return "redirect:/cardapio";

	}

	@GetMapping("/editar")
	public String editar(Pizza pizza, Model model) {

		Pizza pizzaEditar = this.repository.findOne(pizza.getId());

		model.addAttribute(pizzaEditar);

		return "cardapioEditar";

	}

	@GetMapping("/excluir")
	public String excluir(Pizza pizza, Model model) {

		this.repository.delete(pizza.getId());

		return "redirect:/cardapio";

	}

}
