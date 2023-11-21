package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

	@Autowired
	private EmployeeRepository repo;

	public void addEmp(Employee e) {
		repo.save(e);
	}

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}

	public Employee getEMpById(int id) {
		Optional<Employee> e = repo.findById(id);
		return e.orElse(null);
	}

	public void deleteEMp(int id) {
		repo.deleteById(id);
	}

	public Page<Employee> getEMpByPaginate(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);
		return repo.findAll(p);
	}
}