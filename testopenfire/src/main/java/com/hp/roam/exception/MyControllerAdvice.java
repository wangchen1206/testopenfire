package com.hp.roam.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * controller 增强器
 * 补充：如果全部异常处理返回json，
 * 那么可以使用 @RestControllerAdvice 代替 @ControllerAdvice ，这样在方法上就可以不需要添加 @ResponseBody。
 * @author wachen
 *
 */
//@ControllerAdvice
public class MyControllerAdvice {
	
	/**
	 * 应用到所有@RequestMapping注解的方法，在其执行之前初始化数据绑定器
	 * @author wachen
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){}
	
	/**
	 * 把值绑定到model中，使全局@RequestMapping可以获取到该值
	 * @param model
	 */
	/*@ModelAttribute
	public void addAttributes(ModelMap model){
		model.addAttribute("msg", "all bind this msg");
	}*/
	
	
	/**
	 * 全局异常捕捉处理
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public String errorHandler(Exception exception,Model model){
		model.addAttribute("msg", exception);
		return "error";
	}
	
	/**
	 * 自定义异常 
	 * spring 对RuntimeException 才会进行事物回滚
	 * @param myException
	 * @return
	 */
//	@ResponseBody
//	@ExceptionHandler(value = MyException.class)
//	public Map<String, String> myerrorHandler(MyException myException){
//		Map<String, String> map = new HashMap<>();
//		map.put("code", myException.getCode());
//		map.put("msg", myException.getMsg());
//		return map;
//	}
	
	/**
	 * 异常处理 
	 * 只能传入Model  不能传入ModelMap 和 Map 
	 * @param exception
	 * @param model
	 * @return
	 */
	//@ExceptionHandler(value = MyException.class)
	public String myerrorHandler(MyException exception,Model model){
		model.addAttribute("code",exception.getCode());
		model.addAttribute("msg", exception.getMsg());
		return "error";
	}
}
