package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface WardService extends Service<Ward, Integer> {

    Set<Ward> getAll();

}
