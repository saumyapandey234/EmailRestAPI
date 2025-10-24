# Email REST API using Spring Boot

A simple REST API built with **Spring Boot** that allows sending emails using Gmail SMTP securely.

## Features
- Send emails via REST endpoint  
- Uses Gmail SMTP with SSL/TLS  
- Credentials stored securely via `.env` (never pushed to GitHub)

## Technologies
- Java 17+
- Spring Boot
- JavaMail API
- Maven

## How to Run
1. Clone this repo  
   ```bash
   git clone https://github.com/yourusername/EmailAPI.git
   cd EmailAPI
# Create a .env file in the root directory:
EMAIL_ID=youremail@gmail.com
EMAIL_PASSWORD=yourapppassword

# Run the app:
mvn spring-boot:run

# Test endpoint (using Postman):
POST /sendemail
Body (JSON):
{
  "to": "receiver@gmail.com",
  "subject": "Hello",
  "message": "Test email from Spring Boot!"
}
# Security
.env and application.properties are git-ignored to protect credentials.
