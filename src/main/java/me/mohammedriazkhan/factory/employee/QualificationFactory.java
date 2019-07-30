package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Qualification;

public class QualificationFactory {

    public static Qualification getQualification(int qualificationId, String qualificationName, String instituteName, String duration) {
        return new Qualification.QualificationBuilder()
                .qualificationId(qualificationId)
                .qualificationName(qualificationName)
                .instituteName(instituteName)
                .duration(duration)
                .build();
    }

}
