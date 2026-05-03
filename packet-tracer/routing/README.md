# Computer Networking Lab – Experiment: Hybrid Routing (Static + RIP)

## Experiment Title
Implementation of Hybrid Routing using Static Routing and RIP in a 3-Router Topology

---

## Objective
To configure a network with three interconnected routers where:
- One specific route (R1 to R3) is forced through a longer path using Static Routing
- All other routes are dynamically learned using RIP v2
- Full end-to-end connectivity is achieved between all PCs

---

## Problem Statement

Design and implement the network shown in the topology with the following requirements:

- Three routers (R1, R2, R3) connected in a triangular topology
- Each router is connected to one switch
- Each switch connects to one or more PCs
- Configure IP addressing for all interfaces
- Enforce communication from R1 to R3 via the longest path:
  
  R1 → R2 → R3 (using Static Routing)

- All remaining routes should be configured using RIP v2
- Verify connectivity using ping and traceroute

---

## Topology Description

- R1 connected to R2 and R3
- R2 connected to R1 and R3
- R3 connected to R1 and R2
- Each router has a LAN with PCs connected via a switch

---

## IP Addressing Scheme

### Router Interfaces

| Router | Interface | IP Address     | Subnet Mask     |
|--------|----------|----------------|-----------------|
| R1     | G0/0     | 10.0.12.1      | 255.0.0.0       |
| R1     | G0/1     | 9.0.13.1       | 255.0.0.0       |
| R1     | G0/2     | 192.168.1.1    | 255.255.255.0   |
| R2     | G0/0     | 192.168.2.1    | 255.255.255.0   |
| R2     | G0/1     | 10.0.12.2      | 255.255.255.0   |
| R2     | G0/2     | 11.0.23.1      | 255.0.0.0       |
| R3     | G0/0     | 11.0.23.2      | 255.0.0.0       |
| R3     | G0/1     | 9.0.13.2       | 255.0.0.0       |
| R3     | G0/2     | 192.168.3.1    | 255.255.255.0   |

---

## Configuration Steps

### 1. Basic Configuration (All Routers)
```
enable
configure terminal
```
### 2.2. Interface Configuration
R1
```
interface g0/0
ip address 10.0.12.1 255.0.0.0
no shutdown

interface g0/1
ip address 9.0.13.1 255.0.0.0
no shutdown

interface g0/2
ip address 192.168.1.1 255.255.255.0
no shutdown

```
R2
```
interface g0/0
ip address 192.168.2.1 255.255.255.0
no shutdown

interface g0/1
ip address 10.0.12.2 255.0.0.0
no shutdown

interface g0/2
ip address 11.0.23.1 255.0.0.0
no shutdown
```
R3
```
interface g0/0
ip address 11.0.23.2 255.0.0.0
no shutdown

interface g0/1
ip address 9.0.13.2 255.0.0.0
no shutdown

interface g0/2
ip address 192.168.3.1 255.255.255.0
no shutdown
```

### 3. RIP Configuration (All Routers)
common commands for all router
```
router rip
version 2
no auto-summary
```
R1
```
network 10.0.0.0
network 9.0.0.0
network 192.168.1.0
```
R1
```
network 10.0.0.0
network 11.0.0.0
network 192.168.2.0
```
R3
```
network 9.0.0.0
network 11.0.0.0
network 192.168.3.0
```
### 4. Static Routing (Force Longest Path)

Goal: Force traffic from R1 to R3 through R2 (R1 → R2 → R3)

On R1
```
ip route 192.168.3.0 255.255.255.0 10.0.12.2
```
On R3 (Return Path)
```
ip route 192.168.1.0 255.255.255.0 11.0.23.1
```

This ensures that traffic does not use the direct R1–R3 link.

### 5. PC Configuration
PC on R1 LAN
```
IP Address: 192.168.1.2
Subnet Mask: 255.255.255.0
Default Gateway: 192.168.1.1
```
PC on R2 LAN
```
IP Address: 192.168.2.2
Subnet Mask: 255.255.255.0
Default Gateway: 192.168.2.1
```
PC on R3 LAN
```
IP Address: 192.168.3.2
Subnet Mask: 255.255.255.0
Default Gateway: 192.168.3.1
```