package ru.ensemplix.bot.attribute;

/**
 * Представляет расположение существа на карте.
 */
public class Location {

    /**
     * Текущие положение существа по оси X.
     */
    private double x;

    /**
     * Текущие положение существа по оси Y.
     */
    private double y;

    /**
     * Текущие положение существа по оси Z.
     */
    private double z;

    /**
     * Текущие положение существа тела существа.
     */
    private float yaw;

    /**
     * Текущие положение взгляда существа.
     */
    private float pitch;

    /**
     * Текущие положение существа по оси X.
     */
    public double getX() {
        return x;
    }

    /**
     * Установить новую координату существа по оси X.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Текущие положение существа по оси Y.
     */
    public double getY() {
        return y;
    }

    /**
     * Установить новую координату существа по оси Y.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Текущие положение игрока по оси Z.
     */
    public double getZ() {
        return z;
    }

    /**
     * Установить новую координату существа по оси Z.
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Текущие положение туловища существа.
     */
    public float getYaw() {
        return yaw;
    }

    /**
     * Установить новое положение туловища существа.
     */
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    /**
     * Текущие положение взгляда существа.
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * Установить новое положение взгляда существа.
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

}
