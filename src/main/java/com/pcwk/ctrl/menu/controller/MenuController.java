package com.pcwk.ctrl.menu.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.menu.service.MenuService;

@Controller("menuController")
@RequestMapping("menu")
public class MenuController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	MenuService menuService;
	
	public MenuController() {}
	
	// 메뉴 목록
		@RequestMapping(value="/menuMove.do", method=RequestMethod.GET)
		public String menuMove(ProductVO inVO, Model model) throws SQLException{
		      
		      String viewName = "menu/menu_list";
		      LOG.debug("=================================");
		      LOG.debug("bowls");
		      LOG.debug("inVO : "+ inVO);
		      LOG.debug("=================================");
		      
		      List<ProductVO> list = menuService.menuList(inVO);
		      model.addAttribute("list", list);
		      
		      return viewName;
		   }
}
