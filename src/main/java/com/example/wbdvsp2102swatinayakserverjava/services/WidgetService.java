package com.example.wbdvsp2102swatinayakserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wbdvsp2102swatinayakserverjava.models.Widget;
import com.example.wbdvsp2102swatinayakserverjava.repositories.WidgetRepository;

@Service
public class WidgetService {

	@Autowired
	WidgetRepository repository;

	public Widget createWidget(String tid, Widget widget) {
		widget.setTopicId(tid);
		return repository.save(widget);
	}

	public List<Widget> findWidgetsForTopic(String tid) {
		return repository.findWidgetsByTopicId(tid);
	}

	public int updateWidget(Long wid, Widget newWidget) {
		try {
			newWidget.setId(wid);
			if (repository.existsById(wid)) {
				repository.save(newWidget);
				return 1;
			}
			return 0;
		} catch (Exception ex) {
			return 0;
		}

	}

	public int deleteWidget(Long wid) {
		try {
			repository.deleteById(wid);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

	public List<Widget> findAllWidgets() {
		return repository.findAll();
	}

	public Widget findWidgetById(Long wid) {
		return repository.findById(wid).orElse(null);
	}
}
