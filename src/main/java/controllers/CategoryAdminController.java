package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Category;
import services.CategoryService;

@Controller
@RequestMapping("/category/admin")
public class CategoryAdminController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private CategoryService categoryService;

	// =============== Creation ===================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;

		Category category = categoryService.create();

		res = createEditModelAndView(category);
		return res;
	}

	// =============== Edition ====================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int categoryId) {

		ModelAndView result;
		Category category;

		category = categoryService.findOne(categoryId);
		Assert.notNull(category);
		result = createEditModelAndView(category);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Category category, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(category);
		} else {
			try {
				categoryService.save(category);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = createEditModelAndView(category, "category.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Category category, BindingResult binding) {

		ModelAndView result;

		try {
			categoryService.delete(category);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(category, "category.commit.error");
		}
		return result;

	}

	// =============== Ancillary Methods ==========

	protected ModelAndView createEditModelAndView(Category category) {
		ModelAndView res;

		res = createEditModelAndView(category, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(Category category, String message) {
		ModelAndView res;

		res = new ModelAndView("category/edit");
		res.addObject("category", category);
		res.addObject("message", message);

		return res;
	}

}