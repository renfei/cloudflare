[English](./README.md) | [简体中文](./README_zh.md)

![Cloudflare](./document/image/cf-logo.jpeg)

注：Cloudflare®图形商标版权归 Cloudflare, Inc. 所有。

# Cloudflare

[![Maven Version](https://img.shields.io/maven-central/v/net.renfei/cloudflare.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22net.renfei%22%20AND%20a:%22cloudflare%22)
![Release Version](https://img.shields.io/github/v/release/renfei/cloudflare.svg?style=flat-square&label=Release&color=1784ff)
[![Actions Status](https://github.com/renfei/cloudflare/workflows/Build/badge.svg)](https://github.com/renfei/cloudflare/actions)
[![Travis Status](https://travis-ci.com/renfei/cloudflare.svg?branch=master)](https://travis-ci.com/github/renfei/cloudflare)
[![License](https://img.shields.io/badge/license-Apache_2.0-blue.svg?style=flat)](https://github.com/renfei/cloudflare/blob/master/LICENSE)

这个 Cloudflare Java 客户端支持 [Cloudflare 的 API v4](https://api.cloudflare.com/) ，允许您更快更轻松地访问Cloudflare的API的每一个特性！
要使用Maven或Gradle构建需要添加依赖项，请使用以下命令：

**Maven:**

```xml
<dependency>
  <groupId>net.renfei</groupId>
  <artifactId>cloudflare</artifactId>
  <version>1.0.0</version>
</dependency>
```

**Gradle:**
```
dependencies {
  compile 'net.renfei:cloudflare:1.0.0'
}
```

## 注意事项

Cloudflare API在**五分钟**内最多可发送**1200次**请求。

如果我们的系统被滥用，您使用 Cloudflare API 的能力可能会暂时或永久终止。 同样，应用程序中任何违背使 Cloudflare 对 Cloudflare 客户更有益的目标或试图损害客户或其数据的任何行为都将成为终止的理由。

## 使用场景

* 通过 API 将访问频率高的IP添加到 Cloudflare 黑名单中。
* 通过 Cloudflare API 动态修改DNS解析记录。

## 支持的接口端点

- [x] User
- [ ] User API Tokens
- [ ] Permission Groups
- [ ] User's Account Memberships
- [x] Accounts
- [ ] Account Members
- [ ] Account Roles
- [ ] Account Subscriptions
- [ ] Organizations
- [ ] Organization Invites
- [ ] Organization Members
- [ ] Organization Roles
- [ ] User's Invites
- [ ] User's Organizations
- [ ] User Billing Profile
- [ ] User Billing History
- [ ] User Subscription
- [ ] Account Billing Profile
- [ ] Zone Rate Plan
- [ ] Zone Subscription
- [ ] Audit Logs
- [ ] Argo Smart Routing
- [ ] Argo Analytics for Zone
- [ ] Argo Analytics for Geolocation
- [x] Zone
- [ ] Zone Settings
- [ ] Zone Cache Settings
- [ ] Zone Analytics
- [ ] Logs Received
- [ ] Logpush Jobs
- [x] DNS Records for a Zone
- [ ] DNS Analytics
- [ ] DNSSEC
- [ ] DNS Firewall
- [ ] DNS Firewall (Legacy)
- [ ] DNS Firewall Analytics
- [ ] DNS Firewall Analytics (Legacy)
- [ ] Secondary DNS (Secondary Zone)
- [ ] Secondary DNS (Primary Zone)
- [ ] Secondary DNS (TSIG)
- [ ] Secondary DNS (Peer)
- [ ] Secondary DNS (ACL)
- [ ] Cloudflare IPs
- [ ] Account-Level Custom Nameservers
- [ ] Account-Level Custom Nameservers Usage for a Zone
- [ ] Custom Pages for a Zone
- [ ] Custom SSL for a Zone
- [ ] Custom Hostname for a Zone
- [ ] Custom Hostname Fallback Origin for a Zone
- [ ] Keyless SSL for a Zone
- [ ] Analyze Certificate
- [ ] Certificate Packs
- [ ] SSL/TLS Mode Recommendation
- [ ] SSL Verification
- [ ] Universal SSL Settings for a Zone
- [ ] Origin CA
- [ ] Zone-Level Authenticated Origin Pulls
- [ ] Per-hostname Authenticated Origin Pull
- [ ] Stream Videos
- [ ] Stream Signing Keys
- [ ] Stream MP4 Downloads
- [ ] Stream Subtitles/Captions
- [ ] Stream Webhook
- [ ] Stream Watermark Profile
- [ ] Stream Live Inputs
- [ ] Cloudflare Images
- [ ] Cloudflare Images Variants
- [ ] Cloudflare Images Keys
- [ ] Pages Project
- [ ] Pages Deployment
- [ ] Pages Domains
- [ ] Worker Script
- [ ] Worker Routes
- [ ] Workers KV Namespace
- [ ] Workers KV Request Analytics
- [ ] Workers KV Stored Data Analytics
- [ ] Worker Script (Deprecated)
- [ ] Worker Binding (Deprecated)
- [ ] Worker Filters (Deprecated)
- [ ] Worker Cron Trigger
- [ ] Worker Tail Logs
- [ ] Worker Subdomain
- [ ] Worker Account Settings
- [ ] Durable Objects Namespace
- [ ] Spectrum Applications
- [ ] Spectrum Analytics (Summary)
- [ ] Spectrum Analytics (By Time)
- [ ] Spectrum Aggregate Analytics
- [ ] Page Rules for a Zone
- [ ] Available Page Rules for a Zone
- [ ] Rate Limits for a Zone
- [x] User-level Firewall Access Rule
- [x] Account-level Firewall access rule
- [x] Firewall Access Rule for a Zone
- [ ] WAF Rule Packages
- [ ] WAF Rule Groups
- [ ] WAF Rules
- [ ] Waf Overrides
- [ ] User-Agent Blocking Rules
- [ ] Zone Lockdown
- [ ] Firewall rules
- [ ] Filters
- [ ] Rules Lists
- [ ] Rules for Rulesets
- [ ] Account rulesets
- [ ] Zone rulesets
- [ ] Transform rules
- [ ] Managed headers API
- [ ] URL Normalization API
- [ ] Script Monitor
- [ ] Load Balancer Monitors
- [ ] Load Balancer Pools
- [ ] Load Balancer Healthcheck Events
- [ ] Load Balancer Regions
- [ ] Account Load Balancer Monitors
- [ ] Account Load Balancer Pools
- [ ] Account Load Balancer Search
- [ ] Load Balancers
- [ ] IP Address Management Prefixes
- [ ] IP Address Management Dynamic Advertisement
- [ ] IP Address Management Prefix Delegation
- [ ] Railgun
- [ ] Railgun Connections for a Zone
- [ ] Account Railguns
- [ ] Railgun Connections
- [ ] Organization Railgun
- [ ] Custom Pages (Account)
- [ ] Access Organizations
- [ ] Access Identity Providers
- [ ] Access Groups
- [ ] Access Service Tokens
- [ ] Access Short-Lived Certificates
- [ ] Access Mutual TLS Authentication
- [ ] Access Applications
- [ ] Access Policy
- [ ] Access Keys Configuration
- [ ] Access Requests
- [ ] Zero Trust Seats
- [ ] Access Bookmark Applications
- [ ] Zone-Level Access Organizations
- [ ] Zone-Level Access Identity Providers
- [ ] Zone-Level Access Groups
- [ ] Zone-Level Access Service Tokens
- [ ] Zone-Level Access Short-Lived Certificates
- [ ] Zone-Level Access Mutual TLS Authentication
- [ ] Zone-Level Access Applications
- [ ] Zone-Level Access Policy
- [ ] Zero Trust Users
- [ ] Zero Trust accounts
- [ ] Zero Trust Lists
- [ ] Zero Trust Gateway Locations
- [ ] Zero Trust Gateway Rules
- [ ] Zero Trust Gateway Application and Application Type mappings
- [ ] Zero Trust Gateway Categories
- [ ] Zero Trust Gateway Proxy Endpoints
- [ ] Device Posture Rules
- [ ] Devices
- [ ] Device Posture Integrations
- [ ] Health Checks
- [ ] Diagnostics
- [ ] Waiting Room
- [ ] Registrar Domains
- [ ] Argo Tunnel
- [ ] Cloudflare Tunnel
- [ ] Cloudflare Tunnel configuration
- [ ] Tunnel Route
- [ ] Tunnel Virtual Network
- [ ] Magic Transit Static Routes
- [ ] Magic GRE tunnels
- [ ] Magic IPsec tunnels
- [ ] Magic PCAP collection
- [ ] Domain Intelligence
- [ ] Domain History
- [ ] WHOIS Record
- [ ] IP Intelligence
- [ ] IP List
- [ ] Passive DNS by IP
- [ ] Phishing URL Scanner
- [ ] ASN Intelligence
- [ ] Notification Alert Types
- [ ] Notification Mechanism Eligibility
- [ ] Notification destinations with PagerDuty
- [ ] Notification policies
- [ ] Notification webhooks
- [ ] Notification History
- [ ] Web3 Hostname