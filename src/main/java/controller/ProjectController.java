package controller;

import model.Project;
import util.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class ProjectController {

    public void save (Project project) {
        //Método para inserir registros no banco de dados (INSERT)
        String sql = "INSERT INTO project (" +
                "name," +
                "description, " +
                "createdAt," +
                "updatedAt ) " +
                "VALUES (?, ?, ?, ?);";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception exception){
            throw new RuntimeException ("Erro ao tentar inserir novo projeto" ,exception);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void update(Project project){
        //Método para atualizar o banco de dados (UPDATE)

    }

    public void removeById(int projectId) {
        //Método para deletar no banco de dados(DELETE)

    }

    public List<Project> getAll(int idProject) {
        //Método para retornar todas as tarefas do banco de dados (SELECT)
        return null;
    }

}
