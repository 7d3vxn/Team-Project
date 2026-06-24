package org.example.geektext.controller;


import org.example.geektext.model.User;
import org.example.geektext.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.example.geektext.repository.CreditCardRepository;
import org.example.geektext.model.CreditCard;

@RestController
@RequestMapping("/users")

public class UserController {

    private final UserRepository userRepository;
    private final CreditCardRepository creditCardRepository;

   public UserController(UserRepository userRepository, CreditCardRepository creditCardRepository) {

       this.userRepository = userRepository;
       this.creditCardRepository = creditCardRepository;
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {

       return userRepository.findByUsername(username);
    }

    @PostMapping
    public User create(@RequestBody User user) {

       return userRepository.save(user);
    }

    @PostMapping("/{username}/credit-cards")
    public CreditCard createCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
       User user = userRepository.findByUsername(username);

       if (user == null) {
           return null;
       }

       creditCard.setUser(user);
       return creditCardRepository.save(creditCard);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User updatedUser) {

       User currentUser = userRepository.findByUsername(username);

       if(currentUser == null) {
           return null;

       }

       currentUser.setName(updatedUser.getName());
       currentUser.setPassword(updatedUser.getPassword());
       currentUser.setAddress(updatedUser.getAddress());

       return userRepository.save(currentUser);
        }
    }


