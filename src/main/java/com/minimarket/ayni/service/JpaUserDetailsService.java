package com.minimarket.ayni.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class JpaUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("admin")){
            // si no es igual negamos
            throw new UsernameNotFoundException
                    (String.format
                            ("Username %s no existe en el sistema!!!",
                                    username));
        }
        //Si es igual lo authenticamos
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));


        // debemos retornar el user security, userdetails
        // el primer true habilitado, no expira, credenciales, que no esta bloqueado, roles
        return new User(
                username,
                "12345",
                true,
                true,
                true,
                true,
                authorities);
    }
}