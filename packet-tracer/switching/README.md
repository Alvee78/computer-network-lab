# Computer Networking Lab – Experiment: Basic Switching 

## Experiment Title

Basic LAN Communication using Two Switches and Four PCs

---

## Objective

To build a simple switched network using two switches where:

* All PCs are in the same network
* End-to-end connectivity is achieved using Layer 2 switching

---

## Problem Statement

Design a simple network with the following requirements:

* Two switches (S1 and S2)
* Each switch connects to two PCs
* All PCs are in the same IP network
* Switches are connected using a normal Ethernet link
* Verify full connectivity between all PCs

---

## Topology Description

* S1 connected to S2 using a single link
* S1 connects PC1 and PC2
* S2 connects PC3 and PC4
* All devices are in the same subnet

---

## IP Addressing Scheme

| Device | IP Address  | Subnet Mask   |
| ------ | ----------- | ------------- |
| PC1    | 192.168.1.2 | 255.255.255.0 |
| PC2    | 192.168.1.3 | 255.255.255.0 |
| PC3    | 192.168.1.4 | 255.255.255.0 |
| PC4    | 192.168.1.5 | 255.255.255.0 |

⚠ No default gateway required (no router)

---

## Configuration Steps

---

## 1. Switch Configuration

No VLAN configuration is required.
Just ensure all ports are in default mode.

### On Both Switches

```
enable
configure terminal
```

(No additional configuration required)

---

## 2. PC Configuration

### PC Settings

* PC1: 192.168.1.2 /24
* PC2: 192.168.1.3 /24
* PC3: 192.168.1.4 /24
* PC4: 192.168.1.5 /24

Subnet Mask for all:

```
255.255.255.0
```

---

## 3. Connectivity Test

### Ping Tests

```
ping 192.168.1.3   (from PC1)
ping 192.168.1.4   (from PC1)
ping 192.168.1.5   (from PC2)
```

---

## 4. Verification Commands (Switch)

### Check MAC address table

```
show mac address-table
```

---

## Expected Result

* All PCs can communicate with each other
* Switches learn MAC addresses dynamically
* No configuration is required on switches for basic forwarding

---

## Conclusion

This experiment demonstrates basic Layer 2 switching where switches forward frames based on MAC address learning. Since all PCs are in the same subnet and no VLANs or routers are used, communication is fully automatic through switching.
