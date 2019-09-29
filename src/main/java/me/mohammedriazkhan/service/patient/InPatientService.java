package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface InPatientService extends Service<InPatient, String> {

    Set<InPatient> getAll();

}
