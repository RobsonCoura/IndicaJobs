package br.org.generation.indicajobs.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.generation.indicajobs.Repository.UsuarioRepository;
import br.org.generation.indicajobs.model.Usuario;
import br.org.generation.indicajobs.model.UsuarioLogin;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			return Optional.empty();

		usuario.setSenha(criptografarSenha(usuario.getSenha()));

		return Optional.of(usuarioRepository.save(usuario));

	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {

		if (usuarioRepository.findById(usuario.getIdUsuario()).isPresent()) {

			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());

			if (buscaUsuario.isPresent()) {
				if (buscaUsuario.get().getIdUsuario() != usuario.getIdUsuario())
					return Optional.empty();
			}

			usuario.setSenha(criptografarSenha(usuario.getSenha()));

			return Optional.of(usuarioRepository.save(usuario));
		}

		return Optional.empty();
	}

	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {

		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());

		if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

				String token = gerarBasicToken(usuarioLogin.get().getEmail(), usuarioLogin.get().getSenha());
<<<<<<< HEAD

				usuarioLogin.get().setIdUsuario(usuario.get().getIdUsuario());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setToken(token);
=======
                usuarioLogin.get().setIdUsuario(usuario.get().getIdUsuario());
                usuarioLogin.get().setNome(usuario.get().getNome());
                usuarioLogin.get().setSenha(usuario.get().getSenha());
                usuarioLogin.get().setToken(token);
>>>>>>> 87dbe2c933a4f47cbf5c880724371fb4bc9f5f7b

				return usuarioLogin;

			}
		}

		return Optional.empty();

	}

	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
	}
<<<<<<< HEAD

	private String gerarBasicToken(String email, String password) {
		String tokenBase = email + ":" + password;
=======
	
	private String gerarBasicToken(String email, String senha) {
		
		String tokenBase = email + ":" + senha;
>>>>>>> 87dbe2c933a4f47cbf5c880724371fb4bc9f5f7b
		byte[] tokenBase64 = Base64.encodeBase64(tokenBase.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
}
