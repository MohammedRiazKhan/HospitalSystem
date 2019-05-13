package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.service.Impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private final ReportServiceImpl reportService;

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
