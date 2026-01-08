public class CartItem {
    private int productId;
    private String name;
    private double unitPrice;
    private int quantity;
    private boolean addedToCart;

    public CartItem(String name,double unitPrice){
        this.productId = (int) (Math.random() * 10000);
        this.name=name;
        setUnitPrice(unitPrice);
        quantity=0;
        addedToCart=false;

    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAddedToCart() {
        return addedToCart;
    }


    public void setUnitPrice(double unitPrice){
        if(unitPrice>0){
            this.unitPrice=unitPrice;
        }else{
            throw new IllegalArgumentException("UnitPrice Cannot be 0 or negative");
        }
    }

    public void addToCart() {
        if (!addedToCart) {
            addedToCart = true;
            quantity = 1;
        }
    }

    public void removeFromCart() {
        if (addedToCart) {
            addedToCart = false;
            quantity = 0;
        }
    }

    public void incrementQuantity() {
        if (addedToCart) {
            quantity++;
        }
    }

    public void decrementQuantity() {
        if (addedToCart && quantity > 1) {
            quantity--;
        }
    }


    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public void display() {
        System.out.println(name + " | Qty: " + quantity + " | Unit: " + unitPrice +
                " | Total: " + getTotalPrice());
    }

}
