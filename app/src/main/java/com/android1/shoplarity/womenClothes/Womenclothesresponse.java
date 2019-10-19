
package com.android1.shoplarity.womenClothes;

import java.util.List;

import com.android1.shoplarity.womenClothes.Business;
import com.android1.shoplarity.womenClothes.Region;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Womenclothesresponse {

    @SerializedName("businesses")
    @Expose
    private List<Business> businesses = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("region")
    @Expose
    private Region region;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Womenclothesresponse() {
    }

    /**
     * 
     * @param total
     * @param region
     * @param businesses
     */
    public Womenclothesresponse(List<Business> businesses, Integer total, Region region) {
        super();
        this.businesses = businesses;
        this.total = total;
        this.region = region;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
