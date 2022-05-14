module.exports = {
  productionSourceMap:false,
  // ESLINT校验工具
  lintOnSave: true,
  devServer:{
    host: '0.0.0.0',
    port: 8888,
    open: true,
    proxy:{
      '/api':{
        target:'http://localhost:8080',
         pathRewrite: {
          ['^/api']: ''
        }
      }
    }
  }
};
