import models.Order;
import models.Product;
import models.User;

import java.util.List;

public interface ProductManager {
    public Order deliverOrder1(String name);
    public void addProduct(String id, String name, double price);

    public List<Product> getProductsByPrice();

    public void addOrder(Order order);

    public int numOrders();


    public Order deliverOrder();

    Product getProduct(String c1);

    User getUser(String number);
}
