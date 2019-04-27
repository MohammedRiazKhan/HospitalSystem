package services.hospital;

import domain.appoinments.Appointment;
import domain.hospital.Ward;
import services.Service;

import java.util.Set;

public interface WardService extends Service<Ward, Integer> {

    Set<Ward> getAll();

}
