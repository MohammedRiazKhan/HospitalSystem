package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;

public class MedicalToolFactory {

    public static MedicalTool getMedicalTool(int toolId, String toolName, String toolCost) {
        return new MedicalTool.MedicalToolBuilder()
                .toolId(toolId)
                .toolName(toolName)
                .toolCost(toolCost)

                .build();
    }

}
