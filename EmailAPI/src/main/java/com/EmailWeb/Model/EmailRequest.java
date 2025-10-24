package com.EmailWeb.Model;

public class EmailRequest {

  private String to;
  private String subject;
  private String message;

  public EmailRequest(String to, String subject, String message) {
    this.to = to;
    this.subject = subject;
    this.message = message;
  }

  public EmailRequest() {

  }

  // Getter and Setter for from
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  // Getter and Setter for subject
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  // Getter and Setter for message
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  // toString method
  @Override
  public String toString() {
    return "EmailRequest {" +
        "to='" + to + '\'' +
        ", subject='" + subject + '\'' +
        ", message='" + message + '\'' +
        '}';
  }

}
