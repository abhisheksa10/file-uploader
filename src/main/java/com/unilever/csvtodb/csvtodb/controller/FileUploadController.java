package com.unilever.csvtodb.csvtodb.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unilever.csvtodb.csvtodb.dto.PersonOutingDTO;
import com.unilever.csvtodb.csvtodb.service.PersonOutingService;
import com.unilever.csvtodb.csvtodb.utils.CsvReader;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "CRUD operations on Person outing entity")
public class FileUploadController {

    @Autowired
    private PersonOutingService personOutingService;

    private static final Logger LOGGER = Logger.getLogger(FileUploadController.class);

    @PostMapping("/upload")
    public String processFileUpload(@RequestParam("file") final MultipartFile file, final RedirectAttributes redirectAttributes) {

        final String uploadStatusUrl = "redirect:/uploadStatus";
        if(!isFileValid(file)){

            redirectAttributes.addFlashAttribute("message", "Please select a valid file to upload");
            return uploadStatusUrl;
        }
        try {
            personOutingService.savePersonDetails(new CsvReader(file.getBytes()).getPersonList());

        } catch (final IOException exception) {
            LOGGER.error(exception.getMessage(),exception);
            redirectAttributes.addFlashAttribute("message", String.format("Error occured. Reason: %s",exception.getMessage()));

            return uploadStatusUrl;
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        return uploadStatusUrl;
    }

    @GetMapping("/upload")
    public String sendFile() {

        return "upload";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {

        return "uploadStatus";
    }

    /**
     * Validates the specified file for allowed file extension(.csv)
     * @param file
     * @return
     */
    private boolean isFileValid(final MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }

        final String allowedFileExtension = ".csv";
        final String fileName = file.getOriginalFilename();
        final int index = fileName.lastIndexOf('.');
        final String fileExtension = fileName.substring(index, fileName.length());

        return allowedFileExtension.equalsIgnoreCase(fileExtension);
    }
}