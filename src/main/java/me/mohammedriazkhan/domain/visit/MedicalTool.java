package me.mohammedriazkhan.domain.visit;

import java.util.Objects;

public class MedicalTool {

    private String toolId;
    private String toolName;
    private String toolCost;

    public MedicalTool(){}

    private MedicalTool(MedicalToolBuilder builder){
        this.toolId = builder.toolId;
        this.toolName = builder.toolName;
        this.toolCost = builder.toolCost;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolCost(){
        return toolCost;
    }

    public void setToolCost(String toolCost) {
        this.toolCost = toolCost;
    }

    public static class MedicalToolBuilder{
        private String toolId;
        private String toolName;
        private String toolCost;

        public MedicalToolBuilder(){}

        public MedicalToolBuilder toolId(String toolId){
            this.toolId = toolId;
            return this;
        }

        public MedicalToolBuilder toolName(String toolName){
            this.toolName = toolName;
            return this;
        }

        public MedicalToolBuilder toolCost(String toolCost){
            this.toolCost = toolCost;
            return this;
        }

        public MedicalToolBuilder copy(MedicalTool medicalTool){
            this.toolId(medicalTool.getToolId());
            this.toolName(medicalTool.getToolName());
            this.toolCost(medicalTool.getToolCost());
            return this;
        }


        public MedicalTool build(){
            return new MedicalTool(this);
        }

        @Override
        public String toString() {
            return "MedicalToolBuilder{" +
                    "toolId=" + toolId +
                    ", toolName='" + toolName + '\'' +
                    ", toolCost='" + toolCost + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MedicalToolBuilder that = (MedicalToolBuilder) o;
            return Objects.equals(toolId, that.toolId) &&
                    Objects.equals(toolName, that.toolName) &&
                    Objects.equals(toolCost, that.toolCost);
        }

        @Override
        public int hashCode() {
            return Objects.hash(toolId, toolName, toolCost);
        }
    }

}
