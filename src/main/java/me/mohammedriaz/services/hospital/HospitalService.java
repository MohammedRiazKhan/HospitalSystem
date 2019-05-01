package me.mohammedriaz.services.hospital;

import me.mohammedriaz.domain.hospital.Hospital;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface HospitalService extends Service<Hospital, Integer> {
    Set<Hospital> getAll();
}
