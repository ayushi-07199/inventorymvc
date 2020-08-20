package com.dxctraining.inventorymgt.item.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class CompController {
	@Autowired
	private IItemService service;
	@Autowired
	private ISupplierService service2;
	@PostConstruct
	public void init() {
		Supplier supplier1=new Supplier("Ankita","qwerty");
		service2.add(supplier1);
		Computer computer1=new Computer("Dell",supplier1,400);
		service.add(computer1);
	}
	
	@GetMapping("/listallcmp")
    public ModelAndView all(){
		System.out.println("inside one");
    	 List<Computer>computer=service.allComputer();
        ModelAndView modelAndView=new ModelAndView("clist","computer",computer);
        return modelAndView;
    }
}
