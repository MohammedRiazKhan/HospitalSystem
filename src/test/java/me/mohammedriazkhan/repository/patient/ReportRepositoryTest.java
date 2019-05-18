package me.mohammedriazkhan.repository.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.factory.patient.ReportFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.patient.impl.ReportRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRepositoryTest {


    @Autowired
    ReportRepositoryImpl reportitory;


    @Test
    public void create() {

        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportitory.create(report);
        assertNotNull(reportitory.getAll());

    }

    @Test
    public void read() {

        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportitory.create(report);
        assertNotNull(reportitory.getAll());

        Report fromSet = reportitory.read(report.getReportId());

        assertEquals(report, fromSet);


    }

    @Test
    public void update() {


        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportitory.create(report);
        assertNotNull(reportitory.getAll());

        Report update = ReportFactory.getReport(1, "fadass", null, null, null);
        update.setReportId(report.getReportId());
        reportitory.update(update);

        Report updated = reportitory.read(report.getReportId());

        assertEquals(update, updated);

    }

    @Test
    public void delete() {


        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportitory.create(report);
        assertNotNull(reportitory.getAll());

        reportitory.delete(report.getReportId());

        Report report1 = reportitory.read(report.getReportId());

        assertNull(report1);


    }
}