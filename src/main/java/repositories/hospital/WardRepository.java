package repositories.hospital;

import domain.hospital.Ward;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface WardRepository extends Repository<Ward, Integer> {


    Set<Ward> getAll();
}
