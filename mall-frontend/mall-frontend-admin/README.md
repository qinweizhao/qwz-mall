<p align="center">
    <img src="https://img.shields.io/badge/Vue-3.2.40-brightgreen.svg"/>
    <img src="https://img.shields.io/badge/Vite-3.2.0-green.svg"/>
    <img src="https://img.shields.io/badge/Element Plus-2.2.17-blue.svg"/>
    <a src="https://github.com/hxrui" target="_blank">
        <img src="https://img.shields.io/github/stars/youlaitech/youlai-mall.svg?style=social&label=Stars"/>
    </a>
    <a href="https://gitee.com/youlaitech/youlai-mall" target="_blank">
        <img src="https://gitee.com/youlaitech/youlai-mall/badge/star.svg"/>
    </a> 
    <br/>
    <img src="https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg"/>
    <a href="https://gitee.com/youlaiorg" target="_blank">
        <img src="https://img.shields.io/badge/Author-有来开源组织-orange.svg"/>
    </a>
</p>
<p align="center">
<a target="_blank" href="http://admin.youlai.tech">在线预览</a> |  <a target="_blank" href="https://www.youlai.tech">官方文档</a> 
</p>

## 项目介绍

  [mall-admin](https://gitee.com/youlaiorg/mall-admin) 是基于 [vue3-element-admin](https://gitee.com/youlaiorg/vue3-element-admin) 升级的 Vue3 版本有来商城管理前端工程；使用前端主流技术栈 Vue3 + Vite3 + TypeScript + Vue Router + Pinia + Volar + Element Plus 等；实现功能包括不限于动态权限路由、按钮权限控制、国际化、主题大小切换等。

## 项目优势

- 基于 vue-element-admin 升级的 Vue3 版本 ，极易上手，减少学习成本；
- 一套完整适配的微服务权限系统线上接口，企业级真实前后端接入场景，非 Mock 数据；
- 功能全面：国际化、动态路由、按钮权限、主题大小切换、Echarts、wangEditor；
- TypeScript 全面支持，包括组件和 API 调用层面；
- 主流 Vue3 生态和前端技术栈，常用组件极简封装；
- 从 0 到 1 的项目文档支持；
- 全栈技术支持: 微服务接口、Vue3 管理前端、uni-app 移动端和 K8S 持续集成交付；

## 技术栈

| 技术栈       | 描述                                   | 官网                                 |
| ------------ | -------------------------------------- | ------------------------------------ |
| Vue3         | 渐进式 JavaScript 框架                 | https://v3.cn.vuejs.org/             |
| TypeScript   | JavaScript 的一个超集                  | https://www.tslang.cn/               |
| Vite        | 前端开发与构建工具                     | https://cn.vitejs.dev/               |
| Element Plus | 基于 Vue 3，面向设计师和开发者的组件库 | https://element-plus.gitee.io/zh-CN/ |
| Pinia        | 新一代状态管理工具                     | https://pinia.vuejs.org/             |
| Vue Router   | Vue.js 的官方路由                      | https://router.vuejs.org/zh/         |

## 项目预览

在线预览地址: [admin.youlai.tech](http://admin.youlai.tech)

| ![控制台](https://www.youlai.tech/files/blog/dashboard.png) | ![国际化](https://www.youlai.tech/files/blog/i18n.gif)    |
| ----------------------------------------------------------- | --------------------------------------------------------- |
| ![菜单管理](https://www.youlai.tech/files/blog/menu.png)    | ![角色管理](https://www.youlai.tech/files/blog/role.png)  |
| ![商品管理](https://www.youlai.tech/files/blog/goods.png)   | ![库存设置](https://www.youlai.tech/files/blog/stock.png) |

## 项目地址

|                    | Gitee                                                                | Github                                                                 | GitCode                                                     |
| ------------------ | -------------------------------------------------------------------- | ---------------------------------------------------------------------- | ----------------------------------------------------------- |
| 开源组织           | [有来开源组织](https://gitee.com/youlaiorg)                          | [有来开源组织](https://github.com/youlaitech)                          | [有来开源组织](https://gitcode.net/youlai)                  |
| 技术团队           | [有来技术团队](https://gitee.com/youlaitech)                         | [有来技术团队](https://github.com/youlaitech)                          | -                                                           |
| 后端               | [youlai-mall](https://gitee.com/youlaiorg/youlai-mall)               | [youlai-mall](https://github.com/youlaitech/youlai-mall)               | [youlai-mall](https://gitcode.net/youlai/youlai-mall)       |
| 管理前端           | [mall-admin](https://gitee.com/youlaiorg/mall-admin)         | [mall-admin](https://github.com/youlaitech/mall-admin)         | [mall-admin](https://gitcode.net/youlai/mall-admin) |
| 小程序/H5/移动端   | [mall-app](https://gitee.com/youlaiorg/mall-app)                     | [mall-app](https://github.com/youlaitech/mall-app)                     | [mall-app](https://gitcode.net/youlai/mall-app)             |
| vue3-element-admin | [vue3-element-admin](https://gitee.com/youlaiorg/vue3-element-admin) | [vue3-element-admin](https://github.com/youlaitech/vue3-element-admin) | -                                                           |

## 启动部署

### 环境准备

- 安装 Node

  版本：≥v14.0.0

- 开发工具

  VSCode

- 必装插件

  - Vue Language Features (Volar) 
  - TypeScript Vue Plugin (Volar)


### 项目启动

> 如果前端开发人员或者本地没有启动 [后端接口](https://gitee.com/youlaitech/youlai-mall)的情况，需要修改 vite.config.ts 的代理地址 http://localhost:9999 为线上接口地址 https://api.youlai.tech

1. npm install
2. npm run dev
3. 浏览器访问 http://localhost:9527


### 项目部署

- 本地打包

  ```
  npm run build:prod
  ```

  生成的静态文件位于项目根目录 dist 文件夹下

- nginx.cofig 配置

  ```
  server {
      listen     80;
      server_name  localhost;

      location / {
          root /usr/share/nginx/html/web;
          index index.html index.htm;
      }

      # 代理转发请求至网关，prod-api标识解决跨域问题
      location /prod-api/ {
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_pass https://api.youlai.tech/;
      }
  }

  ```

## 联系信息

> 欢迎添加开发者微信，备注「有来」进群

| ![郝先瑞](https://www.youlai.tech/files/blog/rui.jpg) | ![张川](https://www.youlai.tech/files/blog/chuan.jpg) |
| ----------------------------------------------------- | ----------------------------------------------------- |
