package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.visit.VisitFactory;
import me.mohammedriazkhan.repository.appointment.AppointmentRepository;
import me.mohammedriazkhan.repository.appointment.hibernate.AppointmentRepositoryHibernate;
import me.mohammedriazkhan.repository.appointment.impl.AppointmentRepositoryImpl;
import me.mohammedriazkhan.repository.employee.DoctorRepository;
import me.mohammedriazkhan.repository.employee.hibernate.DoctorRepositoryHibernate;
import me.mohammedriazkhan.repository.employee.impl.DoctorRepositoryImpl;
import me.mohammedriazkhan.repository.patient.PatientRepository;
import me.mohammedriazkhan.repository.patient.hibernate.PatientRepositoryHibernate;
import me.mohammedriazkhan.repository.patient.impl.PatientRepositoryImpl;
import me.mohammedriazkhan.repository.visit.hibernate.VisitRepositoryHibernate;
import me.mohammedriazkhan.repository.visit.impl.VisitRepositoryImpl;
import me.mohammedriazkhan.repository.visit.VisitRepository;
import me.mohammedriazkhan.service.patient.PatientService;
import me.mohammedriazkhan.service.patient.impl.InPatientServiceImpl;
import me.mohammedriazkhan.service.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class VisitServiceImpl implements VisitService {

    private VisitServiceImpl service = null;
    @Autowired
    private VisitRepositoryHibernate repository;
    @Autowired
    private AppointmentRepositoryHibernate appointmentRepository;
    @Autowired
    private DoctorRepositoryHibernate doctorRepository;
    @Autowired
    private PatientRepositoryHibernate patientRepository;

    public VisitServiceImpl() {

    }

    public VisitServiceImpl getService(){

        if(service == null){
            return new VisitServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Visit> getAll() {
        List<Visit> list = (List<Visit>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Visit create(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public Visit read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Visit update(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }

    public Visit createVisit(String patientId, String doctorId, String appointmentId){

        Patient patient = patientRepository.findById(patientId).orElse(null);
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);

        System.out.println(patient);
        System.out.println(doctor);
        System.out.println(appointment);

        if(patient.getPatientId() != null && doctor.getEmployeeId() != null && appointment.getAppointmentId() != null){

            Visit visit = VisitFactory.getVisit(new Date().toString(), patient.getPatientId(), doctor.getEmployeeId());

            return create(visit);
        }

        return null;


    }

}
