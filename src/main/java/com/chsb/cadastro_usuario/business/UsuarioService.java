package com.chsb.cadastro_usuario.business;

import com.chsb.cadastro_usuario.infrastructure.entity.Usuario;
import com.chsb.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email Nao Encontrado"));
    }

    public void deletarUsuarioEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void AtualizarUsuario (Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("ID Nao Encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.save(usuarioAtualizado);
    }


}
