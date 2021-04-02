package com.example.wbdvspring21jhzserverjava.services;

import com.example.wbdvspring21jhzserverjava.models.Widget;
import com.example.wbdvspring21jhzserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {
    
    @Autowired
    WidgetRepository repository;

    public Widget createWidgetForTopic(Widget widget) {
        return repository.save(widget);
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        return repository.findWidgetsForTopic(topicId);
    }


    public Widget findWidgetById(Long id) {
        return repository.findWidgetById(id);
    }


    public Integer updateWidget(Long id, Widget newWidget) {
        Widget originalWidget = findWidgetById(id);
        originalWidget.setName(newWidget.getName());
        originalWidget.setSize(newWidget.getSize());
        originalWidget.setText(newWidget.getText());
        originalWidget.setUrl(newWidget.getUrl());
        originalWidget.setType(newWidget.getType());
        originalWidget.setWidgetOrder(newWidget.getWidgetOrder());
        originalWidget.setStyle(newWidget.getStyle());
        originalWidget.setValue(newWidget.getValue());
        originalWidget.setCssClass(newWidget.getCssClass());
        originalWidget.setHeight(newWidget.getHeight());
        originalWidget.setWidth(newWidget.getWidth());
        repository.save(originalWidget);
        return 1;
    }


    public Integer deleteWidget(Long id) {
        repository.deleteById(id);
        return 1;
    }
}
