package org.example.json;

public class DataSeries {
    private Integer timepoint;
    private Integer cloudcover;
    private Integer seeing;
    private Integer transparency;
    private Integer lifted_index;
    private Integer rh2m;
    private Wind wind10m;
    private Integer temp2m;
    private String prec_type;

    @Override
    public String toString() {
        return "DataSeries{" +
                "timepoint=" + timepoint +
                ", cloudcover=" + cloudcover +
                ", seeing=" + seeing +
                ", transparency=" + transparency +
                ", lifted_index=" + lifted_index +
                ", rh2m=" + rh2m +
                ", wind10m=" + wind10m +
                ", temp2m=" + temp2m +
                ", prec_type='" + prec_type + '\'' +
                '}';
    }

    public Integer getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(Integer timepoint) {
        this.timepoint = timepoint;
    }

    public Integer getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(Integer cloudcover) {
        this.cloudcover = cloudcover;
    }

    public Integer getSeeing() {
        return seeing;
    }

    public void setSeeing(Integer seeing) {
        this.seeing = seeing;
    }

    public Integer getTransparency() {
        return transparency;
    }

    public void setTransparency(Integer transparency) {
        this.transparency = transparency;
    }

    public Integer getLifted_index() {
        return lifted_index;
    }

    public void setLifted_index(Integer lifted_index) {
        this.lifted_index = lifted_index;
    }

    public Integer getRh2m() {
        return rh2m;
    }

    public void setRh2m(Integer rh2m) {
        this.rh2m = rh2m;
    }

    public Wind getWind10m() {
        return wind10m;
    }

    public void setWind10m(Wind wind10m) {
        this.wind10m = wind10m;
    }

    public Integer getTemp2m() {
        return temp2m;
    }

    public void setTemp2m(Integer temp2m) {
        this.temp2m = temp2m;
    }

    public String getPrec_type() {
        return prec_type;
    }

    public void setPrec_type(String prec_type) {
        this.prec_type = prec_type;
    }
}
