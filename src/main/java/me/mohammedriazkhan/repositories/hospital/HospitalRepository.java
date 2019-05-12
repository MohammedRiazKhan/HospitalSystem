package me.mohammedriazkhan.repositories.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface HospitalRepository extends Repository<Hospital, Integer> {


    Set<Hospital> getAll();

}
