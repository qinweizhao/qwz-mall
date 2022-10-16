## 系统模块

~~~txt
com.qinweizhao    
├── mall-api             // 接口模块
│       └── mall-api-file                            // 文件接口 
│       └── mall-api-order                           // 订单接口 
│       └── mall-api-product                         // 商品接口 
│       └── mall-api-search                          // 检索接口 
│       └── mall-api-system                          // 系统接口 
│       └── mall-api-ware                            // 库存接口 
├── mall-auth            // 认证中心 [9000]
├── mall-common          // 通用模块
│       └── mall-common-core                         // 核心模块
│       └── mall-common-security                     // 安全模块
├── mall-gateway         // 网关模块 [8080]
├── mall-service         // 业务模块
│       └── mall-service-sale                    // 营销服务 [9009]
│       └── mall-service-order                       // 订单服务 [9007]
│       └── mall-service-payment                     // 支付服务 [9008]
│       └── mall-service-product                     // 商品服务 [9002]
│       └── mall-service-search                      // 检索服务 [9005]
│       └── mall-service-system                      // 系统服务 [9001]
│       └── mall-service-user                        // 用户服务 [9003]
│       └── mall-service-ware                        // 库存服务 [9004]
├── mall-support          // 业务支撑模块
│       └── mall-support-file                        // 文件服务 [9100]
│       └── mall-support-generator                   // 代码生成器 [9100]
├──pom.xml                // 公共依赖
~~~

