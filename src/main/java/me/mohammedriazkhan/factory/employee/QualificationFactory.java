package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Qualification;
import me.mohammedriazkhan.helper.IDGenerator;

public class QualificationFactory {

    public static Qualification getQualification(String qualificationName, String instituteName, String duration) {
        return new Qualification.QualificationBuilder()
                .qualificationId(IDGenerator.generateId())
                .qualificationName(qualificationName)
                .instituteName(instituteName)
                .duration(duration)
                .build();
    }

}
