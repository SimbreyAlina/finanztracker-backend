package de.finance.finanztracker;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "https://finanztracker-frontend.onrender.com")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getCategories() {
        List<Category> list = categoryRepository.findAll();
        // Initiales Setup: Wenn leer, erstelle "Sonstiges" für beide Typen
        if (list.isEmpty()) {
            categoryRepository.save(new Category("Sonstiges", "revenue"));
            categoryRepository.save(new Category("Sonstiges", "expense"));
            return categoryRepository.findAll();
        }
        return list;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updated) {
        Category existing = categoryRepository.findById(id).orElseThrow();
        if (existing.getName().equals("Sonstiges")) return existing; // Schutz
        existing.setName(updated.getName());
        return categoryRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        Category existing = categoryRepository.findById(id).orElseThrow();
        if (!existing.getName().equals("Sonstiges")) {
            categoryRepository.deleteById(id);
        }
    }
}
