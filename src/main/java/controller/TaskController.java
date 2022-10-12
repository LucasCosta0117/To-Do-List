package controller;

import model.Task;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TaskController {

    public void save(Task task) {
        //Método para inserir registros no banco de dados (INSERT)
        String sql = "INSERT INTO task " +
                "(idProject," +
                "name," +
                "description," +
                "notes," +
                "isCompleted," +
                "deadline," +
                "createdAt," +
                "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao inserir uma nova tarefa", exception);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void update(Task task){
        //Método para atualizar o banco de dados (UPDATE)
        String sql = "UPDATE task SET " +
                "idProject = ?," +
                "name = ?," +
                "description = ?," +
                "notes = ?," +
                "isCompleted = ?," +
                "deadline = ?," +
                "createdAt = ?," +
                "updatedAt = ? " +
                "WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao atualizar uma tarefa", exception);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void removeById(int taskId) {
        //Método para deletar no banco de dados(DELETE)
        String sql = "DELETE FROM task WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch ( Exception exception ) {
            throw new RuntimeException("Erro ao deletar a tarefa", exception);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Task> getAll(int idProject){
        //Método para retornar todas as tarefas do banco de dados (SELECT)
        return null;
    }

}
