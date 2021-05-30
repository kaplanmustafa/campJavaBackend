package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAllByPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllDesc() {
        return productService.getAllSorted();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam("productName") String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameOrCategory(productName, categoryId);
    }

    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(@RequestParam("categoryId") List<Integer> categoryId) {
        return productService.getByCategoryIn(categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }
}
