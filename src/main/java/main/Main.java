package main;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        //Hands-on test Project

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


        // Hands-on test Task
        Task task = new Task();
        TaskController taskController = new TaskController();

        // 1º test for save method;
        String data = "01/01/2222";
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date data2 = f.parse(data);

        task.setIdProject(2); //Look at ID from MySQL after save method project
        task.setName("Teste 2");
        task.setDescription("Descrição teste 2");
        task.setNotes("Fazer fazer");
        task.setCompleted(true);
        task.setDeadLine(data2);

        taskController.save(task);


        // 2º test for update method;
        task.setIdProject(2); //Look at ID from MySQL after save method project
        task.setName("Tarefa teste Update");
        task.setDescription("Descrição teste Uptade");
        task.setNotes("Fazer tal atividade");
        task.setCompleted(false);
        task.setDeadLine(data2);
        task.setId(1);

        taskController.update(task);

        // 3º test for gellAll method;
        List<Task> taskList = taskController.getAll(2);
        System.out.println("Tasks: " + taskList);

        // 4º test for delete method
        taskController.removeById(1); //Look at ID from MySQL after save method project
    }
}
