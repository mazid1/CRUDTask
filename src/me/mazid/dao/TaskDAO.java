package me.mazid.dao;

import java.util.List;

import me.mazid.model.Task;

public interface TaskDAO {
	public void createTask(Task task);
	public void editTask(Task task);
	public void deleteTask(int id);
    public List<Task> listAllTasks();
    public Task getTaskById(int id);
}
