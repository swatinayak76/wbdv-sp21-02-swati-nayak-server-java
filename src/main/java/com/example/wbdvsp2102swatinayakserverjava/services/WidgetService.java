package com.example.wbdvsp2102swatinayakserverjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.wbdvsp2102swatinayakserverjava.models.Widget;
import com.example.wbdvsp2102swatinayakserverjava.util.WidgetNotFoundException;

@Service
public class WidgetService {

	private static List<Widget> widgetList = new ArrayList<Widget>();
	private static int uniqueId = 1;

	String getUniqueId() {
		return (uniqueId++) + "";
	}

	public Widget createWidget(String tid, Widget widget) {
		String id = getUniqueId();
		widget.setId(id);
		widget.setTopicId(tid);
		widgetList.add(widget);
		return widget;
	}

	public List<Widget> findWidgetsForTopic(String tid) {
		return widgetList.stream().filter(w -> tid.equalsIgnoreCase(w.getTopicId())).collect(Collectors.toList());
	}

	public int updateWidget(String wid, Widget newWidget) throws WidgetNotFoundException {
		boolean isWidgetFound = false;
		for (int i = 0; i < widgetList.size(); i++) {
			if (widgetList.get(i).getId().equalsIgnoreCase(wid)) {
				widgetList.set(i, newWidget);
				isWidgetFound = true;
				return 1;
			}
		}
		if (!isWidgetFound) {
			throw new WidgetNotFoundException("No widget with id \"" + wid + "\" can be found");
		}
		return 0;
	}

	public int deleteWidget(String wid) throws WidgetNotFoundException {
		boolean isWidgetFound = false;
		for (int i = 0; i < widgetList.size(); i++) {
			if (widgetList.get(i).getId().equalsIgnoreCase(wid)) {
				widgetList.remove(i);
				isWidgetFound = true;
				return 1;
			}
		}
		if (!isWidgetFound) {
			throw new WidgetNotFoundException("No widget with id \"" + wid + "\" can be found");
		}
		return 0;
	}

	public List<Widget> findAllWidgets() {
		return widgetList;
	}

	public Widget findWidgetById(String wid) throws WidgetNotFoundException {
		return widgetList.stream().filter(w -> w.getId().equalsIgnoreCase(wid)).findAny()
				.orElseThrow(() -> new WidgetNotFoundException("No widget with id \"" + wid + "\" can be found"));
	}
}
