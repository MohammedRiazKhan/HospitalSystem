package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.visit.VisitFactory;
import me.mohammedriazkhan.repository.appointment.AppointmentRepository;
import me.mohammedriazkhan.repository.appointment.impl.AppointmentRepositoryImpl;
import me.mohammedriazkhan.repository.employee.DoctorRepository;
import me.mohammedriazkhan.repository.employee.impl.DoctorRepositoryImpl;
import me.mohammedriazkhan.repository.patient.PatientRepository;
import me.mohammedriazkhan.repository.patient.impl.PatientRepositoryImpl;
import me.mohammedriazkhan.repository.visit.impl.VisitRepositoryImpl;
import me.mohammedriazkhan.repository.visit.VisitRepository;
import me.mohammedriazkhan.service.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VisitServiceImpl implements VisitService {

    private VisitServiceImpl service = null;
    private VisitRepository repository;
    //@Autowired
    private AppointmentRepository appointmentRepository;
    //@Autowired
    private DoctorRepository doctorRepository;
    //@Autowired
    private PatientRepository patientRepository;

    public VisitServiceImpl() {
        repository = VisitRepositoryImpl.getRepository();
        appointmentRepository = AppointmentRepositoryImpl.getAppointmentRepository();
        doctorRepository = DoctorRepositoryImpl.getDoctorRepository();
        patientRepository = PatientRepositoryImpl.getRepository();
    }

    public VisitServiceImpl getService(){

        if(service == null){
            return new VisitServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Visit> getAll() {
        return repository.getAll();
    }

    @Override
    public Visit create(Visit visit) {
        return repository.create(visit);
    }

    @Override
    public Visit read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Visit update(Visit visit) {
        return repository.update(visit);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }

    public Visit createVisit(String patientId, String doctorId, String appointmentId){

        Patient patient = patientRepository.read(patientId);
        Doctor doctor = doctorRepository.read(doctorId);
        Appointment appointment = appointmentRepository.read(appointmentId);

        System.out.println(patient);
        System.out.println(doctor);
        System.out.println(appointment);

        if(patient.getPatientId() != null && doctor.getEmployeeId() != null && appointment.getAppointmentId() != null){

            Visit visit = VisitFactory.getVisit("asd", patientId, doctorId, null, null, null);

            return create(visit);
        }

        return null;


    }

}
