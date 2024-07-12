package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import com.dan_ui.dan_ingestion_project.model.Feedback;

public interface IFeedbackService {

	public Feedback saveFeedback(Feedback feedback);
	public List<Feedback> findAllFeedback();
}
