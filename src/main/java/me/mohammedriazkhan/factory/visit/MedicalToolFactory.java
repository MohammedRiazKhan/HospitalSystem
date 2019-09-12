package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.helper.IDGenerator;

public class MedicalToolFactory {

    public static MedicalTool getMedicalTool(String toolName, String toolCost) {
        return new MedicalTool.MedicalToolBuilder()
                .toolId(IDGenerator.generateId())
                .toolName(toolName)
                .toolCost(toolCost)

                .build();
    }

}
