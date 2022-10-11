package controller;

import model.Task;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TaskController {

    public void save(Task task){
        //Método para inserir no banco de dados (INSERT)
    }

    public void update(Task task){
        //Método para atualizar o banco de dados (UPDATE)
    }

    public void removeById(int taskId) throws SQLException {
        //Método para deletar no banco de dados(DELETE)
        String sql = "DELETE FROM task WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch ( SQLException exception ) {
            throw new SQLException("Erro ao deletar a tarefa", exception);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    public List<Task> getAll(int idProject){
        //Método para retornar todas as tarefas do banco de dados (SELECT)
        return null;
    }

}
