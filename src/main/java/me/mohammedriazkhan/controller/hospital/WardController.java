package me.mohammedriazkhan.controller.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.service.Impl.WardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/department/ward")
public class WardController {

    private final WardServiceImpl wardService;

    @Autowired
    public WardController(WardServiceImpl wardService) {
        this.wardService = wardService;
    }


    @PostMapping
    public Ward create(@RequestBody Ward t){
        return wardService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Ward findById(@PathVariable int id){
        return wardService.read(id);
    }

    @PutMapping("/update")
    public Ward update(@RequestBody Ward t){
        return wardService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        wardService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Ward> getAll(){
        return wardService.getAll();
    }

}
