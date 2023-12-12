package com.example.demosidequests;

public class Goal {

    private String goalTitle,amount, unitOfMeasure, frequency, completionDate;
    // Attribute class item
    private Attributes selectedAttribute;

    Goal(String goalTitle, String amount, String unitOfMeasure, String frequency, String completionDate, Attributes selectedAttribute){
        this.completionDate = completionDate;
        this.goalTitle = goalTitle;
        this.unitOfMeasure = unitOfMeasure;
        this.frequency = frequency;
        this.amount = amount;
        this.selectedAttribute = selectedAttribute;
    }

    public String getGoalTitle() { return goalTitle; }
    public String getCompletionDate() { return completionDate; }
    public String getFrequency() { return frequency; }
    public String getUnitOfMeasure() { return unitOfMeasure; }
    public String getAmount() { return amount; }
    public Attributes getSelectedAttribute() { return selectedAttribute; }


//    public boolean isTimedOut() {
//
//
//    }

    @Override
    public String toString() {
        return "I want to " + goalTitle + ", " + unitOfMeasure + " " + amount + " a " + frequency + " by " + completionDate
                + ". \n" + "Level up: " + selectedAttribute.toString() + "\t";
    }
}
