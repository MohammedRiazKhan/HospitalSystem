package me.mohammedriazkhan.services.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface WardService extends Service<Ward, Integer> {

    Set<Ward> getAll();

}
