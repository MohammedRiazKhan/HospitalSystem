package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Ward;
import me.mohammedriaz.utility.IDGenerator;

public class WardFactory {

    public static Ward getWard(int wardId, String wardCode) {
        return (Ward) new Ward.WardBuilder()
                .wardId(IDGenerator.genId())
                .wardCode(wardCode)
                .build();
    }



}
