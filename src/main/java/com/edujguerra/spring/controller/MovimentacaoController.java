package com.edujguerra.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edujguerra.spring.model.Movimentacao;
import com.edujguerra.spring.repository.ConteinerRepo;
import com.edujguerra.spring.repository.MovimentacaoRepo;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoRepo movimentacoes;
	
	@Autowired
	private ConteinerRepo conteiners;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/movimentacoes/Lista");
		modelAndView.addObject("movimentacoes", movimentacoes.findAll());
		modelAndView.addObject("conteiners", conteiners.findAll());
		modelAndView.addObject(new Movimentacao());

		return modelAndView;
	}

	@PostMapping
	public String salvar(Movimentacao movimentacao) {
		this.movimentacoes.save(movimentacao);
		return "redirect:/movimentacoes";
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("redirect:/movimentacoes");

		this.movimentacoes.deleteById(id);

		return modelandview;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("/movimentacoes/editar");

		Optional<Movimentacao> movimentacao = this.movimentacoes.findById(id);
		modelandview.addObject("movimentacao", movimentacao);
		modelandview.addObject("conteiners", conteiners.findAll());

		return modelandview;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Movimentacao movimentacao) {
		ModelAndView modelandview = new ModelAndView("redirect:/movimentacoes");

		this.movimentacoes.save(movimentacao);

		return modelandview;
	}
}
