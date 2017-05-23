package com.github.elizabetht.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.elizabetht.model.FileModel;
import com.github.elizabetht.service.FileUploadService;

@Controller
public class FileUploadController {
	
	//FAL Server Path
	@Value("${RootPath}")
	private String falServerPath;

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String fileUpload(Model model) {
		model.addAttribute("fileModel", new FileModel());
		return "upload";
	}

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		String result = "";
		if (!file.isEmpty()) {
			try {
				byte[] b = file.getBytes();
				
				// Below path should be changed based on configuration of OS
				// Creating the directory to store file
				String rootPath = "/home/devendra/Test/Upload";
				// String userHome = System.getProperty( "user.home" );
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				String absPath = dir.getAbsolutePath();
				// Create the file on server
				File serverFile = new File(absPath + File.separator + name);
				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(serverFile));
				bs.write(b);
				bs.close();
				result = "You successfully uploaded file=" + name;
			} catch (Exception e) {
				result = "file is failed due to error " + e.getMessage();
			}
		} else {
			result = "Uploaded file=" + name + " is empty.";
		}

		return result;
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@ModelAttribute("fileModel") FileModel fileModel,
			// @RequestParam(value ="name",required=false) String []name, Need to investigae solution for this
			@RequestParam(value = "file", required = false) MultipartFile[] file) {
		
		StringBuffer result = new StringBuffer();
		int noOfFile = file.length;

		if (fileModel != null) {
			// Save file name of question and answer in DB to get QuestionID then upload file
			fileModel.setActive(1);
			FileModel fl = fileUploadService.save(fileModel);
			String[] name = new String[5];
			// TODO : Remove below hardcoding or find some other work around
			name[0] = fileModel.getQuestionFileName();
			name[1] = fileModel.getAnswerFileName1();
			name[2] = fileModel.getAnswerFileName2();
			name[3] = fileModel.getAnswerFileName3();
			name[4] = fileModel.getAnswerFileName4();
			// Upload files to physical location
			for (int i = 0; i < noOfFile; ++i) {

				if (!file[i].isEmpty() && name[i] != "") {
					try {

						byte[] b = file[i].getBytes();
						// Below path should be changed based on
						// configuration of OS
						// Creating the directory to store file
						
						String rootPath = falServerPath;

						if (fl != null) {
							rootPath = rootPath + File.separator + fl.getQuestionID();
						}

						File dir = new File(rootPath);
						if (!dir.exists())
							dir.mkdirs();

						String absPath = dir.getAbsolutePath();
						// Create the file on server
						File serverFile = new File(absPath + File.separator + name[i]);
						BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(serverFile));
						bs.write(b);
						bs.close();
						result.append("You successfully uploaded file=" + name[i] + "<br/>");
					} catch (Exception e) {
						result.append("file is failed due to error " + e.getMessage() + "<br/>");
					}
				} else {
					result.append("Uploaded file=" + name[i] + " is empty." + "<br/>");
				}
			}

		}

		return result.toString();
	}

}
