# qbgc-test-ribbon
## ribbon
 * 1.使用 ribbon 进行服务间的调用
 * 2.修改端口再次启动微服务就可以有两个服务被启动，从而形成集群
 * 3.@LoadBalanced 开启负载均衡，访问微服务时，会在两个不同端口微服务之间切换
 * 4.启动 Ioc 时，如果扫描到 @Autowired 这个注解，就会去找相应的 Bean ，然后进行装配
 * 5.访问微服务可以通过主机名、ip 地址或者微服务大写名
## 步骤
* 将RestTemplete实例化对象restTemplete注入为Bean
* 通过对象方法getForObject()调用其它微服务的方法
* 通过@AutoWire注解装配Bean
## 使用断路器
* 添加hystrix依赖
* 添加@EnableHystrix
* service类中添加代码：
```
    @HystrixCommand(fallbackMethod = "error")
	public String index(){
		// 本测试重点
		return restTemplate.getForObject("http://QBGC-ADMIN-SERVICE/hi?name=gaochao", String.class);
	}
	public String error(){
        return "ribbon断路器告诉你出错了！";
    }
```

