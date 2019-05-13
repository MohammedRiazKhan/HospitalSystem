package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.factory.patient.ReportFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.Impl.ReportServiceImpl;

public class ReportServiceImplTest {

    ReportServiceImpl reportService;

    @Before
    public void setUp() throws Exception {

        reportService = new ReportServiceImpl();

    }

    @Test
    public void create() {

        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        Assert.assertNotNull(reportService.getAll());

    }

    @Test
    public void read() {

        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        Assert.assertNotNull(reportService.getAll());

        Report fromSet = reportService.read(report.getReportId());

        Assert.assertEquals(report, fromSet);


    }

    @Test
    public void update() {


        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        Assert.assertNotNull(reportService.getAll());

        Report update = ReportFactory.getReport(1, "fadass", null, null, null);
        update.setReportId(report.getReportId());
        reportService.update(update);

        Report updated = reportService.read(report.getReportId());

        Assert.assertEquals(update, updated);

    }

    @Test
    public void delete() {


        Report report = ReportFactory.getReport(1, "fas", null, null, null);
        reportService.create(report);
        Assert.assertNotNull(reportService.getAll());

        reportService.delete(report.getReportId());

        Report report1 = reportService.read(report.getReportId());

        Assert.assertNull(report1);


    }
}