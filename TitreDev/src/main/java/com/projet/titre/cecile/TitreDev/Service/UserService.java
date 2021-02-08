package com.projet.titre.cecile.TitreDev.Service;

import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Repository.UserRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder PasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserMiam user = repo.findByLogin(s);

        System.out.println();

        if(user == null){
            System.out.println("Ca ne voit rien");
            throw new UsernameNotFoundException("Ce login n'existe pas" + s);
        } else{
            System.out.println("Connect OK");
            return new User(user.getLogin(), user.getMdp(), new ArrayList<>());

        }

    }

    public UserMiam saveUser(UserMiam user){
        UserMiam tempUser = new UserMiam();
        tempUser.setNom(user.getNom());
        tempUser.setPrenom(user.getPrenom());
        tempUser.setLogin(user.getLogin());
        tempUser.setMdp(PasswordEncoder.encode(user.getMdp()));
        return repo.save(tempUser);

    }

    public String getLoggedUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    public UserMiam getUserInfos(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return null;
        } else{
            String currentPrincipalName = authentication.getName();
            return repo.findByLogin(currentPrincipalName);
        }

    }

    @Transactional
    public void updateUser(String newPass){
        UserMiam temp = getUserInfos();
        temp.setMdp(PasswordEncoder.encode(newPass));
        repo.updateUserPass(temp.getMdp(), temp.getId());
    }
}
