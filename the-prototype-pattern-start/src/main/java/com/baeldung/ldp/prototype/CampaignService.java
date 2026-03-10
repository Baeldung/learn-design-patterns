package com.baeldung.ldp.prototype;

public class CampaignService {

    public Campaign duplicateCampaign(Campaign original) {
        Campaign copy = new Campaign();
        copy.setName(original.getName());
        copy.setDescription(original.getDescription());
        for (Task task : original.getTasks()) {
            Task taskCopy = new Task();
            taskCopy.setName(task.getName());
            taskCopy.setDueDate(task.getDueDate());
            taskCopy.setStatus(task.getStatus());
            copy.addTask(taskCopy);
        }
        return copy;
    }
}
