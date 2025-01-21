package com.dao;

import com.entity.DiscussdianyingshangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdianyingshangchengVO;
import com.entity.view.DiscussdianyingshangchengView;


/**
 * 电影商城评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-25 09:49:45
 */
public interface DiscussdianyingshangchengDao extends BaseMapper<DiscussdianyingshangchengEntity> {
	
	List<DiscussdianyingshangchengVO> selectListVO(@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);
	
	DiscussdianyingshangchengVO selectVO(@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);
	
	List<DiscussdianyingshangchengView> selectListView(@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);

	List<DiscussdianyingshangchengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);
	
	DiscussdianyingshangchengView selectView(@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);
	

}
