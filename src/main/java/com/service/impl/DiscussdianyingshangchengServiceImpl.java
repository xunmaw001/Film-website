package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussdianyingshangchengDao;
import com.entity.DiscussdianyingshangchengEntity;
import com.service.DiscussdianyingshangchengService;
import com.entity.vo.DiscussdianyingshangchengVO;
import com.entity.view.DiscussdianyingshangchengView;

@Service("discussdianyingshangchengService")
public class DiscussdianyingshangchengServiceImpl extends ServiceImpl<DiscussdianyingshangchengDao, DiscussdianyingshangchengEntity> implements DiscussdianyingshangchengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdianyingshangchengEntity> page = this.selectPage(
                new Query<DiscussdianyingshangchengEntity>(params).getPage(),
                new EntityWrapper<DiscussdianyingshangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdianyingshangchengEntity> wrapper) {
		  Page<DiscussdianyingshangchengView> page =new Query<DiscussdianyingshangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdianyingshangchengVO> selectListVO(Wrapper<DiscussdianyingshangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdianyingshangchengVO selectVO(Wrapper<DiscussdianyingshangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdianyingshangchengView> selectListView(Wrapper<DiscussdianyingshangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdianyingshangchengView selectView(Wrapper<DiscussdianyingshangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
