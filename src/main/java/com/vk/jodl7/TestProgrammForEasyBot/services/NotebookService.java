package com.vk.jodl7.TestProgrammForEasyBot.services;

import com.vk.jodl7.TestProgrammForEasyBot.models.Notebook;

import java.util.List;

public interface NotebookService {
    public List<Notebook> showById();
    public Notebook showAll(int id);
    public void save(Notebook Notebook);
    public void update(int id, Notebook notebook);
}
