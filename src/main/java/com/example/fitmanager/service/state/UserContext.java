package com.example.fitmanager.service.state;

import com.example.fitmanager.model.User;

public class UserContext {
    private ActivityState state;
    private User user;

    public UserContext(User user) {
        this.user = user;
        this.state = new LowActivityState(); // Начальное состояние
    }

    public void setState(ActivityState state) {
        this.state = state;
    }

    public double getActivityCoefficient() {
        return state.getActivityCoefficient();
    }

    public void changeActivityLevel() {
        state.changeState(this);
    }

    public User getUser() {
        return user;
    }
}