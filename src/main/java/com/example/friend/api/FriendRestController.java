package com.example.friend.api;

import com.example.friend.entity.FriendEntity;
import com.example.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendRestController {

    @Autowired
    FriendService service;


    @PostMapping(value = "/friend/add")
    public ResponseEntity<FriendEntity> addFriend(@RequestBody FriendEntity friend) {
        FriendEntity newEntity = service.addFriendContact(friend);
        if (newEntity != null)
            return new ResponseEntity<>(newEntity, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/friend/{phoneNumber}")
    public List<Object[]> getFriendsContacts(@PathVariable Long phoneNumber) {

        return service.readFriendsContacts(phoneNumber);
    }
}
