package ru.ensemplix.bot.entity;

import org.spacehq.mc.protocol.data.game.EntityMetadata;
import ru.ensemplix.bot.attribute.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Представляет живое существо на сервере.
 */
public class Entity {

    /**
     * Уникальный индификатор существа.
     */
    protected int id;

    /**
     * Расположение существа на карте.
     */
    protected Location location = new Location();

    /**
     * Параметры существа.
     */
    protected List<EntityMetadata> metadata = new ArrayList<>();

    public Entity(int id) {
        this.id = id;
    }

    /**
     * Уникальный индификатор существа.
     */
    public int getId() {
        return id;
    }

    /**
     * Расположение существа на карте.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Параметры существа.
     */
    public List<EntityMetadata> getMetadata() {
        return metadata;
    }

}
