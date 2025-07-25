package ra.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.model.dto.response.APIResponse;
import ra.edu.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @GetMapping
    public ResponseEntity<APIResponse<List<Product>>> getProducts() {
        List<Product> list = new ArrayList<>();

        list.add(new Product(1, "p01", "Tivi 65 inch 4K", 15000.0, 10));
        list.add(new Product(2, "p02", "Điện thoại thông minh", 8000.0, 25));
        list.add(new Product(3, "p03", "Máy tính bảng 10 inch", 6000.0, 15));
        list.add(new Product(4, "p04", "Xe máy điện", 20000.0, 5));
        list.add(new Product(5, "p05", "Ô tô điện mini", 500000.0, 2));
        list.add(new Product(6, "p06", "Xe đạp thể thao", 2500.0, 30));

        return new ResponseEntity<>(
                new APIResponse<>(true, "Get products successfully!", list, HttpStatus.OK),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<APIResponse<Product>> postProduct(@RequestBody Product product) {
        return new ResponseEntity<>(
                new APIResponse<>(true, "Post product successfully!", product, HttpStatus.CREATED),
                HttpStatus.CREATED
        );
    }
}
