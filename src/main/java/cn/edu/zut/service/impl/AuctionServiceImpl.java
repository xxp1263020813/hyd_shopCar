package cn.edu.zut.service.impl;

import cn.edu.zut.DAO.AuctioionDAO;
import cn.edu.zut.DAO.impl.AuctioionDAOImpl;
import cn.edu.zut.DO.AuctionDO;
import cn.edu.zut.service.AuctionService;

import java.util.List;

public class AuctionServiceImpl implements AuctionService {
    //实现一个操作Auction数据表的类AuctionDAO
    @Override
    public List<AuctionDO> getAllAuction() {
        AuctioionDAO auctioionDAO = new AuctioionDAOImpl();
        //TODO
        return auctioionDAO.getAllAuction();
    }
}
