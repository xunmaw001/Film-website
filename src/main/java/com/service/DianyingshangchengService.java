package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianyingshangchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianyingshangchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianyingshangchengView;


/**
 * 电影商城
 *
 * @author 
 * @email 
 * @date 2022-04-25 09:49:45
 */
public interface DianyingshangchengService extends IService<DianyingshangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingshangchengVO> selectListVO(Wrapper<DianyingshangchengEntity> wrapper);
   	
   	DianyingshangchengVO selectVO(@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);
   	
   	List<DianyingshangchengView> selectListView(Wrapper<DianyingshangchengEntity> wrapper);
   	
   	DianyingshangchengView selectView(@Param("ew") Wrapper<DianyingshangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingshangchengEntity> wrapper);
   	

}

