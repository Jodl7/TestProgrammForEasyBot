package com.vk.jodl7.TestProgrammForEasyBot.services;

import com.vk.jodl7.TestProgrammForEasyBot.models.Monitors;

import java.util.List;

public interface MonitorsServices {
    public List<Monitors> showById();
    public Monitors showAll(int id);
    public void save(Monitors Monitors);
    public void update(int id, Monitors monitors);
}
