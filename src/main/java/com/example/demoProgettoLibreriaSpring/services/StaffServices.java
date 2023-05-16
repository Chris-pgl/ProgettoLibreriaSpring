package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Author;
import com.example.demoProgettoLibreriaSpring.entities.Staff;
import com.example.demoProgettoLibreriaSpring.repositories.StaffRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffServices {

    @Autowired
    StaffRepository staffRepository;

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public Staff getStaffById(long id) throws Exception {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()){
            return optionalStaff.get();
        }else throw new Exception("I did not find the ID");
    }

    public void saveStaff(Staff staff){
        staffRepository.save(staff);
    }

    public void deleteStaff(long id){
        staffRepository.deleteById(id);
    }

    public Staff findByName(String name) throws Exception{
        Optional<Staff> optionalStaff = staffRepository.getStaffByName(name);
        if (optionalStaff.isPresent()){
            return optionalStaff.get();
        }else throw new Exception("Staff with name" + name + " does not exist");
    }

}
