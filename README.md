# 📜 Centralized Logging for Spring Boot with ELK Stack  
**A production-ready logging solution** for Spring Boot apps, featuring **Elasticsearch, Logstash, Kibana (ELK)** for scalable log aggregation, tracing, and visualization.  

---

## Key Features  
✔ **Multi-Appender Logging** – Console, file, and Logstash (JSON) in parallel.  
✔ **Distributed Tracing** – Auto-capture `traceId`/`spanId` with Micrometer Tracing.  
✔ **Smart Log Rotation** – Time + size-based rolling (100MB files, 30-day retention).  
✔ **Async Log Shipping** – Non-blocking Logstash TCP with reconnection logic.  
✔ **Dockerized ELK** – Preconfigured ELK stack (`docker-compose`).  

---

## Quick Start  

### 1. Run the ELK Stack  
```bash
docker-compose up -d  # Starts Elasticsearch, Logstash, Kibana (ports 5601, 9200, 5045)
```

### 2. Start the Spring Boot App  
```bash
mvn spring-boot:run
```

### 3. Generate Test Logs  
Call the test endpoint to trigger logs:  
```bash
curl "http://localhost:8080/test?fail=true"  # Forces an error log
```

### 4. View Logs in Kibana  
Access Kibana at `http://localhost:5601` and set up an index pattern for `logstash-*`.  

---

## 🛠️ Configuration Highlights  
### **Logback Setup** (`logback-spring.xml`)  
- **Console**: Colored output for dev.  
- **File**: Compressed archives with 5GB cap.  
- **Logstash**: JSON format with `appName`/`env` tags.  

### **ELK Ports**  
| Service       | Port | Purpose                |  
|---------------|------|------------------------|  
| Kibana        | 5601 | Log visualization       |  
| Elasticsearch | 9200 | Log storage/querying    |  
| Logstash      | 5045 | Receive logs from apps  |  

---

## 📂 Project Structure  
```
src/  
├── main/  
│   ├── java/  
│   │   └── com/example/demo/  
│   │       ├── TestController.java  # Test endpoint  
│   │       └── TestService.java     # Simulated business logic  
│   └── resources/  
│       ├── logback-spring.xml       # Logging config  
│       └── application.yml          # Spring Boot settings  
docker-compose.yml                   # ELK stack definition  
```

---

## Testing Scenarios  
| Endpoint          | Params             | Outcome                     |  
|-------------------|--------------------|-----------------------------|  
| `GET /test`       | `fail=false`       | Generates INFO logs         |  
| `GET /test`       | `fail=true`        | Triggers ERROR logs         |  

---

## Why Use This?  
- **Debug Faster**: Correlate logs with `traceId` in microservices.  
- **Reduce Costs**: Compressed archives + retention policies.  
- **Plug & Play**: Dockerized ELK + Spring Boot auto-configuration.  

---

## references
- [ELK Stack Docs](https://www.elastic.co/guide/index.html)  
- [Micrometer Tracing](https://micrometer.io/docs/tracing)  
