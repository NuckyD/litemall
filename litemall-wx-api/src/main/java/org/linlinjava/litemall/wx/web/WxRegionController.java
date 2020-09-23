package org.linlinjava.litemall.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.RegexUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallAddress;
import org.linlinjava.litemall.db.domain.LitemallRegion;
import org.linlinjava.litemall.db.service.LitemallAddressService;
import org.linlinjava.litemall.db.service.LitemallRegionService;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.linlinjava.litemall.wx.service.GetRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 省市区查询
 */
@RestController
@RequestMapping("/wx/region")
@Validated
public class WxRegionController extends GetRegionService {
	private final Log logger = LogFactory.getLog(WxRegionController.class);

	@Autowired
	private LitemallAddressService addressService;

	@Autowired
	private LitemallRegionService regionService;

	/**
	 * 获取省市区
	 *
	 */
	@GetMapping("list")
	public Object list(Integer id) {
		List<LitemallRegion> regionList = regionService.queryByPid(id);
		return ResponseUtil.okList(regionList);
	}

}