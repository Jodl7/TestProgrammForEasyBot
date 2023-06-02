package com.vk.jodl7.TestProgrammForEasyBot.services;

import com.vk.jodl7.TestProgrammForEasyBot.models.PC;

import java.util.List;

public interface PCServices {
    public List<PC> showById();
    public PC showAll(int id);
    public void save(PC PC);
    public void update(int id, PC pc);
}
