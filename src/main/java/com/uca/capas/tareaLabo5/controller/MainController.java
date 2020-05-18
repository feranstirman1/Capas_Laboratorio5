package com.uca.capas.tareaLabo5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo5.dao.EstudianteDAO;
import com.uca.capas.tareaLabo5.domain.Estudiante;

@Controller
public class MainController {

	@Autowired
	EstudianteDAO estudianteDAO;

	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/insertar")
	public ModelAndView insertar(@Valid @ModelAttribute Estudiante estudiante,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
			return mav;
		}else {
			estudianteDAO.insert(estudiante);
			mav.addObject("estudiante",new Estudiante());
			mav.setViewName("index");
			return mav;
		}
	}

}
