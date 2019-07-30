package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Report;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportFactoryTest {

    @Test
    public void getReport() {

        Report report = ReportFactory.getReport(1, "Title", "Content", "IQR", null);
        Assert.assertNotNull(report);


    }
}