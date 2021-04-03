package com.example.wbdvsp2102swatinayakserverjava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@NotBlank(message = "TopicId is mandatory")
	private String topicId;

	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@Column
	private String name;

	@NotBlank(message = "Type is mandatory")
	@Column
	private String type;

	@Column(name = "widgetorder")
	private int widgetOrder;

	@NotBlank(message = "Text is mandatory")
	@Column
	private String text;

	@Size(min = 5, message = "src should have atleast 2 characters")
	@NotBlank(message = "src is mandatory")
	private String src;

	@Column
	private int size;

	@Column
	private int width;

	@Column
	private int height;

	@Column
	private String cssClass;

	@Column
	private String style;

	@Column
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWidgetOrder() {
		return widgetOrder;
	}

	public void setWidgetOrder(int widgetOrder) {
		this.widgetOrder = widgetOrder;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Widget [name=" + name + ", id=" + id + ", type=" + type + ", widgetOrder=" + widgetOrder + ", text="
				+ text + ", src=" + src + ", size=" + size + ", width=" + width + ", height=" + height + ", cssClass="
				+ cssClass + ", style=" + style + ", value=" + value + ", topicId=" + topicId + "]";
	}

}
