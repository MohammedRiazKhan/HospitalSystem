package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.service.hospital.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dept")
public class DepartmentController {



    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping
    public Department create(@RequestBody Department t){
        return departmentService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Department findById(@PathVariable String id){
        return departmentService.read(id);
    }

    @PutMapping("/update")
    public Department update(@RequestBody Department t){
        return departmentService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){

        departmentService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Department> getAll(){
        return departmentService.getAll();
    }


}
