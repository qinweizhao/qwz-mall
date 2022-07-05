module.exports = {
  devServer: {
    host: 'http://10.200.47.113',
    sockHost: 'http://10.200.47.113',
    port: '9999',
    open: true,
    proxy: {
      // purchase item: https://cli.vuejs.org/config/#devserver-proxy
      '/': {
        target: 'http://10.200.47.113',
        secure: false,
        ws: false,
        changeOrigin: true,
        pathRewrite: {
          '^/api': '/'
        }
      }
    },
    disableHostCheck: true
  }
}
