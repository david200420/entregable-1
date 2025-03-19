import models.Order;
import models.Product;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManagerImpl implements ProductManager {
    private List<Product> productList;
    private Queue<Order> orderQueue;
    private HashMap<String, User> users;
    private static final Logger logger = LogManager.getLogger(ProductManagerImpl.class);
    private static ProductManagerImpl instance;

    public static ProductManagerImpl getInstance() { //Se crea una instancia para poder tener una comun entre los diferentes clientes
        if (instance == null) {
            instance = new ProductManagerImpl();
        }
        return instance;
    }

    public ProductManagerImpl() {
        productList = new ArrayList<>();
        orderQueue = new LinkedList<>();
        users = new HashMap<>();
    }

    @Override
    public void addProduct(String id, String name, double price) {
        logger.info("Adding product with id " + id + " and name " + name);
        productList.add(new Product(id, name, price));

    }

    @Override
    public List<Product> getProductsByPrice() {
        logger.info("Getting products by price");
        productList.sort(Comparator.comparing(Product::getPreu).reversed());
        return productList;
    }

    @Override
    public void addOrder(Order order) {
        orderQueue.add(order);
        users.put(order.getUser(),order.getUser1());
    }

    @Override
    public int numOrders() {
        return orderQueue.size();
    }

    @Override
    public Order deliverOrder() {
        Order order = orderQueue.poll();
        return order;
    }

    public Order deliverOrder1(String name) {
        for (Order order : orderQueue) {
            if (order.getUser().equals(name)) {
                return order; // Devuelve la orden si el usuario coincide
            }
        }
        return null; // Si no encuentra ninguna orden con ese usuario
    }

    @Override
    public Product getProduct(String c1) {
            for (Product p : this.productList) {
                if (p.getId().equals(c1)) {
                    return p;
                }
            }
            return null;
    }

    @Override
    public User getUser(String number) {
        return users.get(number);
    }
}
