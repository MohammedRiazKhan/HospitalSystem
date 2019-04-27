package services.visits;

import domain.appoinments.Appointment;
import domain.visits.Visit;
import services.Service;

import java.util.Set;

public interface VisitService extends Service<Visit, Integer> {

    Set<Visit> getAll();

}
