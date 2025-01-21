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


import com.dao.DianyingshangchengDao;
import com.entity.DianyingshangchengEntity;
import com.service.DianyingshangchengService;
import com.entity.vo.DianyingshangchengVO;
import com.entity.view.DianyingshangchengView;

@Service("dianyingshangchengService")
public class DianyingshangchengServiceImpl extends ServiceImpl<DianyingshangchengDao, DianyingshangchengEntity> implements DianyingshangchengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingshangchengEntity> page = this.selectPage(
                new Query<DianyingshangchengEntity>(params).getPage(),
                new EntityWrapper<DianyingshangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingshangchengEntity> wrapper) {
		  Page<DianyingshangchengView> page =new Query<DianyingshangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianyingshangchengVO> selectListVO(Wrapper<DianyingshangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianyingshangchengVO selectVO(Wrapper<DianyingshangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianyingshangchengView> selectListView(Wrapper<DianyingshangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingshangchengView selectView(Wrapper<DianyingshangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
