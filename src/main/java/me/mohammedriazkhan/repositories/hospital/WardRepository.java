package me.mohammedriazkhan.repositories.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface WardRepository extends Repository<Ward, Integer> {


    Set<Ward> getAll();
}
