package me.mohammedriaz.repositories.hospital;

import me.mohammedriaz.domain.hospital.Ward;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface WardRepository extends Repository<Ward, Integer> {


    Set<Ward> getAll();
}
