package com.github.manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.core.ResultInfo;
import com.github.common.core.ResultUtil;
import com.github.manager.entity.City;
import com.github.manager.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * @author colg
 */
@Api(tags = "城市模块 API")
@RestController
public class CityRestController {

	@Autowired
	private CityService cityService;

	@ApiOperation("查询城市")
	@ApiParam("城市ID")
	@GetMapping("/api/city/{id}")
	public ResultInfo findOneCity(@PathVariable("id") Integer id) {
		return ResultUtil.success(cityService.findCityById(id), 200, "操作成功");
	}

	@ApiOperation("查询城市列表")
	@GetMapping("/api/city")
	public ResultInfo findAllCity() {
		return ResultUtil.success(cityService.findAllCity(), 200, "操作成功");
	}

	@PostMapping("/api/city")
	public void createCity(@RequestBody City city) {
		cityService.saveCity(city);
	}

	@PutMapping("/api/city")
	public void modifyCity(@RequestBody City city) {
		cityService.updateCity(city);
	}

	@DeleteMapping("/api/city/{id}")
	public void modifyCity(@PathVariable("id") Integer id) {
		cityService.deleteCity(id);
	}
}
