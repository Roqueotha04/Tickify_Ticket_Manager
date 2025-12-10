package com.tickify.ticket_manager.controllers;

import com.tickify.ticket_manager.entities.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @GetMapping()
    public ResponseEntity<?> getAllEvents(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByID(@PathVariable Long id){
        return null;
    }

    @PostMapping()
    public ResponseEntity<?> saveEvent (@RequestBody Event event){
        return null;
    }

}
