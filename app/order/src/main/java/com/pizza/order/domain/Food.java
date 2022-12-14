package com.pizza.order.domain;

import org.springframework.data.annotation.Id;

public class Food {
   @Id
   String foodName;
   int foodPrice;

   public Food() {
   }

  public Food(String foodName, int foodPrice) {
    this.foodName = foodName;
    this.foodPrice = foodPrice;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public int getFoodPrice() {
    return foodPrice;
  }

  public void setFoodPrice(int foodPrice) {
    this.foodPrice = foodPrice;
  }

  @Override
  public String toString() {
    return "Food{" +
            "foodName='" + foodName + '\'' +
            ", foodPrice=" + foodPrice +
            '}';
  }
}
