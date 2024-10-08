package util;

import model.Project;
import model.Task;
import model.enums.TaskPriority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public List<String> validateProject(Project project) {
        List<String> errors = new ArrayList<>();

        validateString("Nom du projet", project.getName(), errors);

        validateString("Description du projet", project.getDescription(), errors);

        if (project.getStartDate() == null) {
            errors.add("La date de début ne peut pas être vide.");
        } else if (project.getStartDate().isBefore(LocalDate.now())) {
            errors.add("La date de début doit être dans le futur.");
        }

        if (project.getEndDate() == null) {
            errors.add("La date de fin ne peut pas être vide.");
        } else if (project.getEndDate().isBefore(LocalDate.now())) {
            errors.add("La date de fin doit être dans le futur.");
        } else if (project.getEndDate().isBefore(project.getStartDate())) {
            errors.add("La date de fin doit être après la date de début.");
        }

        if (project.getStatus() == null) {
            errors.add("Le statut du projet ne peut pas être vide.");
        }

        return errors;
    }

    public List<String> validateTask(Task task) {
        List<String> errors = new ArrayList<>();

        validateString("Nom du projet", task.getTitle(), errors);

        validateString("Description du projet", task.getDescription(), errors);

        if (task.getTaskPriority() == null || !isValidTaskPriority(task.getTaskPriority())) {
            errors.add("The task priority provided doesn't exist");
        }

        return errors;
    }

    private void validateString(String fieldName, String value, List<String> errors) {
        if (value == null || value.trim().isEmpty()) {
            errors.add(fieldName + " ne peut pas être vide.");
        } else if (value.length() < 3) {
            errors.add(fieldName + " doit contenir au moins 3 caractères.");
        }
    }

    private boolean isValidTaskPriority(TaskPriority taskPriority) {
        for (TaskPriority priority : TaskPriority.values()) {
            if (priority == taskPriority) {
                return true;
            }
        }
        return false;
    }

}
