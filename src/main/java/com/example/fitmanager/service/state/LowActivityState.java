package com.example.fitmanager.service.state;

public class LowActivityState implements ActivityState {
    @Override
    public double getActivityCoefficient() {
        return 1.2; // Минимальная активность
    }

    @Override
    public void changeState(UserContext context) {
        context.setState(new HighActivityState());
    }
}