package com.niha.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niha.overflow.models.Answer;
import com.niha.overflow.models.Question;
import com.niha.overflow.models.Tag;
import com.niha.overflow.repositories.AnswerRepo;
import com.niha.overflow.repositories.QuestRepo;
import com.niha.overflow.repositories.TagRepo;

@Service
public class OverflowService {
	@Autowired
	private AnswerRepo aRepo;
	@Autowired
	private QuestRepo qRepo;
	@Autowired
	private TagRepo tRepo;
	
	public Tag getOneTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	public ArrayList <Tag> splitTags(String tags) {
		//tag, tag, tag
		ArrayList<Tag> tagsForQ = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String s : tagsToProcess) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.getOneTag(s);
				tagsForQ.add(tagToAdd);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQ.add(this.getOneTag(s));
			}
			}
		return tagsForQ;
		
		}
		public Question CreateQuestion(Question question) {
			question.setQtags(this.splitTags(question.getTagsFromFrontEnd()));
			return this.qRepo.save(question);
		}
		
		public Answer createAnswer(Answer answer) {
			return this.aRepo.save(answer);
		}
		
		public List<Question> getAllQuestions() {
			return this.qRepo.findAll();
	
		}
		
		public Question findOneQuestion(Long id) {
			return this.qRepo.findById(id).orElse(null);
			}
		}
		

