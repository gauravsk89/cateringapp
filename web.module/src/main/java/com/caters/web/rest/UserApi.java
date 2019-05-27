package com.caters.web.rest;

import com.caters.web.domain.User;
import com.caters.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserApi {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Hello Gaurav !");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        if(!user.isPresent()){
            log.error("User not found for given id: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody User user){
        user.setId((long)Math.random());
        return ResponseEntity.ok(user.getId());
    }


}
