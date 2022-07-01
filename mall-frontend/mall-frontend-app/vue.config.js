let proxyObj = {};
proxyObj['/ws'] = {
    ws: false,
    target: "ws://localhost:8080"
};
proxyObj['/'] = {
    ws: false,
    target: "http://localhost:8080",
    changeOrigin: true,
    pathRewrite: {
        '^/app': '/'
    }
};
module.exports = {
    publicPath:'/',
    devServer: {
        host: '127.0.0.1',
        port: 8088,
        proxy: proxyObj
    }
}