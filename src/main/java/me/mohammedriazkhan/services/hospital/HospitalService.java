package me.mohammedriazkhan.services.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface HospitalService extends Service<Hospital, Integer> {
    Set<Hospital> getAll();
}
