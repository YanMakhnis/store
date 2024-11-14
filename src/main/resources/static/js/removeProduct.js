function removeProduct(button) {
    const productItem = button.parentElement;
    const productId = productItem.dataset.productId

    fetch(`/api/products/id/${productId}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.ok) {
                productItem.remove();
            } else {
                console.error('Error while removing product');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}