package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.factory.patient.ReportFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.patient.impl.ReportServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceImplTest {

    @Autowired
    private ReportServiceImpl reportService;


    @Test
    public void create() {

        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        assertNotNull(reportService.getAll());

    }

    @Test
    public void read() {

        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        assertNotNull(reportService.getAll());

        Report fromSet = reportService.read(report.getReportId());

        assertEquals(report, fromSet);


    }

    @Test
    public void update() {


        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        assertNotNull(reportService.getAll());

        Report update = ReportFactory.getReport(1, "fadass", null, null, null);
        update.setReportId(report.getReportId());
        reportService.update(update);

        Report updated = reportService.read(report.getReportId());

        assertEquals(update, updated);

    }

    @Test
    public void delete() {


        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        assertNotNull(reportService.getAll());

        reportService.delete(report.getReportId());

        Report report1 = reportService.read(report.getReportId());

        assertNull(report1);


    }
}