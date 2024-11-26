package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.model.Usuario;
import application.repository.UsuarioRepository;

@Service
public class AppUserDataService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeDeUsuario(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não localizado");
        }

        UserDetails userDetails = 
            org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getNomeDeUsuario())
                .password(usuario.getSenha())
                .roles("USER")
                .build();

        return userDetails;
    }
        
}