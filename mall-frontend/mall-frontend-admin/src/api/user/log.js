import request from '@/utils/request'

// 查询会员登录记录列表
export function listLog(query) {
  return request({
    url: '/product/log/list',
    method: 'get',
    params: query
  })
}

// 查询会员登录记录详细
export function getLog(id) {
  return request({
    url: '/product/log/' + id,
    method: 'get'
  })
}

// 新增会员登录记录
export function addLog(data) {
  return request({
    url: '/product/log',
    method: 'post',
    data: data
  })
}

// 修改会员登录记录
export function updateLog(data) {
  return request({
    url: '/product/log',
    method: 'put',
    data: data
  })
}

// 删除会员登录记录
export function delLog(id) {
  return request({
    url: '/product/log/' + id,
    method: 'delete'
  })
}
