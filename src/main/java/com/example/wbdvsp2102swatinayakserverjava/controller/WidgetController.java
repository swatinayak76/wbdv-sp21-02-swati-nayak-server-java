package com.example.wbdvsp2102swatinayakserverjava.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.wbdvsp2102swatinayakserverjava.models.Widget;
import com.example.wbdvsp2102swatinayakserverjava.services.WidgetService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class WidgetController {

	@Autowired
	WidgetService service;

	@PostMapping("/topics/{tid}/widgets")
	public Widget createWidget(@PathVariable("tid") String tid, @Valid @RequestBody Widget widget) {
		return service.createWidget(tid, widget);
	}

	@GetMapping("/topics/{tid}/widgets")
	public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid) {
		return service.findWidgetsForTopic(tid);
	}

	@PutMapping("/widgets/{wid}")
	public int updateWidget(@PathVariable("wid") Long wid, @Valid @RequestBody Widget widget) {
		return service.updateWidget(wid, widget);
	}

	@DeleteMapping("/widgets/{wid}")
	public int deleteWidget(@PathVariable("wid") Long wid) {
		return service.deleteWidget(wid);

	}

	@GetMapping("/widgets")
	public List<Widget> findAllWidgets() {
		return service.findAllWidgets();
	}

	@GetMapping("/widgets/{wid}")
	public Widget findWidgetById(@PathVariable("wid") Long wid) {
		return service.findWidgetById(wid);
	}

}
