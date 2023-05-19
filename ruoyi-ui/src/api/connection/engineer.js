import request from '@/utils/request'

// 查询engineer列表
export function listEngineer(query) {
  return request({
    url: '/connection/engineer/list',
    method: 'get',
    params: query
  })
}

//查询所有客户名
export function listConnectionNames() {
  return request({
    url: '/connection/engineer/findConnectionNames',
    method: 'get',
  })
}

export function listEngineerNames() {
  return request({
    url: '/connection/engineer/findEngineerNames',
    method: 'get',
  })
}

// 查询engineer详细
export function getEngineer(id) {
  return request({
    url: '/connection/engineer/' + id,
    method: 'get'
  })
}

// 新增engineer
export function addEngineer(data) {
  return request({
    url: '/connection/engineer',
    method: 'post',
    data: data
  })
}

// 修改engineer
export function updateEngineer(data) {
  return request({
    url: '/connection/engineer',
    method: 'put',
    data: data
  })
}

// 删除engineer
export function delEngineer(id) {
  return request({
    url: '/connection/engineer/' + id,
    method: 'delete'
  })
}
