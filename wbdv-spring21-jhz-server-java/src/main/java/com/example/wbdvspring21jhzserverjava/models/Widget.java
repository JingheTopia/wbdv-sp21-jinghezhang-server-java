package com.example.wbdvspring21jhzserverjava.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
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

}

