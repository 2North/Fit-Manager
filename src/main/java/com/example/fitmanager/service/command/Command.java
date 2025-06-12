package com.example.fitmanager.service.command;

public interface Command {
    void execute();
    void undo();
}