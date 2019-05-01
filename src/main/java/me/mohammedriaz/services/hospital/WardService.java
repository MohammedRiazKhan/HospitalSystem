package me.mohammedriaz.services.hospital;

import me.mohammedriaz.domain.hospital.Ward;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface WardService extends Service<Ward, Integer> {

    Set<Ward> getAll();

}
