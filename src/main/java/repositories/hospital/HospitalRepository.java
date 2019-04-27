package repositories.hospital;

import domain.hospital.Hospital;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface HospitalRepository extends Repository<Hospital, Integer> {


    Set<Hospital> getAll();

}
