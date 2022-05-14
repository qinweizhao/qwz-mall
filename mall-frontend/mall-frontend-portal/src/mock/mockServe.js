//引入mockjs模块
import Mock from 'mockjs'
//引入JSON数据(json数据格式默认对外暴露 webpack 默认对外暴露的有:图片/json格式数据)
import banner from './banner.json'
import floor from './floor.json'

//mock数据 1.参数请求地址 2.请求参数
Mock.mock("/mock/banner",{code:200,data:banner})
Mock.mock("/mock/floor",{code:200,data:floor})

