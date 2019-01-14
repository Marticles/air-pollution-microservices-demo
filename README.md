# air-pollution-microservices

基于 Spring Cloud 的历史空气污染物数据查询与PM2.5浓度预测数据查询 Demo

## 微服务架构


## 微服务配置

| 服务                                       | 端口 | 描述                       |
| :----------------------------------------- | :--- | :------------------------- |
| microservice-airpollution-eureka-server    | 8761 | Eureka 服务注册中心        |
| microservice-airpollution-zuul-gateway     | 8000 | Zuul 网关                  |
| microservice-airpollution-admin-service    | 8888 | Spring Boot Admin          |
| microservice-airpollution-demo             | 8080 | AirPollution Demo Web 服务 |
| microservice-airpollution-history-service  | 8081 | 历史空气污染物数据查询服务 |
| microservice-airpollution-forecast-service | 8082 | PM2.5浓度预测数据查询服务  |
| microservice-airpollution-sites-service    | 8083 | 监测站数据查询服务         |
| monolithic-airpollution-demo               | /    | AirPollution 单体架构      |



## 截图

### 历史污染物数据
![history](img\history.png)

### PM2.5浓度预测数据
![history](img\forecast.png)

### 触发熔断
![history](img\fail.png)

