package me.mohammedriaz.controllers;

import me.mohammedriaz.domain.patients.Report;
import me.mohammedriaz.services.Impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportServiceImpl reportService;

    @Autowired
    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }


    @PostMapping
    public Report create(@RequestBody Report t){
        return reportService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Report findById(@PathVariable int id){
        return reportService.read(id);
    }

    @PutMapping("/update")
    public Report update(@RequestBody Report t){
        return reportService.update(t);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        reportService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Report> getAll(){
        return reportService.getAll();
    }

}
