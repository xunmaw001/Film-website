package com.dao;

import com.entity.DianyingshangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianyingshangchengVO;
import com.entity.view.DianyingshangchengView;


/**
 * 电影商城
 * 
 * @author 
 * @email 
 * @date 2022-04-25 09:49:45
 */
public interface DianyingshangchengDao extends BaseMapper<DianyingshangchengEntity> {
	
	List<DianyingshangchengVO> selectListVO(@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);
	
	DianyingshangchengVO selectVO(@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);
	
	List<DianyingshangchengView> selectListView(@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);

	List<DianyingshangchengView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);
	
	DianyingshangchengView selectView(@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);
	

}
