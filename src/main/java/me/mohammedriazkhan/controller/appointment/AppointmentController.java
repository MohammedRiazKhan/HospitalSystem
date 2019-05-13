package me.mohammedriazkhan.controller.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.service.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/new")
    public Appointment create(@RequestBody Appointment appointment){

        return appointmentService.create(appointment);
    }

    @GetMapping(path = "/find/{id}")
    public Appointment findById(@PathVariable int id){

        Appointment account = appointmentService.read(id);
        return account;
    }

    @PutMapping("/update")
    public void update(@RequestBody Appointment account){

        appointmentService.update(account);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        appointmentService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Appointment> getAll(){
        return appointmentService.getAll();
    }


}
