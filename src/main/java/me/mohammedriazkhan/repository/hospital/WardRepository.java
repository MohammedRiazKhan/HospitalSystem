package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface WardRepository extends Repository<Ward, String> {


    Set<Ward> getAll();
}
