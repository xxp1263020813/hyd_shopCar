package cn.edu.zut.service;

import cn.edu.zut.DO.AuctionDO;

import java.util.List;

public interface AuctionService {
    /**
     * 从数据库中获取全部的商品信息，封装到一个List中
     * List的每一个元素就是一个商品信息的封装
     * @return
     */
    public List<AuctionDO> getAllAuction();
}
