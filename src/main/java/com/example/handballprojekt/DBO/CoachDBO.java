package com.example.handballprojekt.DBO;

public class CoachDBO {
    private int CoachID;
    private String CoachName;

    public CoachDBO(int CoachID, String CoachName) {
        this.CoachID = CoachID;
        this.CoachName = CoachName;
    }
    public int getCoachID() {
        return CoachID;
    }

    public String getCoachName() {
        return CoachName;
    }

    public void setCoachID(int coachID) {
        CoachID = coachID;
    }

    public void setCoachName(String coachName) {
        CoachName = coachName;
    }
}
