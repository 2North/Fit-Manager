package com.example.fitmanager.service.state;

public class HighActivityState implements ActivityState {
    @Override
    public double getActivityCoefficient() {
        return 1.9; // Высокая активность
    }

    @Override
    public void changeState(UserContext context) {
        context.setState(new LowActivityState()); // Циклический переход
    }
}