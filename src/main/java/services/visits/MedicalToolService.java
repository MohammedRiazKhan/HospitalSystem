package services.visits;

import domain.appoinments.Appointment;
import domain.visits.MedicalTool;
import services.Service;

import java.util.Set;

public interface MedicalToolService extends Service<MedicalTool, Integer> {

    Set<MedicalTool> getAll();

}
