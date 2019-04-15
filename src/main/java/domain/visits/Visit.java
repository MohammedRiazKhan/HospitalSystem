package domain.visits;

import domain.patients.Patient;
import domain.employee.Doctor;
import domain.employee.Nurse;

import java.util.List;

public class Visit {

    private int visitId;
    private String visitDate;
    private Patient patient;
    private Doctor doctor;
    private Nurse nurse;
    private List<Medication> medication;
    private List<MedicalTool> tools;


}
