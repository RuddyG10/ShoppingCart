package com.example.crudcarritocompra.services;

import com.example.crudcarritocompra.Repository.UserRepository;
import com.example.crudcarritocompra.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //Parameters
    @Autowired
    private UserRepository userRepository;

    //Helper
    //Find user by id
    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    //Main Methods
    //Create User
    public User saveUser(User user){
        return userRepository.save(user);
    }

    //List Users
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    //Delete User
    public void  deleteUser(User user){
        userRepository.delete(user);
    }
    //Last Code
//    private List<User> listaUsuarios = new ArrayList<User>();
//
//    //Helper Methods
//
//    //Find user
//    public User findUserByUserName(String userName){
//        User auxUser = null;
//        for (User user:
//             listaUsuarios) {
//           if (user.getUserName() == userName){
//               auxUser = user;
//               return auxUser;
//           }
//        }
//        return auxUser;
//    }
//
//    //Main Methods
//
//    //create user
//    public User createUser(String userName, String name){
//        //TODO revisa que el userName no este taken.
//
//        User newUser = new User(userName,name);
//        listaUsuarios.add(newUser);
//        return newUser;
//    }
//    //visualize users
//    public List<User> verUsuarios(){
//        return listaUsuarios;
//    }
//    //Update user
//    public User updateUser(String userName, String newUsername){
//
//        //TODO mejorar este metodo.
//        User auxUser = findUserByUserName(userName);
//        if (auxUser != null){
//            User verify = findUserByUserName(newUsername);
//            if (verify == null){
//                //verifica que el nuevo usuario no este repetido
//                auxUser.setUserName(newUsername);
//            }
//            else{
//                //si esta repetido hacer esto.
//                auxUser = null;
//            }
//        }
//        return auxUser;
//    }
//    //delete user
//    public boolean deleteUser(String userName){
//        User auxUser = findUserByUserName(userName);
//        boolean deleted = false;
//        if (auxUser != null){
//            listaUsuarios.remove(auxUser);
//            deleted = true;
//        }
//        return deleted;
//    }
}
