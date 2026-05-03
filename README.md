# Computer Networking Lab Experiments

This repository contains Computer Networking Lab experiments and Java networking programs implemented as part of academic coursework. The repository focuses on fundamental and intermediate networking concepts including switching, VLANs, routing, and application layer communication.

---

## Repository Overview

This project is divided into two main sections:

1. Cisco Packet Tracer Networking Labs  
2. Java Networking Programs  

---

# 1. Cisco Packet Tracer Networking Labs

## 1.1 Basic Switching (No VLAN, No Router)

### Description
A simple Layer 2 switching network where two switches connect four PCs in the same network.

### Key Features
- Two switches (S1, S2)
- Four PCs in a single subnet
- No VLAN configuration
- No router required
- MAC address learning by switches

### Concept Covered
- Layer 2 switching
- MAC address table
- Basic LAN communication

---

## 1.2 Hybrid Routing (Static + RIP v2)

### Description
A three-router topology combining dynamic routing (RIP v2) and static routing to control specific traffic paths.

### Key Features
- Three routers in triangular topology
- RIP v2 for dynamic routing
- Static routing to force specific path (R1 → R2 → R3)
- Multiple LANs connected to each router

### Concept Covered
- Distance vector routing (RIP)
- Static routing behavior
- Routing table selection logic
- Traceroute analysis

---

## 1.3 Inter-VLAN Routing (Router Physical Interfaces)

### Description
A VLAN-based network using a router with multiple physical interfaces to enable communication between VLANs.

### Key Features
- VLAN 10 and VLAN 20
- Two switches
- One router with multiple interfaces
- Inter-VLAN communication via routing
- Trunk link between switches

### Concept Covered
- VLAN segmentation
- Inter-VLAN routing
- Trunking between switches
- Layer 2 vs Layer 3 separation

---

# 2. Java Networking Programs

## 2.1 TCP Client-Server Communication

### Description
A socket-based client-server system where the client sends commands and the server responds accordingly.

### Supported Commands
- hi → returns greeting
- date → returns system date
- ip → returns client IP
- exit → terminates connection

### Concepts Covered
- TCP socket programming
- Client-server architecture
- Request-response model

---

## 2.2 SMTP Email Sender (SSL)

### Description
A Java program that sends emails using SMTP over SSL using authentication.

### Key Features
- SMTP connection using Gmail server
- SSL secure communication (port 465)
- Base64 authentication
- Email sending via SMTP commands

### Concepts Covered
- SMTP protocol
- SSL sockets
- Authentication mechanisms
- Application layer networking

---

# Technologies Used

## Networking
- Cisco Packet Tracer
- RIP v2 routing protocol
- Static routing
- VLAN configuration
- Layer 2 switching
- Inter-VLAN routing

## Programming
- Java Socket Programming
- TCP/IP communication
- SMTP protocol implementation
- SSL socket communication

---

# Learning Outcomes

After studying and implementing these labs, the following concepts are understood:

- How switches forward frames using MAC addresses
- How routing protocols dynamically share network information
- How static routing influences path selection
- How VLANs logically separate networks
- How inter-VLAN routing enables communication between VLANs
- How TCP client-server communication works
- How email transmission works using SMTP protocol

---

# How to Run

## Cisco Labs
- Open Packet Tracer files
- Configure devices using provided CLI steps
- Test using ping and traceroute

## Java Programs
```bash
javac filename.java
java filename
```