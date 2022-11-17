import request from '@/utils/request'

// 属性和属性分组
// 查询与分类的关联信息
export function getRelation(query) {
  return request({
    url: '/product/attr/attr-group/list',
    method: 'get',
    params: query
  })
}

// 查询角色未授权用户列表
export function unRelation(query) {
  return request({
    url: '/product/attr/attr-group/un-relation',
    method: 'get',
    params: query
  })
}

// 新增属性分组
export function addRelation(data) {
  return request({
    url: '/product/attr/attr-group',
    method: 'post',
    data: data
  })
}

// 删除关联
export function delRelation(ids) {
  return request({
    url: '/product/attr/attr-group/' + ids,
    method: 'delete'
  })
}

