package com.example.wbdvsp2102swatinayakserverjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.wbdvsp2102swatinayakserverjava.models.Widget;

@Service
public class WidgetService {

	private static List<Widget> widgetList = new ArrayList<Widget>();
	//set WID
	String getUniqueId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
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

	public int updateWidget(String wid, Widget newWidget) {
		for (int i = 0; i < widgetList.size(); i++) {
			if (widgetList.get(i).getId().equalsIgnoreCase(wid)) {
				Widget oldWidget = widgetList.get(i);
				newWidget.setId(oldWidget.getId());
				newWidget.setTopicId(oldWidget.getTopicId());
				widgetList.set(i, newWidget);
				return 1;
			}
		}

		return 0;
	}

	public int deleteWidget(String wid) {
		for (int i = 0; i < widgetList.size(); i++) {
			if (widgetList.get(i).getId().equalsIgnoreCase(wid)) {
				widgetList.remove(i);
				return 1;
			}
		}

		return 0;
	}

	public List<Widget> findAllWidgets() {
		return widgetList;
	}

	public Widget findWidgetById(String wid) {
		return widgetList.stream().filter(w -> w.getId().equalsIgnoreCase(wid)).findAny().orElse(null);
	}
}
