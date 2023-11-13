package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.workZone.dto.Image;
import com.jsp.workZone.service.ImageService;
import com.jsp.workZone.util.ResponseStructure;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/saveimage")
	public ResponseEntity<ResponseStructure<Image>> saveImage( @RequestBody(required = false) byte[] imageData) {
		
		
		return imageService.saveImage(imageData);
	}
	
	@GetMapping("/getimagebyid")
	public ResponseEntity<ResponseStructure<Image>> findImageById(@RequestParam int imageId) {
		return imageService.findImageById(imageId);
	}

	
	
	
	/*
	 * @PostMapping("/saveImage")
public ResponseEntity<ResponseStructure<Image>> saveImage(@RequestBody(required = false) Image image) {
    if (image == null) {
        // Handle the case when the request body is empty
        // For example, you can return an error response or take appropriate action.
    } else {
        // Check if the 'image' object contains valid data
        if (isValidImage(image)) {
            // Save the image or process it as needed
            // Return a success response
        } else {
            // Handle the case when the 'image' object is not valid
            // For example, return a validation error response.
        }
    }
}

	 */
}
