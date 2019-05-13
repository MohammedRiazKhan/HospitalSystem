package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface HospitalService extends Service<Hospital, Integer> {
    Set<Hospital> getAll();
}
