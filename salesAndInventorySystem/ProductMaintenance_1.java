/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesAndInventorySystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "product_maintenance", catalog = "el_coco_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProductMaintenance_1.findAll", query = "SELECT p FROM ProductMaintenance_1 p")
    , @NamedQuery(name = "ProductMaintenance_1.findByProductId", query = "SELECT p FROM ProductMaintenance_1 p WHERE p.productId = :productId")
    , @NamedQuery(name = "ProductMaintenance_1.findByFlavor", query = "SELECT p FROM ProductMaintenance_1 p WHERE p.flavor = :flavor")
    , @NamedQuery(name = "ProductMaintenance_1.findBySize", query = "SELECT p FROM ProductMaintenance_1 p WHERE p.size = :size")
    , @NamedQuery(name = "ProductMaintenance_1.findByPrice", query = "SELECT p FROM ProductMaintenance_1 p WHERE p.price = :price")
    , @NamedQuery(name = "ProductMaintenance_1.findByStocks", query = "SELECT p FROM ProductMaintenance_1 p WHERE p.stocks = :stocks")})
public class ProductMaintenance_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "flavor")
    private String flavor;
    @Column(name = "size")
    private String size;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "stocks")
    private Integer stocks;

    public ProductMaintenance_1() {
    }

    public ProductMaintenance_1(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        Integer oldProductId = this.productId;
        this.productId = productId;
        changeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        String oldFlavor = this.flavor;
        this.flavor = flavor;
        changeSupport.firePropertyChange("flavor", oldFlavor, flavor);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        String oldSize = this.size;
        this.size = size;
        changeSupport.firePropertyChange("size", oldSize, size);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        BigDecimal oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        Integer oldStocks = this.stocks;
        this.stocks = stocks;
        changeSupport.firePropertyChange("stocks", oldStocks, stocks);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductMaintenance_1)) {
            return false;
        }
        ProductMaintenance_1 other = (ProductMaintenance_1) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "salesAndInventorySystem.ProductMaintenance_1[ productId=" + productId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
