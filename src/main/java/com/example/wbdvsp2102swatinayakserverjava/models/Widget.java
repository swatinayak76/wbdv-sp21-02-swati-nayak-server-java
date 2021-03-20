package com.example.wbdvsp2102swatinayakserverjava.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Widget {

	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	private String id;

	@NotBlank(message = "Type is mandatory")
	private String type;

	private int widgetOrder;

	@NotBlank(message = "Type is mandatory")
	private String text;

	@Size(min = 5, message = "src should have atleast 2 characters")
	@NotBlank(message = "src is mandatory")
	private String src;

	private int size;
	private int width;
	private int height;
	private String cssClass;
	private String style;
	private String value;
	private String topicId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	@Override
	public String toString() {
		return "Widget [name=" + name + ", id=" + id + ", type=" + type + ", widgetOrder=" + widgetOrder + ", text="
				+ text + ", src=" + src + ", size=" + size + ", width=" + width + ", height=" + height + ", cssClass="
				+ cssClass + ", style=" + style + ", value=" + value + ", topicId=" + topicId + "]";
	}

}
