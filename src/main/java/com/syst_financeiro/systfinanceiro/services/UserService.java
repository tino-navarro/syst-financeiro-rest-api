package com.syst_financeiro.systfinanceiro.services;

import com.syst_financeiro.systfinanceiro.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.syst_financeiro.systfinanceiro.repositories.UserRepository;

public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        super();
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

    public UserEntity save(UserEntity user) throws Exception {

        // Validação do preenchimento campo nome de usuário
        if (user == null)
            throw new Exception("Objeto não pode ser nulo!");

        if (user.getName() == null || user.getName().isEmpty())
            throw new Exception("Nome inválido!");
        user.setName(user.getName().trim());

        // VALIDAÇÃO DO PREENCHIMENTO CAMPO EMAIL
        if (user.getEmail() == null || user.getEmail().isEmpty())
            throw new Exception("Email inválido!");
        user.setEmail(user.getEmail().trim().toLowerCase());

        // VALIDAÇÃO DE SENHA (CARACTERES MAIÚSCULOS, MINÚSCULOS E NUMÉRICOS

        if (user.getPassword() == null
            || user.getPassword().isEmpty()
            || user.getPassword().length() < 8)
            throw new Exception("Senha inválida!");

        if (user.getType() == null)
            throw new Exception("Tipo de usuário inválido!");

        if (repository.existsByEmail(user.getEmail()))
            throw new Exception("Já existe usuário cadastrado com esse email!");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        return user;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        var user = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
        return user;

    }

}
