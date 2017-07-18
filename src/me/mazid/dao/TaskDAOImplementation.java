package me.mazid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.mazid.model.Task;
import me.mazid.util.DBUtil;

public class TaskDAOImplementation implements TaskDAO {
	
	private Connection conn;
	
	public TaskDAOImplementation() {
		conn = DBUtil.getConnection();  
	}

	@Override
	public void createTask(Task task) {
		try {
            String query = "insert into tasks (name, description, dateCreated, dateUpdated) values (?,?,?,?)";
            
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setString( 1, task.getName() );
            preparedStatement.setString( 2, task.getDescription() );
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            task.setDateCreated(sqlDate);
            preparedStatement.setDate( 3, task.getDateCreated() );
            
            task.setDateUpdated(sqlDate);
            preparedStatement.setDate( 4, task.getDateUpdated() );
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void editTask(Task task) {
		try {
			String query = "update tasks set name=?, description=?, dateCreated=?, dateUpdated=? where id=?";
	        
			PreparedStatement preparedStatement = conn.prepareStatement(query);
	        
			preparedStatement.setString( 1, task.getName() );
	        preparedStatement.setString( 2, task.getDescription() );
	        preparedStatement.setDate( 3, task.getDateCreated() );
	        
	        java.util.Date utilDate = new java.util.Date();
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	        
	        task.setDateUpdated(sqlDate);
	        preparedStatement.setDate( 4, task.getDateUpdated() );
	        
	        preparedStatement.setInt(5, task.getId() );
	        preparedStatement.executeUpdate();
	        preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTask(int id) {
		try {
            String query = "delete from tasks where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Task> listAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from tasks" );
            while(resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDateCreated(resultSet.getDate("dateCreated"));
                task.setDateUpdated(resultSet.getDate("dateUpdated"));
                tasks.add(task);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
	}

	@Override
	public Task getTaskById(int id) {
		Task task = new Task();
        try {
            String query = "select * from tasks where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	task.setId(resultSet.getInt("id"));
            	task.setName(resultSet.getString("name"));
            	task.setDescription(resultSet.getString("description"));
            	task.setDateCreated(resultSet.getDate("dateCreated"));
            	task.setDateUpdated(resultSet.getDate("dateUpdated"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
	}
	
	
}
