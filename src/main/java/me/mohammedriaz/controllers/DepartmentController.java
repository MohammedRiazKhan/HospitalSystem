package me.mohammedriaz.controllers;

import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.services.Impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    private DepartmentServiceImpl departmentService;

    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department create(@RequestBody Department t){
        return departmentService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Department findById(@PathVariable int id){
        return departmentService.read(id);
    }

    @PutMapping("/update")
    public Department update(@RequestBody Department t){
        return departmentService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){

        departmentService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Department> getAll(){
        return departmentService.getAll();
    }


}
