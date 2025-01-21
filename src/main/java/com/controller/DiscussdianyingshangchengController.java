package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussdianyingshangchengEntity;
import com.entity.view.DiscussdianyingshangchengView;

import com.service.DiscussdianyingshangchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 电影商城评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-25 09:49:45
 */
@RestController
@RequestMapping("/discussdianyingshangcheng")
public class DiscussdianyingshangchengController {
    @Autowired
    private DiscussdianyingshangchengService discussdianyingshangchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussdianyingshangchengEntity discussdianyingshangcheng, 
		HttpServletRequest request){

        EntityWrapper<DiscussdianyingshangchengEntity> ew = new EntityWrapper<DiscussdianyingshangchengEntity>();
		PageUtils page = discussdianyingshangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdianyingshangcheng), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussdianyingshangchengEntity discussdianyingshangcheng, 
		HttpServletRequest request){
        EntityWrapper<DiscussdianyingshangchengEntity> ew = new EntityWrapper<DiscussdianyingshangchengEntity>();
		PageUtils page = discussdianyingshangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussdianyingshangcheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussdianyingshangchengEntity discussdianyingshangcheng){
       	EntityWrapper<DiscussdianyingshangchengEntity> ew = new EntityWrapper<DiscussdianyingshangchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussdianyingshangcheng, "discussdianyingshangcheng")); 
        return R.ok().put("data", discussdianyingshangchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussdianyingshangchengEntity discussdianyingshangcheng){
        EntityWrapper< DiscussdianyingshangchengEntity> ew = new EntityWrapper< DiscussdianyingshangchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussdianyingshangcheng, "discussdianyingshangcheng")); 
		DiscussdianyingshangchengView discussdianyingshangchengView =  discussdianyingshangchengService.selectView(ew);
		return R.ok("查询电影商城评论表成功").put("data", discussdianyingshangchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussdianyingshangchengEntity discussdianyingshangcheng = discussdianyingshangchengService.selectById(id);
        return R.ok().put("data", discussdianyingshangcheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussdianyingshangchengEntity discussdianyingshangcheng = discussdianyingshangchengService.selectById(id);
        return R.ok().put("data", discussdianyingshangcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussdianyingshangchengEntity discussdianyingshangcheng, HttpServletRequest request){
    	discussdianyingshangcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdianyingshangcheng);

        discussdianyingshangchengService.insert(discussdianyingshangcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussdianyingshangchengEntity discussdianyingshangcheng, HttpServletRequest request){
    	discussdianyingshangcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussdianyingshangcheng);

        discussdianyingshangchengService.insert(discussdianyingshangcheng);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussdianyingshangchengEntity discussdianyingshangcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussdianyingshangcheng);
        discussdianyingshangchengService.updateById(discussdianyingshangcheng);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussdianyingshangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussdianyingshangchengEntity> wrapper = new EntityWrapper<DiscussdianyingshangchengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussdianyingshangchengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
