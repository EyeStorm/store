package com.tiagohs.service;

import com.tiagohs.model.Role;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.List;

public interface RoleService extends IBaseService<Role> {

  Service<List<Role>> findByRole(String role, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart);
}
