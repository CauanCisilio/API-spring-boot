package com.api.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.entity.Department;
import com.api.spring.service.DepartmentService;

@RestController
@RequestMapping("/empresa")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping("/departamentos")
	public ResponseEntity <List<Department>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PutMapping("/{id}")
	@ResponseBody
    public ResponseEntity<Department> atualizarCliente(@RequestBody Department department, @PathVariable Long id){
        return ResponseEntity.ok().body(service.update(department, id));
    }
	
	@PostMapping
	public ResponseEntity<Department> form (@RequestBody Department department) {
	        return ResponseEntity.ok().body(service.save(department));
	}
	
	@DeleteMapping("/departamentos/{id}")
    public ResponseEntity<Department> delete (@PathVariable Long id) {
        service.delete(id);;
        return ResponseEntity.noContent().build();
    }
}
