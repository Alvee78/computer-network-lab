# Computer Networking Lab – Experiment: Inter-VLAN Routing 

## Experiment Title

Inter-VLAN Routing using Router with Multiple Physical Interfaces 

---

## Objective

To configure inter-VLAN communication using:

* Two VLANs (VLAN 10 and VLAN 20)
* Two switches
* PCs in different VLANs across switches
* Enable communication between VLAN 10 and VLAN 20 using routing

---

## Problem Statement

Design a network with the following requirements:

* Two switches (S1 and S2)
* Each switch has 2 PCs
* VLAN 10 and VLAN 20 are configured on both switches
* A router is connected only to Switch 1 using two separate physical links
* Switch 1 and Switch 2 are connected via trunk link
* Inter-VLAN routing is achieved using router physical interfaces
* PCs in VLAN 10 must communicate with VLAN 20 PCs

---

## Topology Description

* S1 connected to S2 via trunk link
* Router connected to S1 using two physical interfaces:

  * One interface for VLAN 10 network
  * One interface for VLAN 20 network
* S1 and S2 both carry VLAN 10 and VLAN 20 traffic

---

## VLAN and IP Addressing Scheme

### VLANs

| VLAN | Name   |
| ---- | ------ |
| 10   | VLAN10 |
| 20   | VLAN20 |

---

### IP Addressing

#### VLAN 10 Network

| Device      | IP Address   | Subnet Mask   |
| ----------- | ------------ | ------------- |
| PC1 (S1)    | 192.168.10.2 | 255.255.255.0 |
| PC3 (S2)    | 192.168.10.3 | 255.255.255.0 |
| Router G0/0 | 192.168.10.1 | 255.255.255.0 |

---

#### VLAN 20 Network

| Device      | IP Address   | Subnet Mask   |
| ----------- | ------------ | ------------- |
| PC2 (S1)    | 192.168.20.2 | 255.255.255.0 |
| PC4 (S2)    | 192.168.20.3 | 255.255.255.0 |
| Router G0/1 | 192.168.20.1 | 255.255.255.0 |

---

## Configuration Steps

---

## 1. VLAN Configuration (Both Switches)

### On S1 and S2

```
enable
configure terminal

vlan 10
name VLAN10

vlan 20
name VLAN20
```

---

## 2. Assign Access Ports

### Switch S1

```
interface fa0/1
switchport mode access
switchport access vlan 10

interface fa0/2
switchport mode access
switchport access vlan 20

interface fa0/3
switchport mode access
switchport access vlan 10

interface fa0/4
switchport mode access
switchport access vlan 20
```

### Switch S2

```
interface fa0/1
switchport mode access
switchport access vlan 10

interface fa0/2
switchport mode access
switchport access vlan 20

interface fa0/3
switchport mode access
switchport access vlan 10

interface fa0/4
switchport mode access
switchport access vlan 20
```

---

## 3. Trunk Between Switches

### On S1

```
interface fa0/24
switchport mode trunk
switchport trunk allowed vlan 10,20
```

### On S2

```
interface fa0/24
switchport mode trunk
switchport trunk allowed vlan 10,20
```

---

## 4. Router Configuration (Inter-VLAN Routing)

### Router connected to S1

### VLAN 10 Interface

```
interface g0/0
ip address 192.168.10.1 255.255.255.0
no shutdown
```

### VLAN 20 Interface

```
interface g0/1
ip address 192.168.20.1 255.255.255.0
no shutdown
```

---

## 5. PC Configuration

### VLAN 10 PCs

* PC1 (S1): 192.168.10.2 /24, Gateway: 192.168.10.1
* PC3 (S2): 192.168.10.3 /24, Gateway: 192.168.10.1

### VLAN 20 PCs

* PC2 (S1): 192.168.20.2 /24, Gateway: 192.168.20.1
* PC4 (S2): 192.168.20.3 /24, Gateway: 192.168.20.1

---

## 6. Verification Commands

### On Switch

```
show vlan brief
show interfaces trunk
```

### On Router

```
show ip interface brief
```

### Testing

```
ping 192.168.20.3   (from VLAN 10 PC)
ping 192.168.10.3   (from VLAN 20 PC)
```

---

## Expected Result

* VLAN 10 and VLAN 20 are separated at Layer 2
* Router enables communication between VLANs
* PCs across VLANs can communicate successfully
* Switches handle VLAN propagation via trunk link

---

## Conclusion

This experiment demonstrates inter-VLAN routing using a router with multiple physical interfaces. VLAN segmentation is maintained at Layer 2 while the router provides Layer 3 connectivity between VLAN 10 and VLAN 20 across two switches.
