package com.tiagohs.service;

import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.List;

public interface ReportsService {

  <D> Service<JasperPrint> createJasperPrint(String reportTemplatePath, List<D> data, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart);

  void onClose();
}
