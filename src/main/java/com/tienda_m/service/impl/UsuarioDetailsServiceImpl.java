package com.tienda_m.service.impl;

import com.tienda_m.dao.UsuarioDao;
import com.tienda_m.domain.Rol;
import com.tienda_m.domain.Usuario;
import org.springframework.stereotype.Service;
import com.tienda_m.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl extends UsuarioDetailsService 
        implements 
        UserDetailsService {
    
    @Autowired 
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;

    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario==null){
            throw new UsernameNotFoundException(username);
            
        }
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        var roles=new ArrayList<GrantedAuthority>();
        for (Rol r: usuario.getRoles()){
            //se agregan los roles ya con permisos.. o roles reales
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        return 
                new 
        User(usuario.getUsername(),usuario.getPassword(),roles);
    } 
    
    // Aquí irían los métodos implementados de las interfaces UsuarioDetailsService y UserDetailsService
    
}
