package lab.controllers;

import lab.entity.OrderItem;
import lab.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderItemRESTController {
  @Autowired
  private OrderItemRepository repository;

  public OrderItemRepository getRepository() {
    return repository;
  }

  public void setRepository(OrderItemRepository repository) {
    this.repository = repository;
  }

  @GetMapping(value = "/orderItems")
  public List<OrderItem> getAllOrderItems() {
    return repository.findAll();
  }

  @Secured("ROLE_USER")
  @PostMapping("/orderItems")
  OrderItem createOrSaveOrderItem(@RequestBody OrderItem newOrderItem) {
    return repository.save(newOrderItem);
  }

  @Secured("ROLE_USER")
  @GetMapping("/orderItems/{id}")
  OrderItem getOrderItemById(@PathVariable Long id) {
    return repository.findById(id).get();
  }

  @Secured("ROLE_USER")
  @PutMapping("/orderItems/{id}")
  OrderItem updateOrderItem(@RequestBody OrderItem newOrderItem, @PathVariable Long id) {
    return repository.findById(id).map(OrderItem -> {
      OrderItem.setIsCompleted(newOrderItem.getIsCompleted());
      return repository.save(OrderItem);
    }).orElseGet(() -> {
      newOrderItem.setId(id);
      return repository.save(newOrderItem);
    });
  }

  @Secured("ROLE_USER")
  @DeleteMapping("/orderItems/{id}")
  void deleteOrderItem(@PathVariable Long id) {
    repository.deleteById(id);
  }

}