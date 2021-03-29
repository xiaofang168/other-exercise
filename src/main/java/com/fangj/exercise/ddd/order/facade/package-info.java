/**
 * 领域防腐层，可无，如RPC调用服务获取信息进行上下文对象转换
 * <p>
 * 以用户信息防腐层举例，它以抽奖请求参数(LotteryContext)为入参，以城市信息(MtCityInfo)为输出
 * <p>
 * 亦称适配层。在一个上下文中，有时需要对外部上下文进行访问，通常会引入防腐层的概念来对外部上下文的访问进行一次转义
 * <p>
 * 有以下几种情况会考虑引入防腐层：
 * <p>
 * 1. 需要将外部上下文中的模型翻译成本上下文理解的模型。
 * 2. 不同上下文之间的团队协作关系，如果是供奉者关系，建议引入防腐层，避免外部上下文变化对本上下文的侵蚀。
 * 3. 该访问本上下文使用广泛，为了避免改动影响范围过大。
 */
package com.fangj.exercise.ddd.order.facade;