# RALSpotify
RALSpotify is a feature-rich music streaming platform built with Java and Spring Boot. It allows users to manage playlists, explore songs, and experience seamless integration with Spotify's APIs.

The latest is in the dev1 branch.

# Table of Contents
- [Features](#features-🚀)
- [Tech Stack](#tech-stack-🛠️)
- [Getting Started](#get-started-💻)
- [Project Structure](#project-structure-📂)
- [API Endpoints](#api-endpoints-📬)
- [Future Enhancements](#future-enhancements-🔮)
- [Contributing](#contributing-🤝)


## Features 🚀
- **User Management:** Signup, login, and role-based authentication.
- **Playlist Management:** Create, update, and manage playlists.
- **Song Management:** Add, edit, and delete songs in your library.
- **Spotify Integration:** Seamlessly fetch data from Spotify APIs.
- **Security:** JWT-based authentication and role-based authorization.
- **Extensible Design:** Modular structure for easy feature addition.

## Tech Stack 🛠️
- **Backend:** Java, Spring Boot
- **Security:** Spring Security, JWT
- **Database:** MySQL/PostgreSQL (mention the one used)
- **Integration:** Spotify API
- **Tools:** Maven, VS Code, Postman

## Getting Started 💻
Follow these steps to set up the project on your local machine:

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL or PostgreSQL (ensure it is running)
- Spotify API credentials (How to Get Credentials)

## Installation
The latest is in the dev1 branch.
### Clone the repository:
```bash
git clone https://github.com/ShresthaAadit04484/RALSpotify.git
```

### Navigate to the project directory:
```bash
cd RALSpotify
```  

### Configure the database in application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/ralspotify  
spring.datasource.username=your-username  
spring.datasource.password=your-password  
```
### Install dependencies:
```bash
mvn install  
```
### Run the application:
```bash
mvn spring-boot:run  
```
### Access the app:
```bash
API: http://localhost:8080
Swagger (if configured): http://localhost:8080/swagger-ui.html
```
## Project Structure 📂
```
src/main/java/com/ralspotify/ralspotify_project  
│  
├── feature  
│   ├── user  
│   │   ├── controller  
│   │   ├── model  
│   │   ├── repository  
│   │   ├── service  
│   ├── song  
│   └── playlist  
│  
├── security  
│   ├── config  
│   ├── model  
│   ├── service  
```

## API Endpoints 📬

#### **User**

| **Method** | **Endpoint**          | **Description**           |
|------------|-----------------------|---------------------------|
| POST       | `/api/users/signup`   | Register a new user.      |
| POST       | `/api/users`          | Authenticate user.        |

---

#### **Playlist**

| **Method** | **Endpoint**          | **Description**           |
|------------|-----------------------|---------------------------|
| GET        | `/api/playlist`       | Fetch all playlists.      |
| POST       | `/api/playlist`       | Create a new playlist.    |

---
#### **Songs**

| **Method** | **Endpoint**          | **Description**           |
|------------|-----------------------|---------------------------|
| GET        | `/api/song`           | Fetch all playlists.      |
| POST       | `/api/song`           | Create a new playlist.    |

---

For a complete list, check the API documentation.

## Future Enhancements 🔮
- [ ] **Frontend:** Build a modern UI using React or Angular.
- [ ] **Recommendation Engine:** AI-based song recommendations.
- [ ] **Social Features:** User-to-user playlist sharing.
- [ ] **Mobile App:** Extend the functionality to Android/iOS.

## Contributing 🤝
Contributions are welcome! Please follow these steps:

## Fork the repository.
### Create a new branch:
```bash
git checkout -b feature-name  
```
### Commit your changes:
```bash
git commit -m "Add your message"  
```
### Push to the branch:
```bash
git push origin feature-name  
```
Submit a pull request.
