import request from '@/utils/request'

// 查询会员等级列表
export function listLevel(query) {
  return request({
    url: '/user/level/list',
    method: 'get',
    params: query
  })
}

// 查询会员等级详细
export function getLevel(id) {
  return request({
    url: '/user/level/' + id,
    method: 'get'
  })
}

// 新增会员等级
export function addLevel(data) {
  return request({
    url: '/user/level',
    method: 'post',
    data: data
  })
}

// 修改会员等级
export function updateLevel(data) {
  return request({
    url: '/user/level',
    method: 'put',
    data: data
  })
}

// 删除会员等级
export function delLevel(id) {
  return request({
    url: '/user/level/' + id,
    method: 'delete'
  })
}
