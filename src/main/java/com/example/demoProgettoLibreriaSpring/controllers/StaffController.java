package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Author;
import com.example.demoProgettoLibreriaSpring.entities.Staff;
import com.example.demoProgettoLibreriaSpring.repositories.StaffRepository;
import com.example.demoProgettoLibreriaSpring.services.AuthorServices;
import com.example.demoProgettoLibreriaSpring.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    public StaffServices staffServices;
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/all")
    public List<Staff> getStaffList(){
        return staffServices.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable long id) throws Exception {
        return staffServices.getStaffById(id);
    }

    @PostMapping("/save")
    public void saveStaff(@RequestBody Staff staff){
        staffServices.saveStaff(staff);
    }

    @DeleteMapping("/delete")
    public void deleteStaffById(@RequestParam long id){
        staffServices.deleteStaff(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable long id, @RequestBody Staff staffDetails) throws Exception {
        Staff updateStaff = staffServices.getStaffById(id);


        updateStaff.setName(staffDetails.getName());
        updateStaff.setSurname(staffDetails.getSurname());
        updateStaff.setGroupName(staffDetails.getGroupName());
        updateStaff.setRole(staffDetails.getRole());

        staffRepository.save(updateStaff);

        return ResponseEntity.ok(updateStaff);
    }

}
