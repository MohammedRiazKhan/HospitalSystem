package me.mohammedriaz.repositories.hospital;

import me.mohammedriaz.domain.hospital.Hospital;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface HospitalRepository extends Repository<Hospital, Integer> {


    Set<Hospital> getAll();

}
