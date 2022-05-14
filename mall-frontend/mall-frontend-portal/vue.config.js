module.exports = {
  productionSourceMap:false,
  // 关闭ESLINT校验工具
  lintOnSave: false,
  devServer:{
    proxy:{
      '/api':{
        target:'http://gmall-h5-api.atguigu.cn',
      }
    }
  }
};
