function loadCategoryProducts(category) {
    fetch(`/products/category/${category}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to load products");
            }
            return response.text(); // Ожидаем HTML-фрагмент
        })
        .then(html => {
            document.querySelector('.main-content .catalog').innerHTML = html; // Обновляем только каталог продуктов
        })
        .catch(error => console.error("Error loading products:", error));
}