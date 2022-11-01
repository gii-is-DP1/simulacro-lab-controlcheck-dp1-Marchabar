package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product/create")
    public ModelAndView addProduct(Product p){
        ModelAndView result = new ModelAndView("createOrUpdateProductForm");
        result.addObject("product", p);
        return result;


    }

    /*
    @GetMapping(path = "/create")
    public String createProduct(ModelMap model ){
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productService.findAllProductTypes());

        return CREATE_PRODUCT;

    }
    */ 

    @PostMapping("/product/create")
    public ModelAndView saveAddedProduct(@Valid Product p, BindingResult br){
        if(!br.hasErrors()){
            productService.save(p);
        }
        return new ModelAndView("redirect:/welcome");

    } 
    
}
