package com.example.wbdvsp2102swatinayakserverjava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.wbdvsp2102swatinayakserverjava.models.Widget;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, Long> {
	List<Widget> findWidgetsByTopicId(String tid);

	@Override
	List<Widget> findAll();
}
