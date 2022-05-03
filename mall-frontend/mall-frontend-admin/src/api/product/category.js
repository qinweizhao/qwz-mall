import request from '@/utils/request'

// 分页
export function pageCategory(query) {
  return request({
    url: '/product/category/page',
    method: 'get',
    params: query
  })
}

// 下拉树结构
export function treeCategory() {
  return request({
    url: '/product/category/tree',
    method: 'get'
  })
}

// 详情
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
export function delCategory(menuId) {
  return request({
    url: '/product/category/' + menuId,
    method: 'delete'
  })
}
