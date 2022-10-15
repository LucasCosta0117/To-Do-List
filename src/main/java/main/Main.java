package main;

import controller.ProjectController;
import model.Project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Hands-on test
        Project project = new Project();
        ProjectController projectController = new ProjectController();

        // 1º test for save method
        project.setName("Project Test");
        project.setDescription("Description test");

        projectController.save(project);

        // 2º test for update method
        project.setId(1); //Look at ID from MySQL after save method
        project.setName("New Project test2");
        project.setDescription("New Project description2");

        projectController.update(project);

        // 3º test for a getAll method
        List<Project> projects = projectController.getAll();
        System.out.println("Qtd projetos registrados: " + projects.size());
        System.out.println("Projetos registrados: " + projects);

        // 4º test for a delete method
        project.setId(1); //Look at ID from MySQL after save method
        projectController.removeById(project.getId());
    }
}
