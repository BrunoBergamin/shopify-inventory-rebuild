package com.bruno.inventory.domain;

import com.bruno.inventory.exception.InsufficientStockException;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal unitPrice;
    private Instant createdAt;
    private Instant updatedAt;

    @Version
    private long version;

    protected InventoryItem() {
        // só para o JPA
    }

    public InventoryItem(String sku, String name, String description, int quantity, BigDecimal unitPrice) {
        applyDetails(sku, name, description, quantity, unitPrice);
    }

    private void applyDetails(String sku, String name, String description, int quantity, BigDecimal unitPrice) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public void update(String sku, String name, String description, int quantity, BigDecimal unitPrice) {
        applyDetails(sku, name, description, quantity, unitPrice);
    }

    private static void requirePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
    }

    public void removeStock(int amount) {
        requirePositive(amount);
        if (amount > quantity) {
            throw new InsufficientStockException(sku, quantity, amount);
        }
        quantity -= amount;
    }

    public void returnStock(int amount) {
        requirePositive(amount);
        quantity += amount;
    }

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public long getVersion() {
        return version;
    }
}
