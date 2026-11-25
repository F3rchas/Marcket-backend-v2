package com.merida.tecnm.Marcket_backend_v2.domain.service;

import com.merida.tecnm.Marcket_backend_v2.persistence.crud.ClienteCrudRepository;
import com.merida.tecnm.Marcket_backend_v2.persistence.entity.Cliente;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MarketUserDetailsService implements UserDetailsService {

    private final ClienteCrudRepository clienteCrudRepository;

    public MarketUserDetailsService(ClienteCrudRepository clienteCrudRepository) {
        this.clienteCrudRepository = clienteCrudRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> clienteOpt = clienteCrudRepository.findByCorreoElectronico(username);
        if (clienteOpt.isEmpty()) {
            clienteOpt = clienteCrudRepository.findById(username);
        }

        Cliente cliente = clienteOpt.orElseThrow(
                () -> new UsernameNotFoundException("Cliente no encontrado: " + username)
        );

        String password = cliente.getPassword();
        if (password == null || password.isBlank()) {
            throw new UsernameNotFoundException("El cliente no tiene una contraseña asignada.");
        }

        String principal = (cliente.getCorreoElectronico() != null && !cliente.getCorreoElectronico().isBlank())
                ? cliente.getCorreoElectronico()
                : cliente.getId();

        return new User(principal, password, Collections.emptyList());
    }
}
