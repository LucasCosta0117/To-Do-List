package controller;

import model.Project;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
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
        String sql = "UPDATE project SET " +
                "name = ?, " +
                "description = ?, " +
                "createdAt = ?, " +
                "updatedAt = ? " +
                "WHERE id = ?;";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao atualizar os dados do projeto", exception);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void removeById(int projectId) {
        //Método para deletar no banco de dados(DELETE)
        String sql = "DELETE FROM project WHERE id = ?;";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        } catch (Exception exception) {
            throw new RuntimeException ("Erro ao deletar um Projeto", exception);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Project> getAll() {
        //Método para retornar todas as tarefas do banco de dados (SELECT)
        String sql = "SELECT * FROM project;";
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Project> projects = new ArrayList<>();

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("nome"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));

                projects.add(project);
            }

        } catch(Exception exception){
            throw new RuntimeException("Erro ao exibir todos os projetos.", exception);
        }finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return projects;
    }

}
