import request from '@/utils/request'

// 查询库存工作单列表
export function listTask(query) {
  return request({
    url: '/product/task/list',
    method: 'get',
    params: query
  })
}

// 查询库存工作单详细
export function getTask(id) {
  return request({
    url: '/product/task/' + id,
    method: 'get'
  })
}

// 新增库存工作单
export function addTask(data) {
  return request({
    url: '/product/task',
    method: 'post',
    data: data
  })
}

// 修改库存工作单
export function updateTask(data) {
  return request({
    url: '/product/task',
    method: 'put',
    data: data
  })
}

// 删除库存工作单
export function delTask(id) {
  return request({
    url: '/product/task/' + id,
    method: 'delete'
  })
}
