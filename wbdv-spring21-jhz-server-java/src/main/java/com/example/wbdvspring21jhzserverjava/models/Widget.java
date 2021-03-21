package com.example.wbdvspring21jhzserverjava.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Widget {
    private Long id;
    private String type;
    private Integer size;
    private String text;
    private String topicId;
    private Integer widgetOrder;
    private String url;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;

    public Widget(Long id,  String topicId, String type,  Integer size, String text) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.text = text;
        this.topicId = topicId;
    }
}

