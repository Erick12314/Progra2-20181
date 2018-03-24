package com.edu.journey.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.journey.model.Automovil;

@Controller
public class AutomovilController {
	
	@GetMapping("/calcular")
	public String formulario(Model model) {
		model.addAttribute("automovil", new Automovil());
		return "formAutomovil";
	}
	
	@PostMapping("/calcular")
	public String calculo(@ModelAttribute Automovil automovil) {
		
		String marca = automovil.getMarca();
		double consumo = 0.0;
		double recorrido = automovil.getRecorrido();
		
		if(marca.equals("marca1")) {
			
			consumo = recorrido / 40;
			
		}else if(marca.equals("marca2")) {
			
			consumo = recorrido / 35;
			
		}else if(marca.equals("marca3")) {
			
			consumo = recorrido / 45;
			
		}
		
		automovil.setConsumo(consumo);
		
		automovil.setMensaje("Sr. " + automovil.getNombre() + 
				" el vehículo de marca " + automovil.getMarca() + 
				" consume " + automovil.getConsumo() + 
				" galones por cada " + automovil.getRecorrido() + " km.");
		
		return "calculoAutomovil";
	}
	
}
