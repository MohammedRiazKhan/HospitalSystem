package services.hospital;

import domain.appoinments.Appointment;
import domain.hospital.Hospital;
import services.Service;

import java.util.Set;

public interface HospitalService extends Service<Hospital, Integer> {
    Set<Hospital> getAll();
}
