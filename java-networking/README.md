# Java Networking Lab

This module contains implementations of networking concepts using Java, including socket-based client-server communication and SMTP email sending using SSL.

---

## Contents

### 1. Client-Server Communication

A simple TCP-based client-server application where the client sends commands and the server responds accordingly.

### 2. SMTP Email Sender

A Java program that connects to an SMTP server over SSL and sends emails using authentication.

---

## Technologies Used

* Java Networking (Socket, ServerSocket)
* SSL Sockets
* SMTP Protocol
* Base64 Encoding

---

## 1. Client-Server Application

### Description

The server listens on port `7777` and responds to specific client commands.

### Supported Commands

| Command | Description                 |
| ------- | --------------------------- |
| hi      | Server replies with "hi"    |
| date    | Returns current system date |
| ip      | Returns client IP address   |
| exit    | Terminates connection       |

---

### How to Run

#### Step 1: Compile

```id="cs1"
javac server.java client.java
```

#### Step 2: Run Server

```id="cs2"
java server
```

#### Step 3: Run Client

```id="cs3"
java client
```

---

### Example Interaction

```id="cs4"
Client: hi
Server: hi

Client: date
Server: 2026-05-03

Client: ip
Server: 127.0.0.1
```

---

## 2. SMTP Email Sender

### Description

This program connects to an SMTP server (`smtp.gmail.com`) using SSL (port 465) and sends an email using authentication.

---

### How It Works

1. Establish SSL connection with SMTP server
2. Perform EHLO handshake
3. Authenticate using Base64 encoded credentials
4. Send email using SMTP commands

---

### How to Run

```id="smtp1"
javac email.java
java email
```

---

### Important Configuration

Before running, update the following:

```id="smtp2"
String user = "your_email@gmail.com";
String pass = "your_app_password";
```

---

### Important Notes

* Use an **App Password**, not your real email password
* Enable SMTP access for your email account
* Do not upload credentials to GitHub

---

## Learning Outcomes

* Understand TCP client-server architecture
* Learn socket communication in Java
* Understand SMTP protocol and email transmission
* Work with SSL sockets and authentication

---

## Limitations

* Server handles only one client at a time
* No encryption beyond SSL layer
* Credentials are hardcoded (should be externalized in real systems)

---

