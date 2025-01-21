package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdianyingshangchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdianyingshangchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdianyingshangchengView;


/**
 * 电影商城评论表
 *
 * @author 
 * @email 
 * @date 2022-04-25 09:49:45
 */
public interface DiscussdianyingshangchengService extends IService<DiscussdianyingshangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdianyingshangchengVO> selectListVO(Wrapper<DiscussdianyingshangchengEntity> wrapper);
   	
   	DiscussdianyingshangchengVO selectVO(@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);
   	
   	List<DiscussdianyingshangchengView> selectListView(Wrapper<DiscussdianyingshangchengEntity> wrapper);
   	
   	DiscussdianyingshangchengView selectView(@Param("ew") Wrapper<DiscussdianyingshangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdianyingshangchengEntity> wrapper);
   	

}

