package com.example.fitmanager.service.state;

public interface ActivityState {
    double getActivityCoefficient();
    void changeState(UserContext context);
}