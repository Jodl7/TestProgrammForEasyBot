package com.vk.jodl7.TestProgrammForEasyBot.services;

import com.vk.jodl7.TestProgrammForEasyBot.models.HardDisc;

import java.util.List;

public interface HardDiscServices {
    public List<HardDisc> showById();
    public HardDisc showAll(int id);
    public void save(HardDisc HardDisc);
    public void update(int id, HardDisc hardDisc);
}
