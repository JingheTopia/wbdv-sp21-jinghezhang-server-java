package com.example.wbdvspring21jhzserverjava.services;

import com.example.wbdvspring21jhzserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    private final List<Widget> widgets = new ArrayList<>();
    {
        Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to Widgets");
        Widget w2 = new Widget(234l, "ABC234", "PARAGRAPH", 1, "This is a paragraph");
        Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Welcome to WebDev");
        Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem ipsum");
        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
        widgets.add(w4);
    }
    // implement crud operations
    public Widget createWidgetForTopic(Widget widget) {
        Long id = (new Date()).getTime();
        widget.setId(id);
        widgets.add(widget);
        return widget;
    }
    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        return widgets.stream()
                .filter(widget -> widget.getTopicId().equals(topicId))
                .collect(Collectors.toList());
    }

    public Widget findWidgetById(Long id) {
        return widgets.stream()
                .filter(widget -> widget.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Integer updateWidget(Long id, Widget newWidget) {
        System.out.println("Widget updating .....");
        System.out.println("updating widget: " + id + "text =  "+ newWidget.getText());
        System.out.println("size =  "+ newWidget.getSize());
        System.out.println("type =  "+ newWidget.getType());

        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(id)) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return -1;
    }

    public Integer deleteWidget(Long id) {
        int index = -1;

        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(id)) {
                index = i;
            }
        }
        if(index >= 0) {
            widgets.remove(index);
            return 1;
        }
        return -1;
    }
}
