import request from '@/utils/request'

// 查询列表
export function listCategory(query) {
  return request({
    url: '/product/category/page',
    method: 'get',
    params: query
  })
}

// 查询下拉树结构
export function tree() {
  return request({
    url: '/product/category/tree',
    method: 'get'
  })
}

// 查询详情
export function getCategory(menuId) {
  return request({
    url: '/product/category/' + menuId,
    method: 'get'
  })
}

// 新增
export function addCategory(data) {
  return request({
    url: '/product/category',
    method: 'post',
    data: data
  })
}

// 修改
export function updateCategory(data) {
  return request({
    url: '/product/category',
    method: 'put',
    data: data
  })
}

// 删除
export function delMenu(menuId) {
  return request({
    url: '/product/category/' + menuId,
    method: 'delete'
  })
}
