package br.org.generation.indicajobs.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.indicajobs.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
<<<<<<< HEAD
	
=======
	public List<Usuario> findByIdUsuario (long IdUsuario);
>>>>>>> 87dbe2c933a4f47cbf5c880724371fb4bc9f5f7b
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
}