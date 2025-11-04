package trabalhoandre.alunoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trabalhoandre.alunoapp.model.Aluno;
import trabalhoandre.alunoapp.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;

	public List<Aluno> findAll() {
		return repository.findAll(); 
	}

	public Optional<Aluno> findOne(Long id) {
		return repository.findById(id);
	}

	public Aluno save(Aluno post) {
		return repository.saveAndFlush(post);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
