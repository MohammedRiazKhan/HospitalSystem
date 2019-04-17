package factories.hospital;

import domain.hospital.Department;
import domain.hospital.Hospital;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HospitalFactoryTest {

    @Test
    public void getHospital() {

        List<Department> departmentList = new ArrayList<>();

        //Hospital
        Hospital hosp = HospitalFactory.getHospital(departmentList, 1, "MyHosp");

        Assert.assertNotNull(hosp.getHospitalId());

    }
}