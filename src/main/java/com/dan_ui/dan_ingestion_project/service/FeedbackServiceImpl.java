package com.dan_ui.dan_ingestion_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan_ui.dan_ingestion_project.model.Feedback;
import com.dan_ui.dan_ingestion_project.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepo;
	
	@Override
	public List<Feedback> findAllFeedback() {
		List<Feedback> feedbacks = feedbackRepo.findAll();
		return feedbacks;
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		Feedback savedFeedback = feedbackRepo.save(feedback);
		return savedFeedback;
	}

}
