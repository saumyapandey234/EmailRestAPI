package com.EmailWeb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EmailWeb.Model.EmailRequest;
import com.EmailWeb.services.EmailService;

@RestController
public class EmailController {

  @Autowired
  private EmailService emailService;

  @RequestMapping("/welcome")
  public String welcome() {
    return "Welcome to Email API";
  }

  // api to send email
  // ...existing code...
  @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
  public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
    System.out.println(request);
    boolean r = emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
    if (r) {
      return ResponseEntity.ok("Done....");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
    }
  }

}
