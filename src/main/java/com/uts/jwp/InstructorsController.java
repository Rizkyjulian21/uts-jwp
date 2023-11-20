package com.uts.jwp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uts.jwp.Domain.Teacher;

@RestController
public class InstructorsController {
    public static Map<String, Teacher> instructorsMap = new HashMap<>();

    @GetMapping("/teachers")
    public List<Teacher> getInstructors() {
        return instructorsMap.values().stream().collect(Collectors.toList());
    }

    @PostMapping("/teachers")
    public ResponseEntity<String> addInstructors(@RequestBody Teacher instructors) {
        instructorsMap.put(instructors.getnip(), instructors);
        Teacher savedInstructors = instructorsMap.get(instructors.getnip());
        return new ResponseEntity<>("Instructors with nip: " + savedInstructors.getnip() +
                "has been created", HttpStatus.OK);
    }

     @GetMapping(value = "/teachers/{nip}")
    public ResponseEntity<Teacher> findInstructors(@PathVariable("nip") String nip) {
        final Teacher instructors = instructorsMap.get(nip);
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @PutMapping(value = "/teachers/{nip}")
    public ResponseEntity<String> updateInstructors(@PathVariable("nip") String nip,
            @RequestBody Teacher instructors) {
        final Teacher instructorsToBeUpdated = instructorsMap.get(instructors.getnip());
        instructorsToBeUpdated.setfullName(instructors.getfullName());
        instructorsToBeUpdated.setemail(instructors.getemail());
        instructorsToBeUpdated.setnophone(instructors.getnumberphone());

        instructorsMap.put(instructors.getnip(), instructorsToBeUpdated);
        return new ResponseEntity<>("Instructors with nip: " + instructorsToBeUpdated.getnip() +
                "has been updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/teachers/{nip}")
    public ResponseEntity<Void> deleteInstructors(@PathVariable("nip") String nip) {
        instructorsMap.remove(nip);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
