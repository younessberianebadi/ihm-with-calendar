package io.digiwise.ihmmt.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.beans.Transient;
import java.util.Date;
import java.util.List;

public class Objectif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String year;
    private String category;
    private String product;
    private String objectif;
    private String level;
    private String entity;
    private long january;
    private long february;
    private long march;
    private long april;
    private long may;
    private long june;
    private long july;
    private long august;
    private long september;
    private long october;
    private long november;
    private long december;
    private long total;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    private String createdBy;
    private String updatedBy;

//    @Transient
//    private List<Objectif> objectifs;

    public Objectif() {

    }

    public Objectif(long id, String year, String category, String product, String objectif, String level, String entity, long january, long february, long march, long april, long may, long june, long july, long august, long september, long october, long november, long december, long total, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.id = id;
        this.year = year;
        this.category = category;
        this.product = product;
        this.objectif = objectif;
        this.level = level;
        this.entity = entity;
        this.january = january;
        this.february = february;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.october = october;
        this.november = november;
        this.december = december;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getJanuary() {
        return january;
    }

    public void setJanuary(long january) {
        this.january = january;
    }

    public long getFebruary() {
        return february;
    }

    public void setFebruary(long february) {
        this.february = february;
    }

    public long getMarch() {
        return march;
    }

    public void setMarch(long march) {
        this.march = march;
    }

    public long getApril() {
        return april;
    }

    public void setApril(long april) {
        this.april = april;
    }

    public long getMay() {
        return may;
    }

    public void setMay(long may) {
        this.may = may;
    }

    public long getJune() {
        return june;
    }

    public void setJune(long june) {
        this.june = june;
    }

    public long getJuly() {
        return july;
    }

    public void setJuly(long july) {
        this.july = july;
    }

    public long getAugust() {
        return august;
    }

    public void setAugust(long august) {
        this.august = august;
    }

    public long getSeptember() {
        return september;
    }

    public void setSeptember(long september) {
        this.september = september;
    }

    public long getOctober() {
        return october;
    }

    public void setOctober(long october) {
        this.october = october;
    }

    public long getNovember() {
        return november;
    }

    public void setNovember(long november) {
        this.november = november;
    }

    public long getDecember() {
        return december;
    }

    public void setDecember(long december) {
        this.december = december;
    }

    public long sum() {
        return january + february + march + april + may + june + july + august + september + october + november
                + december;
    }

    public boolean check() {
        return total == sum();
    }

//    public List<Objectif> getObjectifs() {
//        return objectifs;
//    }
//
//    public void setObjectifs(List<Objectif> objectifs) {
//        this.objectifs = objectifs;
//    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
