package org.example.json;

public class Wind {
    private  String direction;
    private Integer speed;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "direction='" + direction + '\'' +
                ", speed=" + speed +
                '}';
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
