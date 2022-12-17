package com.edujguerra.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edujguerra.spring.model.Conteiner;
import com.edujguerra.spring.repository.ConteinerRepo;

@Controller
public class ConteinerController {
	@Autowired
	private ConteinerRepo conteiners;
		
	@GetMapping("/")
	public ModelAndView index() {
		return listar();
	}
	
	@GetMapping("/conteiners")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/conteiners/Lista");
		modelAndView.addObject("conteiners", conteiners.findAll());
		modelAndView.addObject(new Conteiner());

		return modelAndView;
	}

	@PostMapping("/conteiners")
	public String salvar(Conteiner conteiner) {
		this.conteiners.save(conteiner);
		return "redirect:/conteiners";
	}

	@GetMapping("/conteiners/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("redirect:/conteiners");

		this.conteiners.deleteById(id);

		return modelandview;
	}

	@GetMapping("/conteiners/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("/conteiners/Editar");

		Optional<Conteiner> conteiner = this.conteiners.findById(id);
		modelandview.addObject("conteiner", conteiner);

		return modelandview;
	}

	@PostMapping("/conteiners/{id}/editar")
	public ModelAndView editar(Conteiner conteiner) {
		ModelAndView modelandview = new ModelAndView("redirect:/conteiners");

		this.conteiners.save(conteiner);

		return modelandview;
	}
}
