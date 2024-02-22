package com.api.spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.spring.entity.Department;
import com.api.spring.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	public Department save(Department department) {
		return repository.save(department);
	}
	
	public void delete(Long id) {
		 repository.deleteById(id);
	}
	
	public Department update(Department department, Long id) {
	    Department departmentToUpdate = repository.findById(id)
	            .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + id));

	    // Verificar se o departamento foi encontrado
	    if (departmentToUpdate != null) {
	        // Atualizar os campos do departamento existente com os novos dados
	        departmentToUpdate.setNome(department.getNome());
	        // Adicione outras atualizações de campos, se necessário

	        // Salvar o departamento atualizado e retorná-lo
	        return repository.save(departmentToUpdate);
	    } else {
	        // Se o departamento não foi encontrado, lançar uma exceção
	        throw new NoSuchElementException("Department not found with id: " + id);
	    }
	}

	public List<Department> findAll(){
		List<Department> list = repository.findAll();
		return list;
	}
	
}
