package com.github.elizabetht.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.model.FileModel;
import com.github.elizabetht.repository.QuestionRepository;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {
	
	// same as Repository annotation
	@Autowired
	private QuestionRepository questionRepository;
	
	@Transactional
	public FileModel save(FileModel fileModel){
		return questionRepository.save(fileModel);
	}
}
