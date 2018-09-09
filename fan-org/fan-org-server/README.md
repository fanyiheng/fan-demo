1.log
2.swagger
3.异常统一处理

##安装mysql 5.7
1.拉取 mysql:5.7
```
docker pull mysql:5.7
```
2.启动mysql容器，并设置字符集为utf8，字符检验集为 utf8_bin (表字段内容区分大小写),
将数据文件挂载到/opt/mysql/data，配置文件目录挂载到/opt/mysql/conf.d
```
docker run --name mysql -p 3306:3306 -v /opt/mysql/data:/var/lib/mysql -v /opt/mysql/conf.d:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=111111 -d mysql:5.7 --character-set-server=utf8 --collation-server=utf8_bin
```
3.设置数据库名和表名大小写无关  
需要修改配置文件后重启mysql服务(重启容器即可)
在挂载的配置文件路径下增加配置文件：
```
#vim /opt/mysql/conf.d/my.conf
[mysqld]
lower_case_table_names=1
```
4.查看支持的字符集  
```
#查看mysql支持的检验规则
show collation;
#查看mysql支持的字符集集默认的检验规则
show character set;
#查看mysql配置的校验规则
show variables like '%coll%';
#查看mysql配置的字符集规则
show variables like 'charac%';
#查看mysql配置的数据库名表名大小写规则
show variables like '%case%';
```
5.参考资料  
[安装mysql](https://hub.docker.com/_/mysql/)  
[mysql字符集详解](https://www.cnblogs.com/wcwen1990/p/6917109.html )  
[mysql表名大小写问题](https://www.cnblogs.com/kevingrace/p/6150748.html)  
---
##配置hibernate命名转换策略  
hibernate 5.0 以后配置如下：
```
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl  
##驼峰转下划线
spring.jpa.hibernate.naming.physical-strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy  
```
##springboot 如何实现自动配置
##AOP如何实现


