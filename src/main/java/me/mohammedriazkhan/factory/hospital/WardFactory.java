package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;

public class WardFactory {

    public static Ward getWard(int wardId, String wardCode) {
        return new Ward.WardBuilder()
                .wardId(wardId)
                .wardCode(wardCode)
                .build();
    }



}
