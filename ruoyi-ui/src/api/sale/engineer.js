import request from '@/utils/request'

// 查询工程管理列表
export function listEngineer(query) {
  return request({
    url: '/sale/engineer/list',
    method: 'get',
    params: query
  })
}

// 查询工程管理详细
export function getEngineer(id) {
  return request({
    url: '/sale/engineer/' + id,
    method: 'get'
  })
}

// 新增工程管理
export function addEngineer(data) {
  return request({
    url: '/sale/engineer',
    method: 'post',
    data: data
  })
}

// 修改工程管理
export function updateEngineer(data) {
  return request({
    url: '/sale/engineer',
    method: 'put',
    data: data
  })
}

// 删除工程管理
export function delEngineer(id) {
  return request({
    url: '/sale/engineer/' + id,
    method: 'delete'
  })
}
