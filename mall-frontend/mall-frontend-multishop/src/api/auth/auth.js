import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/mall_auth/ua/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '/mall_auth/login_out',
    method: 'post'
  })
}
