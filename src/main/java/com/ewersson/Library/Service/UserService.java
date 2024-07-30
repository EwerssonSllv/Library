package com.ewersson.Library.Service;

import com.ewersson.Library.Model.Book.Books;
import com.ewersson.Library.Model.User.User;
import com.ewersson.Library.Repository.BookRepository;
import com.ewersson.Library.Repository.UserRepository;
import com.ewersson.Library.Service.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found! Id:" + id + "Type: " + User.class.getName()));
    return userRepository.findById(id);
    }

    public void deleteUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found!"));
        userRepository.deleteById(id);
    }

    public User uptdateUser(Integer id, User updatedUser){
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found!"));
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
    return userRepository.save(user);
    }

    public User addBookToUserCollection(Integer userId, Integer bookId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found!"));

        // Check if book exists
        if (!bookRepository.existsById(bookId)) {
            throw new ObjectNotFoundException("Book Not Found!");
        }

        // Add the book ID to the user's collection
        user.getPersonalCollection().add(bookId);
        return userRepository.save(user);
    }

    public Set<Books> getUserPersonalCollection(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ObjectNotFoundException("User Not Found!"));

        // Fetch all books that are in the user's personal collection
        return user.getPersonalCollection().stream()
                .map(bookRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

}
