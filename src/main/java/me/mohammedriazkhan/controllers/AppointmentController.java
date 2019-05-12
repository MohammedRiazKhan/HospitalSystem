package me.mohammedriazkhan.controllers;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.services.Impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentServiceImpl appointmentService;

    @Autowired
    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }


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
