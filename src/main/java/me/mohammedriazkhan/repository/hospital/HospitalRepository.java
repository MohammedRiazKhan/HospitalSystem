package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface HospitalRepository extends Repository<Hospital, Integer> {


    Set<Hospital> getAll();

}
