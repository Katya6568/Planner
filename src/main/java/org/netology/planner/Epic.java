package org.netology.planner;

public class Epic extends Task {
    String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String s : subtasks) {
            if (s.contains(query)) {
                return true;
            }
        }
        return false;
    }
}


