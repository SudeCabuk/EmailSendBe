package com.sude.userproject.Service;

import com.sude.userproject.Entity.User;
import com.sude.userproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private MailService mailService;

    @Autowired
    public UserService(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


    public String contactAdd(User user) {
        userRepository.save(user);
        String subject = "Yeni Mesaj Geldi!";
        String body = "Ad:" + user.getName() +
                "\nSoyad: " + user.getSurname() +
                "\nE-posta: " + user.getEmail() +
                "\nTelefon: " + user.getPhonenumber() +
                "\nMesaj: " + user.getMessage();
        mailService.sendEmail("cabuksudeeda@gmail.com", subject, body);
        return "Eklendi";
    }
    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;

    }
}
